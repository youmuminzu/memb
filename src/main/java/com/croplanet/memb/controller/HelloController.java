package com.croplanet.memb.controller;

import com.croplanet.memb.service.TestServiceOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private TestServiceOne testServiceOne;
    @GetMapping("say")
    public String SayHello() throws Exception {

        testServiceOne.testOne();
        return "after interceptor";
    }
}
