package com.croplanet.memb.dao;

import com.croplanet.memb.entity.User;

import java.util.List;

public interface userDao {

    public List<User> listUser(int userId);
}
