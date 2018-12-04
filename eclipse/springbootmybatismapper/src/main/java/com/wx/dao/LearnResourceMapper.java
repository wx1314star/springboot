package com.wx.dao;

import java.util.List;
import java.util.Map;

import com.wx.domain.LearnResource;
import com.wx.util.MyMapper;

public interface LearnResourceMapper extends MyMapper<LearnResource> {
	List<LearnResource> queryLearnResouceList(Map<String, Object> map);
}