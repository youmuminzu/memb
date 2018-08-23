package com.croplanet.memb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("say")
    public String SayHello() throws Exception {
//        throw new Exception("this is the exception");
        return "after interceptor";
    }
}
