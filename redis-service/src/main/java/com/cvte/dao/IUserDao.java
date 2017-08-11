package com.cvte.dao;

import com.cvte.entity.User;

public interface IUserDao {

    public abstract Integer addUser(User user);
    public abstract User findByAppid(String appid);
}
