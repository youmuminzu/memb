package com.croplanet.memb.controller;

import com.croplanet.memb.service.interfacePackage.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exclude")
public class EHelloController {

    @Autowired
    private TestService testServiceOne;

    @GetMapping("hello")
    public String hello() throws Exception{
//        int a = 123/0;
        testServiceOne.testUsingDataBase();
        return "no interceptor";
    }

}
