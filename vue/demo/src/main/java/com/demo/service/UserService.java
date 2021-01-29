package com.demo.service;

import com.demo.entity.User;

import java.util.List;

/**
 * @author wx
 * @date 2020/11/1 4:30 下午
 */
public interface UserService {
    void save(User user);

    void update(User user);

    void delete(String id);

    List<User> findAll();

    User getUserById(String id);
}
