package com.weichuang.mapper;

import com.weichuang.pojo.User;
import com.weichuang.vo.QueryVo;

import java.util.List;

public interface UserMapper {
    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    List<User> getUsersByQueryVo(QueryVo queryVo);

    int getUserCount();

    List<User> getUsersBySexAndName(User user);

    List<User> getUsersByIds(List<Integer> ids);

    List<User> getUserListByQueryVo(QueryVo vo);

    List<User> getAllUsersAndOrders();
}
