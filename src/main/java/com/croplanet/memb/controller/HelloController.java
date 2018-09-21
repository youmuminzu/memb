package com.croplanet.memb.controller;

import com.croplanet.memb.service.interfacePackage.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private TestService testServiceOne;
    @GetMapping("say")
    public String SayHello() throws Exception {

        return "after interceptor";
    }
}
