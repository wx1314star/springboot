package com.wx.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.ueditor.ActionEnter;
import com.wx.entity.Ueditor;
import com.wx.util.PublicMsg;

@Controller
public class UeditorController {

    @RequestMapping("/index")
    public String index() {
        return "index/index";
    }

    @RequestMapping(value = "/ueditor")
    @ResponseBody
    public String ueditor(HttpServletRequest request, HttpServletResponse response) {
        return config(request, response);
    }
//
//	@RequestMapping(value = "/imgUpload")
//	@ResponseBody
//	public Ueditor imgUpload(MultipartFile upfile) {
//		Ueditor ueditor = new Ueditor();
//		return ueditor;
//	}

    @RequestMapping(value = "/config")
    public String config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        String exec = null;
        try {
            exec = new ActionEnter(request, rootPath).exec();
//			PrintWriter writer = response.getWriter();
//			writer.write(exec);
//			writer.flush();
//			writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exec;
    }
}
