package com.wx.service;

import java.util.List;

import com.wx.domain.LearnResource;
import com.wx.model.LearnQueryLearnListReq;
import com.wx.util.Page;

/**
 * 
 * @author wx
 *
 *         Dec 3, 2018
 */
public interface LearnService extends IService<LearnResource> {
	public List<LearnResource> queryLearnResouceList(Page<LearnQueryLearnListReq> page);

	public void deleteBatch(Long[] ids);
}
