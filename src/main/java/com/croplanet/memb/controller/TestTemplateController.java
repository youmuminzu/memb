package com.croplanet.memb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/template")
public class TestTemplateController {

    @GetMapping("/sayHi")
    public String HelloTemplate(Model model) {
        Map<String, String> pageParmas = new HashMap<>();
        pageParmas.put("attr1","this is the first page");
        model.addAllAttributes(pageParmas);
        return "/hi";
    }

}
