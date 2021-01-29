package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author wx
 * @date 2020/10/23 8:14 上午
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @GetMapping("findAll")
    public List<User> findAll() {
        //System.out.println("查询所有...");
        List<User> list = Arrays.asList(
                new User(21, "小明", 23, new Date()),
                new User(22, "小白", 21, new Date()),
                new User(23, "小黑", 22, new Date()));
        return list;
    }
}
