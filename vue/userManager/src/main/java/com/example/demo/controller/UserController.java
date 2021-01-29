package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wx
 * @date 2020/10/21 9:58 上午
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @PostMapping("save")
    public Object save(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>(16);
        return map;
    }

}
