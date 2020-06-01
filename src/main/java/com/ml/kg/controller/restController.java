package com.ml.kg.controller;


import com.ml.kg.service.keywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
