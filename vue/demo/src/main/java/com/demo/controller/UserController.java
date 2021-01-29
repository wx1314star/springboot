package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wx
 * @date 2020/11/1 4:34 下午
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return
     */
    @GetMapping("getUserById")
    public User getUserById(String id) {
        return userService.getUserById(id);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("findAll")
    private Map<String, Object> findAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>(16);
        List<User> results = userService.findAll();
        map.put("total", 10);
        map.put("totalPage", 1);
        map.put("page", page);
        map.put("results", results);

        return map;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("add")
    public Map<String, Object> add(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>(16);
        try {
            userService.save(user);
            map.put("success", true);
            map.put("msg", "添加用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "添加用户失败" + e.getMessage());
        }
        return map;
    }

    /**
     * 根据id删除用户
     *
     * @param id 主键id
     * @return
     */
    @GetMapping("delete")
    public Map<String, Object> delete(String id) {
        Map<String, Object> map = new HashMap<>(16);
        try {
            userService.delete(id);
            map.put("success", true);
            map.put("msg", "删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "删除用户失败" + e.getMessage());
        }
        return map;
    }

    /**
     * 更新用户
     * @param user 用户
     * @return
     */
    @PostMapping("update")
    public Map<String, Object> update(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>(16);
        try {
            userService.update(user);
            map.put("success", true);
            map.put("msg", "更新用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("msg", "更新用户失败"+e.getMessage());
        }
        return map;
    }

}
