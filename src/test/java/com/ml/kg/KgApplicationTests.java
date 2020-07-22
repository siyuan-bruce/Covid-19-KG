package com.ml.kg;

import com.alibaba.fastjson.JSON;
import com.ml.kg.util.Neo4jUtil;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.neo4j.driver.Result;
import org.neo4j.driver.internal.SessionFactoryImpl;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = KgApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
class KgApplicationTests {

    @Autowired
    private Neo4jUtil neo4jUtil;


//    @Test
//    void contextLoads() {
//    }



    @Test
    public void contextLoads() {

//        String cyphersql="MATCH (n{name:'学生'}) RETURN n";
        String cyphersql="MATCH (n{name:'蓝月亮芦荟抑菌洗手液'})-[r]-(m) RETURN n,r";

//        System.out.println(neo4jUtil.isNeo4jOpen());
        HashMap<String, Object> result=neo4jUtil.GetGraphNodeAndShip(cyphersql);
        System.out.println(JSON.toJSON(result));
    }

}
