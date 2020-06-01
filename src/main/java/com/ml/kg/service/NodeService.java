package com.ml.kg.service;

import com.ml.kg.dao.NodeDao;
import com.ml.kg.pojo.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeService {
    @Autowired
    NodeDao nodeDao;

    public Node findByName(String name){
        return nodeDao.findByName(name);
    }

    public Iterable<Node> findAll(){
        return nodeDao.findAll();
    }

}
