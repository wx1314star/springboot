package com.client.demo.controller;


import com.client.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{id:\\d+}")
    public User get(@PathVariable Long id) {
        log.info("获取用户id为 " + id + "的信息");
        return new User(id, "setest", "123456");
    }

    @GetMapping
    public List<User> get() {
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

    @DeleteMapping
    public void delete(@RequestBody Long id) {
        log.info("删除用户成功 " + id);
    }
}
