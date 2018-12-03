package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LearnMapper;
import com.example.demo.domain.LearnResource;
import com.example.demo.service.LearnService;
import com.github.pagehelper.PageHelper;

@Service
public class LearnServiceImpl implements LearnService {

	@Autowired
	private LearnMapper learnMapper;

	@Override
	public int add(LearnResource learnResource) {
		return learnMapper.add(learnResource);
	}

	@Override
	public int update(LearnResource learnResource) {
		return learnMapper.update(learnResource);
	}

	@Override
	public int deleteByIds(String[] ids) {
		return learnMapper.deleteByIds(ids);
	}

	@Override
	public LearnResource queryLearnResouceById(Long id) {
		return learnMapper.queryLearnResouceById(id);
	}

	@Override
	public List<LearnResource> queryLearnResourceList(Map<String, Object> params) {
		// 分页插件
		PageHelper.startPage(Integer.parseInt(params.get("page").toString()),
				Integer.parseInt(params.get("rows").toString()));
		return learnMapper.queryLearnResourceList(params);
	}

}
