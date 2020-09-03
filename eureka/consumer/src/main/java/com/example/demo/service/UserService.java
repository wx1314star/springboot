package com.example.demo.service;

import com.example.demo.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserDefault")
    public User getUser(@PathVariable Long id) {
        log.info("获取用户id为 " + id + "的信息");
        return restTemplate.getForObject("http://Server-Provider/user/{id}", User.class, id);
    }

    @HystrixCommand(fallbackMethod = "getUserDefault2")
    public User getUserDefault(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("defaultUser");
        user.setPassword("123456");
        return user;
    }

    public User getUserDefault2(Long id) {
        User user = new User();
        user.setId(-2L);
        user.setUsername("defaultUser2");
        user.setPassword("123456");
        return user;
    }

    @GetMapping
    public List<User> getUsers() {
        List<User> list = new ArrayList<User>();
        list.add(new User(1L, "scott", "123456"));
        list.add(new User(2L, "ghost", "456789"));
        log.info("获取用户信息" + list);
        return list;
    }

    @PostMapping
    public void add(@RequestBody User user) {
        log.info("新增用户成功 " + user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        log.info("更新用户成功 " + user);
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable Long id) {
        log.info("删除用户成功 " + id);
    }
}
