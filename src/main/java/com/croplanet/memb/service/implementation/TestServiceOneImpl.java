package com.croplanet.memb.service.implementation;

import com.croplanet.memb.dao.UserDao;
import com.croplanet.memb.entity.User;
import com.croplanet.memb.service.interfacePackage.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceOneImpl implements TestService {

    @Autowired
    private UserDao userDao;

    public String testOne() throws Exception {
        throw new Exception("service exception");
        //return "this is testOne@TestServiceOne";
    }

    @Override
    public List<User> testUsingDataBase() {
        List<User> result = userDao.listUser(1L);
        return result;
    }
}
