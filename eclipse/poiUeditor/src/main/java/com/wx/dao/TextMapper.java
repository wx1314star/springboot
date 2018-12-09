package com.wx.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wx.entity.Text;
import com.wx.util.MyMapper;

@Mapper
public interface TextMapper extends MyMapper<Text> {
	int add(Text text);

//	int update(Text text);
//
//	int deleteById(String[] ids);
//
//	Text queryTextById(Integer id);
//
//	List<Text> queryTextList(Map<String, Object> params);
}