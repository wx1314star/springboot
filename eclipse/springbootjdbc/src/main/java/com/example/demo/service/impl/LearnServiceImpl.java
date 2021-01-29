package com.example.demo.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LearnDao;
import com.example.demo.domain.LearnResource;
import com.example.demo.service.LearnService;
import com.example.demo.tools.Page;

@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    private LearnDao learnDao;

    @Override
    public int add(LearnResource learnResource) {
        return learnDao.add(learnResource);
    }

    @Override
    public int update(LearnResource learnResource) {
        return learnDao.update(learnResource);
    }

    @Override
    public int deleteByIds(String ids) {
        return learnDao.deleteByIds(ids);
    }

    @Override
    public LearnResource queryLearnResouceById(Long id) {
        return learnDao.queryLearnResouceById(id);
    }

    @Override
    public Page queryLearnResourceList(Map<String, Object> params) {
        return learnDao.queryLearnResourceList(params);
    }

}
