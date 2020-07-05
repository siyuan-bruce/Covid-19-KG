//package com.ml.kg.pojo;
//
//import org.neo4j.ogm.annotation.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@NodeEntity(label = "学生")
//public class Node {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @Property(name = "name")
//    private String name;
//
//    @Property(name = "前提条件")
//    private String precondition;
//
//    @Property(name = "措施主题")
//    private String measureTheme;
//
//    @Property(name = "措施描述")
//    private String measureDescriptions;
//
//    @Relationship(type = "适用人群",direction = Relationship.INCOMING)
//    private Set<Node2> applicable = new HashSet<>();
//
//    public Set<Node2> getApplicable() {
//        return applicable;
//    }
//
//    public void setApplicable(Set<Node2> applicable) {
//        this.applicable = applicable;
//    }
//
//    private Node() {
//        // Empty constructor required as of Neo4j API 2.0.5
//    }
//
//    public Node(String name, String precondition, String measureTheme, String measureDescriptions) {
//        this.name = name;
//        this.precondition = precondition;
//        this.measureTheme = measureTheme;
//        this.measureDescriptions = measureDescriptions;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPrecondition() {
//        return precondition;
//    }
//
//    public void setPrecondition(String precondition) {
//        this.precondition = precondition;
//    }
//
//    public String getMeasureTheme() {
//        return measureTheme;
//    }
//
//    public void setMeasureTheme(String measureTheme) {
//        this.measureTheme = measureTheme;
//    }
//
//    public String getMeasureDescriptions() {
//        return measureDescriptions;
//    }
//
//    public void setMeasureDescriptions(String measureDescriptions) {
//        this.measureDescriptions = measureDescriptions;
//    }
//}
