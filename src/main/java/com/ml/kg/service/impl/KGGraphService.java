package com.ml.kg.service.impl;

import com.ml.kg.dal.IKGraphRepository;
import com.ml.kg.query.GraphQuery;
import com.ml.kg.service.IKGGraphService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KGGraphService implements IKGGraphService {

    @Autowired
    @Qualifier("KGraphRepository")
    private IKGraphRepository kgRepository;


    @Override
    public HashMap<String, Object> getdomaingraph(GraphQuery query) {
        return kgRepository.getdomaingraph(query);
    }

    @Override
    public HashMap<String, Object> getdomainnodes(String domain, Integer pageIndex, Integer pageSize) {
        return kgRepository.getdomainnodes(domain, pageIndex, pageSize);
    }

    @Override
    public long getrelationnodecount(String domain, long nodeid) {
        return kgRepository.getrelationnodecount(domain, nodeid);
    }


    @Override
    public HashMap<String, Object> getmorerelationnode(String domain, String nodeid) {
        return kgRepository.getmorerelationnode(domain, nodeid);
    }



	

}
