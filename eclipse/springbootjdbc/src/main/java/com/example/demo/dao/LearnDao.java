package com.example.demo.dao;

import java.util.Map;

import com.example.demo.domain.LearnResource;
import com.example.demo.tools.Page;

public interface LearnDao {
    int add(LearnResource learnResource);

    int update(LearnResource learnResource);

    int deleteByIds(String ids);

    LearnResource queryLearnResouceById(Long id);

    Page queryLearnResourceList(Map<String, Object> params);
}
