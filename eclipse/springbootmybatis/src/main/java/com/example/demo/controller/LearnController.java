package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.LearnResource;
import com.example.demo.service.LearnService;
import com.example.demo.tools.ServletUtil;
import com.example.demo.tools.StringUtil;
import com.github.pagehelper.PageInfo;

/**
 * @author wx
 * <p>
 * Dec 1, 2018
 */
@Controller
@RequestMapping("/learn")
public class LearnController {

    @Autowired
    private LearnService learnService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String learn() {
        return "learn-resource";
    }

    /**
     * 添加教程
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addLearn(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        if (StringUtil.isNull(author)) {
            result.put("message", "作者不能为空！");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(title)) {
            result.put("message", "教程名称不能为空！");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(url)) {
            result.put("message", "地址不能为空！");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        LearnResource learnResource = new LearnResource();
        learnResource.setAuthor(author);
        learnResource.setTitle(title);
        learnResource.setUrl(url);
        int index = learnService.add(learnResource);
        System.out.println("结果=" + index);
        if (index > 0) {
            result.put("message", "教程信息添加成功！");
            result.put("flag", true);
        } else {
            result.put("message", "教程信息添加失败！");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     *  更新教程
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateLearn(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String id = request.getParameter("id");
        LearnResource learnResource = learnService.queryLearnResouceById(Long.parseLong(id));
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        if (StringUtil.isNull(author)) {
            result.put("message", "作者不能为空！");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(title)) {
            result.put("message", "教程名称不能为空！");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        if (StringUtil.isNull(url)) {
            result.put("message", "地址不能为空！");
            result.put("flag", false);
            ServletUtil.createSuccessResponse(200, result, response);
            return;
        }
        learnResource.setAuthor(author);
        learnResource.setTitle(title);
        learnResource.setUrl(url);
        int index = learnService.update(learnResource);
        System.out.println("修改结果=" + index);
        if (index > 0) {
            result.put("message", "教程信息更新成功！");
            result.put("flag", true);
        } else {
            result.put("message", "教程信息更新失败！");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 删除教程
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void deleteLearn(HttpServletRequest request, HttpServletResponse response) {
        String ids = request.getParameter("ids");
        System.out.println("ids==" + ids);
        JSONObject result = new JSONObject();
        // 删除操作
        // int index = learnService.deleteByIds(ids);
        // String[] idss= ids.split(",");
        int index = learnService.deleteByIds(ids.split(","));
        if (index > 0) {
            result.put("message", "教程信息删除成功！");
            result.put("flag", true);
        } else {
            result.put("message", "教程信息删除失败！");
            result.put("flag", false);
        }
        ServletUtil.createSuccessResponse(200, result, response);
    }

    /**
     * 分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/queryLearnList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void queryLearnList(HttpServletRequest request, HttpServletResponse response) {
        // 取得当前页数，注意这是jqgrid自身的参数
        String page = request.getParameter("page");
        // 取得每页显示行数，注意这是jqgrid自身的参数
        String rows = request.getParameter("rows");
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", page);
        params.put("rows", rows);
        params.put("author", author);
        params.put("title", title);
        // Page pageObj = learnService.queryLearnResourceList(params);
        // List<Map<String, Object>> learnList = pageObj.getResultList();
        List<LearnResource> learnList = learnService.queryLearnResourceList(params);
        PageInfo<LearnResource> pageInfo = new PageInfo<LearnResource>(learnList);
        JSONObject json = new JSONObject();
        json.put("rows", learnList);
        json.put("total", pageInfo.getPages());
        json.put("records", pageInfo.getTotal());
        ServletUtil.createSuccessResponse(200, json, response);
    }
}
