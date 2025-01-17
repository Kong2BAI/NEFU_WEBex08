package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 查询全部用户
     * @return
     */
    public List<User> listUsers();
    /**
     * 添加用户
     * @param name
     */
    public void addUser(String name);
    /**
     * 基于ID获取指定用户
     * @param id
     * @return
     */
    public User getUser(String id);
}
