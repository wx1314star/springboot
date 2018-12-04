package com.wx.service.impl;

import java.util.Arrays;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.wx.dao.LearnResourceMapper;
import com.wx.domain.LearnResource;
import com.wx.model.LearnQueryLearnListReq;
import com.wx.service.LearnService;
import com.wx.util.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * 
 * @author wx
 *
 *         Dec 3, 2018
 */
public class LearnServiceImpl extends BaseService<LearnResource> implements LearnService {
	@Autowired
	private LearnResourceMapper learnResourceMapper;

	@Override
	public void deleteBatch(Long[] ids) {
		Arrays.stream(ids).forEach(id -> learnResourceMapper.deleteByPrimaryKey(id));
	}

	@Override
	public List<LearnResource> queryLearnResouceList(Page<LearnQueryLearnListReq> page) {
		PageHelper.startPage(page.getPage(), page.getRows());
		return learnResourceMapper.queryLearnResouceList(page.getCondition());
	}

}
