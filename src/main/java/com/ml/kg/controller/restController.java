package com.ml.kg.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ml.kg.bean.hotSpotInfo;
import com.ml.kg.service.keywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class restController {

    @Autowired
    keywordService keywordService;

    @GetMapping("search/{keyword}")
    public List<String> search(@PathVariable("keyword") String keyword) throws IOException {
        System.out.println("====");
        List<String> list = new ArrayList<String>();

        List<Map<String, Object>> maps = keywordService.searchKeyword(keyword, 5);
        for(Map<String,Object> el:maps){
            list.add((String) el.get("title"));
        }


        return list;

    }


    @PutMapping("writeHotSpot")
    public void writeHotSpot(@RequestBody String name) throws IOException {
        System.out.println("==hot==");

        JSONObject jsonObject = JSON.parseObject(name);

        String name1 = (String) jsonObject.get("name");
        System.out.println(name1);
        name=name1.replaceAll("<span style= 'color:red'>", "");
        name=name.replaceAll("</span>", "");
        name=name.replaceAll("", "");
        System.out.println(name);


        keywordService.writeHotSpot(name);

    }


    @GetMapping("/searchHotSpot")
    public List<String> searchHotSpot() throws IOException {
        System.out.println("==hotsport==");
        List<String> list = new ArrayList<String>();

        List<Map<String, Object>> maps = keywordService.searchAll();
        for(Map<String,Object> el:maps){
            list.add((String) el.get("name"));
        }

        return list;

    }
}
