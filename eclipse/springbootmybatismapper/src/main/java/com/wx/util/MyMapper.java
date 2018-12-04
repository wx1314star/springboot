package com.wx.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 * 
 * @author wx
 *
 *         Dec 3, 2018
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
	// FIXME 特别注意，该接口不能被扫描到，否则会出错
}
