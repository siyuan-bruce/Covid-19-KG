package com.ml.kg.dao;

import com.ml.kg.pojo.Node;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface NodeDao extends Neo4jRepository<Node,Long> {
    Node findByName(String name);
}
