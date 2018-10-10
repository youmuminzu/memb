package com.croplanet.memb.dao;

import com.croplanet.memb.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    public User listUser(long userId);
}
