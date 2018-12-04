package com.wx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wx.domain.LearnResource;
import com.wx.model.LearnQueryLearnListReq;
import com.wx.service.LearnService;
import com.wx.util.AjaxObject;
import com.wx.util.Page;

@Controller
@RequestMapping("/learn")
/**
 * 教程页面控制器
 * 
 * @author wx
 *
 *         Dec 3, 2018
 */
public class LearnController extends AbstractController {

	@Autowired
	private LearnService learnService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("")
	public String learn(Model model) {
		model.addAttribute("ctx", getContextPath() + "/");
		return "learn-resource";
	}

	/**
	 * 添加教程
	 * 
	 * @param learn
	 * @return AjaxObject
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObject addLearn(@RequestBody LearnResource learn) {
		learnService.save(learn);
		return AjaxObject.ok();
	}

	/**
	 * 删除教程
	 * 
	 * @param ids
	 * @return AjaxObject
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObject deleteLearn(@RequestBody Long[] ids) {
		learnService.deleteBatch(ids);
		return AjaxObject.ok();
	}

	/**
	 * 修改教程
	 * 
	 * @param learn
	 * @return AjaxObject
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObject updateLearn(@RequestBody LearnResource learn) {
		learnService.updateNotNull(learn);
		return AjaxObject.ok();
	}

	/**
	 * 查询教程列表并分页
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryLeanList", method = RequestMethod.POST)
	@ResponseBody
	public AjaxObject queryLearnList(Page<LearnQueryLearnListReq> page) {
		List<LearnResource> learnList = learnService.queryLearnResouceList(page);
		PageInfo<LearnResource> pageInfo = new PageInfo<LearnResource>(learnList);
		return AjaxObject.ok().put("page", pageInfo);
	}

}
