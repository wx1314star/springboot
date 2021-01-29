package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.domain.LearnResource;

public interface LearnService {
    int add(LearnResource learnResource);

    int update(LearnResource learnResource);

    int deleteByIds(String[] ids);

    LearnResource queryLearnResouceById(Long id);

    List<LearnResource> queryLearnResourceList(Map<String, Object> params);
}
