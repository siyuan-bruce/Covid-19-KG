package com.ml.kg.dal.impl;

import com.alibaba.fastjson.JSON;
import com.ml.kg.dal.IKGraphRepository;
import com.ml.kg.query.GraphQuery;
import com.ml.kg.util.Neo4jUtil;
import com.ml.kg.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KGraphRepository implements IKGraphRepository {
	@Autowired
	private Neo4jUtil neo4jUtil;

	/**
	 * 查询图谱节点和关系
	 * 
	 * @param query
	 * @return node relationship
	 */
	public HashMap<String, Object> getdomaingraph(GraphQuery query) {
		HashMap<String, Object> nr = new HashMap<String, Object>();
		try {
			String domain = query.getDomain();
			// MATCH (n:`症状`) -[r]-(m:症状) where r.name='治疗' or r.name='危险因素' return n,m
			if (!StringUtil.isBlank(domain)) {
				String cqr = "";
				List<String> lis = new ArrayList<String>();
				if (query.getRelation() != null && query.getRelation().length > 0) {
					for (String r : query.getRelation()) {
						String it = String.format("r.name='%s'", r);
						lis.add(it);
					}
					cqr = String.join(" or ", lis);
				}
				String cqWhere = "";
				if (!StringUtil.isBlank(query.getNodename()) || !StringUtil.isBlank(cqr)) {

					if (!StringUtil.isBlank(query.getNodename())) {
						if (query.getMatchtype() == 1) {
							cqWhere = String.format("where n.name ='%s' ", query.getNodename());

						} else {
							cqWhere = String.format("where n.name contains('%s')", query.getNodename());
						}
					}
					String nodeOnly = cqWhere;
					if (!StringUtil.isBlank(cqr)) {
						if (StringUtil.isBlank(cqWhere)) {
							cqWhere = String.format(" where ( %s )", cqr);

						} else {
							cqWhere += String.format(" and ( %s )", cqr);
						}

					}
					// 下边的查询查不到单个没有关系的节点,考虑要不要左箭头
					String nodeSql = String.format("MATCH (n:`%s`) <-[r]->(m) %s return * limit %s", domain, cqWhere,
							query.getPageSize());
					HashMap<String, Object> graphNode = neo4jUtil.GetGraphNodeAndShip(nodeSql);
					Object node = graphNode.get("node");
					// 没有关系显示则显示节点
					if (node != null) {
						nr.put("node", graphNode.get("node"));
						nr.put("relationship", graphNode.get("relationship"));
					} else {
						String nodecql = String.format("MATCH (n:`%s`) %s RETURN distinct(n) limit %s", domain,
								nodeOnly, query.getPageSize());
						List<HashMap<String, Object>> nodeItem = neo4jUtil.GetGraphNode(nodecql);
						nr.put("node", nodeItem);
						nr.put("relationship", new ArrayList<HashMap<String, Object>>());
					}
				} else {
					String nodeSql = String.format("MATCH (n:`%s`) %s RETURN distinct(n) limit %s", domain, cqWhere,
							query.getPageSize());
					List<HashMap<String, Object>> graphNode = neo4jUtil.GetGraphNode(nodeSql);
					nr.put("node", graphNode);
					String domainSql = String.format("MATCH (n:`%s`)<-[r]-> (m) %s RETURN distinct(r) limit %s", domain,
							cqWhere, query.getPageSize());// m是否加领域
					List<HashMap<String, Object>> graphRelation = neo4jUtil.GetGraphRelationShip(domainSql);
					nr.put("relationship", graphRelation);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nr;
	}

	/**
	 * 获取节点列表
	 * 
	 * @param domain
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public HashMap<String, Object> getdomainnodes(String domain, Integer pageIndex, Integer pageSize) {
		HashMap<String, Object> resultItem = new HashMap<String, Object>();
		List<HashMap<String, Object>> ents = new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> concepts = new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> props = new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> methods = new ArrayList<HashMap<String, Object>>();
		List<HashMap<String, Object>> entitys = new ArrayList<HashMap<String, Object>>();
		try {
			int skipCount = (pageIndex - 1) * pageSize;
			int limitCount = pageSize;
			String domainSql = String.format("START n=node(*) MATCH (n:`%s`) RETURN n SKIP %s LIMIT %s", domain,
					skipCount, limitCount);
			if (!StringUtil.isBlank(domain)) {
				ents = neo4jUtil.GetGraphNode(domainSql);
				for (HashMap<String, Object> hashMap : ents) {
					Object et = hashMap.get("entitytype");
					if (et != null) {
						String typeStr = et.toString();
						if (StringUtil.isNotBlank(typeStr)) {
							int type = Integer.parseInt(et.toString());
							if (type == 0) {
								concepts.add(hashMap);
							} else if (type == 1) {
								entitys.add(hashMap);
							} else if (type == 2 || type == 3) {
								props.add(hashMap);// 属性和方法放在一起展示
							} else {
								// methods.add(hashMap);
							}
						}
					}
				}
				resultItem.put("concepts", concepts);
				resultItem.put("props", props);
				resultItem.put("methods", methods);
				resultItem.put("entitys", entitys);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultItem;
	}

	/**
	 * 获取某个领域指定节点拥有的上下级的节点数
	 * 
	 * @param domain
	 * @param nodeid
	 * @return long 数值
	 */
	public long getrelationnodecount(String domain, long nodeid) {
		long totalcount = 0;
		try {
			if (!StringUtil.isBlank(domain)) {
				String nodeSql = String.format("MATCH (n:`%s`) <-[r]->(m)  where id(n)=%s return count(m)", domain,
						nodeid);
				totalcount = neo4jUtil.GetGraphValue(nodeSql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalcount;
	}


	/**
	 * 获取/展开更多节点,找到和该节点有关系的节点
	 * 
	 * @param domain
	 * @param nodeid
	 * @return
	 */
	public HashMap<String, Object> getmorerelationnode(String domain, String nodeid) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			String cypherSql = String.format("MATCH (n:`%s`) -[r]-(m) where id(n)=%s  return * limit 100", domain,
					nodeid);
			result = neo4jUtil.GetGraphNodeAndShip(cypherSql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public void updateNodeFileStatus(String domain, long nodeId, int status) {
		try {
			String nodeCypher = String.format("match (n:`%s`) where id(n)=%s set n.hasfile=%s ", domain,nodeId, status);
			neo4jUtil.excuteCypherSql(nodeCypher);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
