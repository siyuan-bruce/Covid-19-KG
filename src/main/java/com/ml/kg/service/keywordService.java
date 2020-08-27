package com.ml.kg.service;


import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class keywordService {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    public List<Map<String,Object>> searchKeyword(String keyword, int pageSize) throws IOException {

        if(pageSize<=3){
            pageSize = 3;
        }

        SearchRequest searchRequest = new SearchRequest("covid-19");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.from(0);
        searchSourceBuilder.size(pageSize);

        //模糊查询
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("name", keyword);
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //精确匹配
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", keyword);
//        searchSourceBuilder.query(termQueryBuilder);
//        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));


        //实现搜索高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        highlightBuilder.requireFieldMatch(false);//多个高亮
        highlightBuilder.preTags("<span style= 'color:red'>");
        highlightBuilder.postTags("</span>");
        SearchSourceBuilder highlighter = searchSourceBuilder.highlighter(highlightBuilder);



        //搜索
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //解析结果
        ArrayList<Map<String,Object>> list = new ArrayList<>();


        for(SearchHit documentField:response.getHits().getHits()) {


            //封装结果高亮
            Map<String, HighlightField> highlightFields = documentField.getHighlightFields();
            HighlightField title = highlightFields.get("name");

            Map<String,Object> sourceAsMap = documentField.getSourceAsMap();

            if(title!= null){
                Text[] fragements = title.fragments();
                String n_title="";
                for( Text fragment:fragements){
                    n_title += fragment;
                }
                String oldtitle = (String) sourceAsMap.get("name");

                sourceAsMap.put("oldtitle",oldtitle);

                sourceAsMap.put("title",n_title);

            }

            list.add(sourceAsMap);

        }



        return list;
    }


    public void writeHotSpot(String keyword) throws IOException {
        SearchRequest searchRequest = new SearchRequest("covid-19");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.from(0);
        searchSourceBuilder.size(1);

        //模糊查询
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("name", keyword);
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //搜索
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);


        //解析结果
        ArrayList<Map<String,Object>> list = new ArrayList<>();




        SearchHit[] hits = response.getHits().getHits();
        System.out.println(hits.length);
        SearchHit documentField = hits[0];
        Map<String,Object> sourceAsMap = documentField.getSourceAsMap();
        int clickNum;
        if (sourceAsMap.get("clickNum")==null){
            clickNum = 1;
        }else {
         clickNum = (int)sourceAsMap.get("clickNum")  + 1;
        }
        sourceAsMap.put("clickNum",clickNum);


        String id = documentField.getId();;
        UpdateRequest request = new UpdateRequest("covid-19", id);

        request.doc(JSON.toJSONString(sourceAsMap), XContentType.JSON);
        UpdateResponse index = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(index.status());

    }

    public List<Map<String,Object>> searchAll() throws IOException {


        SearchRequest searchRequest = new SearchRequest("covid-19");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10);

        //模糊查询
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("Common","Common");
        searchSourceBuilder.sort(new FieldSortBuilder("clickNum").order(SortOrder.DESC));
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));




        //搜索
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        //解析结果
        ArrayList<Map<String,Object>> list = new ArrayList<>();
        for(SearchHit documentField:response.getHits().getHits()) {

            Map<String,Object> sourceAsMap = documentField.getSourceAsMap();
//            System.out.println(sourceAsMap.get("clickNum"));
            list.add(sourceAsMap);

        }



        return list;
    }



}
