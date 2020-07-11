//package com.ml.kg.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.neo4j.driver.v1.AuthTokens;
//import org.neo4j.driver.v1.Driver;
//import org.neo4j.driver.v1.GraphDatabase;
//import org.neo4j.driver.v1.Record;
//import org.neo4j.driver.v1.Session;
//import org.neo4j.driver.v1.Result;
//import static org.neo4j.driver.v1.Values.parameters;
//
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ml.kg.pojo.RestfulResult;
////import com.inesa.common.utils.CommUtils;
//import com.ml.kg.util.Constants;
//import com.ml.kg.pojo.Code2;
//
///**
// * Controller
// *
// * @author sun
// * @version 2018-06-01
// */
//@RestController
//@RequestMapping(value = "neo4j")
//public class Code2Controller {
//
//    private Driver createDrive(){
//        return GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( "neo4j", "neo4j" ) );
//    }
//
//
//    @RequestMapping(value = "search")
//    public List<String> search(HttpServletRequest request, HttpServletResponse response,
//                       @RequestBody Code2 code) {
//        RestfulResult restfulResult = new RestfulResult();
//        List<String> resultList = new ArrayList<String>();
//        try{
//            Driver driver = createDrive();
//            Session session = driver.session();
//
//            Result result = session.run("(n{name:"+code.getName()+"}) RETURN n LIMIT 25");
//            while ( result.hasNext() )
//            {
//                Record record = result.next();
//                resultList.add(record.get("id").toString() + " " + record.get("name").toString());
//            }
//
//            session.close();
//            driver.close();
//
//            restfulResult.setData(resultList);
//
//        }catch(Exception e){
//            restfulResult.setResult(Constants.RESULT_STATE_ERROR);
//            restfulResult.setMessage(e.getMessage());
//        }
//
//        return resultList;
//    }
//
////    @RequestMapping(value = "relate")
////    public void relate(HttpServletRequest request, HttpServletResponse response,
////                       @RequestBody Code2 code) {
////        RestfulResult restfulResult = new RestfulResult();
////
////        try{
////            Driver driver = createDrive();
////            Session session = driver.session();
////
////            session.run("MATCH (a:" + code.getNodeFromLabel() + "), (b:" + code.getNodeToLabel() + ") " +
////                    "WHERE ID(a) = " + code.getNodeFromId() + " AND ID(b) = " + code.getNodeToId()
////                    + " CREATE (a)-[:" + code.getRelation() + "]->(b)");
////
////            session.close();
////            driver.close();
////
////        }catch(Exception e){
////            restfulResult.setResult(Constants.RESULT_STATE_ERROR);
////            restfulResult.setMessage(e.getMessage());
////        }
////
////        CommUtils.printDataJason(response, restfulResult);
////    }
//
//    //private static final String DB_PATH = "D:/neo4j/data/databases/graph.db";
//
//    //GraphDatabaseService graphDb;
//
//	/*@RequestMapping(value = "save")
//	public void save(HttpServletRequest request, HttpServletResponse response,
//			@RequestBody Code code) {
//
//		RestfulResult restfulResult = new RestfulResult();
//
//		try{
//			if (graphDb == null)
//				this.graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(DB_PATH));
//
//			registerShutdownHook(graphDb);
//
//			Transaction tx = graphDb.beginTx();
//
//			Node node = this.graphDb.createNode();
//			Label label = DynamicLabel.label(code.getLabel());
//			node.addLabel(label);
//			node.setProperty("Name", code.getProperty());
//
//            tx.success();
//
//            restfulResult.setData(node.getId());
//
//		}catch(Exception e){
//			restfulResult.setResult(Constants.RESULT_STATE_ERROR);
//			restfulResult.setMessage(e.getMessage());
//		}
//
//    	CommUtils.printDataJason(response, restfulResult);
//	}*/
//
///*    private void registerShutdownHook(final GraphDatabaseService graphDB){
//        //关闭寄存器
//        Runtime.getRuntime().addShutdownHook(new Thread(){
//            public void run(){
//                graphDB.shutdown();
//            }
//        });
//    }*/
//}