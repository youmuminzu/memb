package com.croplanet.memb.dao;

import com.croplanet.memb.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> listUser(long userId);
}
