package com.croplanet.memb.controller;

import com.croplanet.memb.service.TestServiceOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("e")
public class EHelloController {

    @Autowired
    private TestServiceOne testServiceOne;

    @GetMapping("hello")
    public String hello() throws Exception{
//        int a = 123/0;
        testServiceOne.testOne();
        return "no interceptor";
    }

}
