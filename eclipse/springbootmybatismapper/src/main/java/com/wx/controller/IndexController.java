package com.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 *
 * @author wx
 * <p>
 * Dec 3, 2018
 */
@Controller
public class IndexController extends AbstractController {

    @RequestMapping("/main")
    public String main(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "main";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("ctx", getContextPath() + "/");
        return "index";
    }
}
