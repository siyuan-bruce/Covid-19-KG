package com.ml.kg.controller;



import com.ml.kg.query.GraphQuery;
import com.ml.kg.service.IKGGraphService;
import com.ml.kg.util.Neo4jUtil;
import com.ml.kg.util.R;
import com.ml.kg.util.StringUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

//import static javafx.scene.input.KeyCode.R;

@Controller
@RequestMapping(value = "/graph")
public class KGManagerController extends BaseController {
	@Autowired
	private Neo4jUtil neo4jUtil;

	@Autowired
	private IKGGraphService KGGraphService;




	@ResponseBody
	@RequestMapping(value = "/getdomaingraph")
	public com.ml.kg.util.R<HashMap<String, Object>> getDomainGraph(GraphQuery query) {
		R<HashMap<String, Object>> result = new R<HashMap<String, Object>>();
		try {
			HashMap<String, Object> graphData = KGGraphService.getdomaingraph(query);
			result.code = 200;
			result.data = graphData;
			
		} catch (Exception e) {
			e.printStackTrace();
			result.code = 500;
			result.setMsg("服务器错误");
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getcypherresult/{relationship}/{name}")
	public R<HashMap<String, Object>> getcypherresult(@PathVariable("relationship") String rel ,@PathVariable("name") String name) {
		String cypher = "MATCH (m{name:'"+name+"'})-[:"+rel+"]-(n) RETURN n";
		R<HashMap<String, Object>> result = new R<HashMap<String, Object>>();
		String error="";
		try {
			HashMap<String, Object> graphData = neo4jUtil.GetGraphNodeAndShip(cypher);
			result.code = 200;
			result.data = graphData;
		} catch (Exception e) {
			e.printStackTrace();
			result.code = 500;
			error=e.getMessage();
			result.setMsg("服务器错误");
		}
		finally {
			if(StringUtil.isNotBlank(error)){
				result.code = 500;
				result.setMsg(error);
			}
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getcypherresult/{name}")
	public R<HashMap<String, Object>> getcypherNoderesult(@PathVariable("name") String name) {
		String cypher = "MATCH (n{name:'"+name+"'}) RETURN n";
		R<HashMap<String, Object>> result = new R<HashMap<String, Object>>();
		String error="";
		try {
			HashMap<String, Object> graphData = neo4jUtil.GetGraphNodeAndShip(cypher);
			result.code = 200;
			result.data = graphData;
		} catch (Exception e) {
			e.printStackTrace();
			result.code = 500;
			error=e.getMessage();
			result.setMsg("服务器错误");
		}
		finally {
			if(StringUtil.isNotBlank(error)){
				result.code = 500;
				result.setMsg(error);
			}
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getrelationnodecount")
	public R<String> getrelationnodecount(String domain, long nodeid) {
		R<String> result = new R<String>();
		try {
			long totalcount = 0;
			if (!StringUtil.isBlank(domain)) {
				totalcount = KGGraphService.getrelationnodecount(domain, nodeid);
				result.code = 200;
				result.setData(String.valueOf(totalcount));
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.code = 500;
			result.setMsg("服务器错误");
		}
		return result;
	}



	@ResponseBody
	@RequestMapping(value = "/getmorerelationnode")
	public R<HashMap<String, Object>> getmorerelationnode(String domain, String nodeid) {
		R<HashMap<String, Object>> result = new R<HashMap<String, Object>>();
		try {
			if (!StringUtil.isBlank(domain)) {
				HashMap<String, Object> graphModel = KGGraphService.getmorerelationnode(domain, nodeid);
				if (graphModel != null) {
					result.code = 200;
					result.setData(graphModel);
					return result;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.code = 500;
			result.setMsg("服务器错误");
		}
		return result;
	}


	
}
