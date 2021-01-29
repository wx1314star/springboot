package com.wx.service;

import java.util.List;

import org.springframework.stereotype.Service;


/**
 * @author wx
 * <p>
 * Dec 3, 2018
 */
@Service
public interface IService<T> {
    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    // TODO 其他...
}
