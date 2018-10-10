package com.croplanet.memb.service.implementation;

import com.croplanet.memb.dao.UserMapper;
import com.croplanet.memb.entity.User;
import com.croplanet.memb.service.interfacePackage.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceOneImpl implements TestService {

    @Autowired
    private UserMapper userMapper;

    public String testOne() throws Exception {
        throw new Exception("service exception");
        //return "this is testOne@TestServiceOne";
    }

    @Override
    public User testUsingDataBase() {
        User result = userMapper.listUser(2L);
        return result;
    }
}
