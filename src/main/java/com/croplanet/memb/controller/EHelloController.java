package com.croplanet.memb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("e")
public class EHelloController {

    @GetMapping("hello")
    public String hello() {
        return "no interceptor";
    }

}
