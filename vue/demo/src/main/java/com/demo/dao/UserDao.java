package com.demo.dao;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wx
 * @date 2020/11/1 4:25 下午
 */
@Mapper
public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(String id);

    List<User> findAll();

    User getUserById(String id);
}
