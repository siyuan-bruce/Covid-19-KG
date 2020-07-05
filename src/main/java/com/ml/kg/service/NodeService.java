//package com.ml.kg.service;
//
//import com.ml.kg.dao.NodeDao;
//import com.ml.kg.pojo.Node;
//import com.ml.kg.pojo.Node2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
//@Service
//public class NodeService {
//    @Autowired
//    NodeDao nodeDao;
//
//    public Node findByName(String name){
//        return nodeDao.findByName(name);
//    }
//
//    public Iterable<Node> findAll(){
//        return nodeDao.findAll();
//    }
//
//    public Set<Node2> getNode2ByRelationship(Node node,String rel){
//        if(rel.equals("适用人群")){
//            return node.getApplicable();
//        }
//        else{
//            return null;
//        }
//    }
//
//
//}
