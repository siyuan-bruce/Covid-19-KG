package com.ml.kg.service;


import com.ml.kg.query.GraphQuery;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IKGGraphService {


	/**
	 * 查询图谱节点和关系
	 * 
	 * @param query
	 * @return node relationship
	 */
	HashMap<String, Object> getdomaingraph(GraphQuery query);

	/**
	 * 获取节点列表
	 * 
	 * @param domain
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	HashMap<String, Object> getdomainnodes(String domain, Integer pageIndex, Integer pageSize);

	/**
	 * 获取某个领域指定节点拥有的上下级的节点数
	 * 
	 * @param domain
	 * @param nodeid
	 * @return long 数值
	 */
	long getrelationnodecount(String domain, long nodeid);



	/**
	 * 获取/展开更多节点,找到和该节点有关系的节点
	 * 
	 * @param domain
	 * @param nodeid
	 * @return
	 */
	HashMap<String, Object> getmorerelationnode(String domain, String nodeid);


}
