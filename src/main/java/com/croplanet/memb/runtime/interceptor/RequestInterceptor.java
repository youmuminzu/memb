package com.croplanet.memb.runtime.interceptor;

import com.croplanet.memb.utils.MyStringUtil;
import javafx.fxml.LoadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //get userId or userName from request attribute and save in session
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String phoneNumber = request.getParameter("phoneNumber");
        String paramsAll = userId + userName + phoneNumber;
        if (MyStringUtil.isBlank(paramsAll)) {
            throw new RuntimeException("at least one of those three params: userId, userName, phoneNumber should have value");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
