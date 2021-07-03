package com.liang.mybatis.test.dao;

import com.liang.mybatis.test.entity.User;

import java.util.List;

public interface UserMapper {

    User getOne(User user);

    List<User> getList();

    int insert(User user);

    int update(User user);

    int delete(User user);

}
