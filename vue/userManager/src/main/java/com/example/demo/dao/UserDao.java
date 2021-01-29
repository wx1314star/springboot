package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @author wx
 * @date 2020/10/21 9:59 上午
 */
public interface UserDao {

    @Insert("insert into t_user(name,age,salary,phoneCode) values(#{name},#{age},#{salary},#{phoneCode})")
    void save(User user);
}
