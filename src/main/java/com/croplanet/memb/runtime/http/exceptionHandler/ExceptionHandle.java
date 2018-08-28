package com.croplanet.memb.runtime.http.exceptionHandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandle {

    @Value("${debug}")
    private boolean isInDebugModel;


    @ExceptionHandler
    @ResponseBody
    public String handleError(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        if (isInDebugModel) {
            return e.getMessage();
        }
        return "error page";

    }


}
