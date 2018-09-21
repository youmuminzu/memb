package com.croplanet.memb.service.implementation;

import com.croplanet.memb.service.interfacePackage.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceOneImpl implements TestService {
    public String testOne() throws Exception {
        throw new Exception("service exception");
        //return "this is testOne@TestServiceOne";
    }

    public String testUsingDataBase() {

        return null;
    }
}
