package com.croplanet.memb.runtime.exceptionHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GlobalExceptionHandler implements ErrorController {

    @Value("${debug}")
    private boolean isInDebugModel;

    @Autowired
    private ErrorAttributes attributes;

    @Override
    public String getErrorPath() {
        return "/customer/error";
    }

    @RequestMapping("/customer/error")
    @ResponseBody
    public String error(HttpServletRequest request) {
        return "this is the error message";
    }
}
