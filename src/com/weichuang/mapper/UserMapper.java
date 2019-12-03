package com.weichuang.mapper;

import com.weichuang.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getAllUsers();

    User getUserById(int id);
}
