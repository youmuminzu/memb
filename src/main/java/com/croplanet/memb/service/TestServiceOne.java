package com.croplanet.memb.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceOne {
    public String testOne() throws Exception {
        throw new Exception("service exception");
        //return "this is testOne@TestServiceOne";
    }
}
