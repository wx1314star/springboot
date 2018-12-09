package com.wx.service;

import java.io.InputStream;
import java.util.List;

import com.wx.entity.Text;

public interface TextService extends IService<Text> {
	int add(Text text);

	public List<List<Object>> getBankListByExcel(InputStream in, String fileName) throws Exception;
}
