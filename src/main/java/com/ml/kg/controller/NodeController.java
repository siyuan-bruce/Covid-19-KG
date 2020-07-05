//package com.ml.kg.controller;
//
//
//import com.ml.kg.pojo.CustomLink;
//import com.ml.kg.pojo.CustomNode;
//import com.ml.kg.pojo.Node;
//import com.ml.kg.pojo.Node2;
//import com.ml.kg.service.NodeService;
//import com.ml.kg.pojo.Node2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/api/node")
//public class NodeController {
//
//    @Autowired
//    NodeService nodeService;
//
//    @GetMapping("/{name}")
//    public CustomNode findByName(@PathVariable("name") String name){
////        return NodeService.findByName(name);
//        Node node = nodeService.findByName(name);
//        return new CustomNode(node.getName(),1,node);
//    }
//
//    @GetMapping("/query/{relationship}/{name}")
//    public List<CustomNode> findRelationships(@PathVariable("relationship") String rel,@PathVariable("name") String name){
////        return NodeService.findByName(name);
//        Node node = nodeService.findByName(name);
//        List<CustomNode> customNodes = new ArrayList<>();
//        Set<Node2> measureSet = nodeService.getNode2ByRelationship(node,rel);
//        for(Node2 node2 : measureSet){
//            customNodes.add(new CustomNode(node2.getName(),2,node2));
////            customLinks.add(new CustomLink(node.getName(),node2.getName(),5));
//        }
//        return customNodes;
////        return new CustomNode(node.getName(),1);
//    }
//
//    @GetMapping("/all")
//    public List<CustomNode> findAll(){
//        Iterable<Node> NodeIterable = nodeService.findAll();
//        List<CustomNode> customNodes = new ArrayList<>();
//        for(Node node : NodeIterable){
//            customNodes.add(new CustomNode(node.getName(),1,node));
//            System.out.println(node.getName());
//        }
//        return customNodes;
//    }
//}
