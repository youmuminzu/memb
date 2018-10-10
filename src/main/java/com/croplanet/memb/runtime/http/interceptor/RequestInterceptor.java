package com.croplanet.memb.runtime.http.interceptor;

import com.croplanet.memb.configuration.constConfig.ConstLocalParamKeys;
import com.croplanet.memb.utils.MyStringUtil;
import com.croplanet.memb.runtime.http.local.LocalContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private  LocalContextHolder localContextHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //get userId or userName from request attribute
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String phoneNumber = request.getParameter("phoneNumber");

        if (MyStringUtil.isBlank(userId) && MyStringUtil.isBlank(userName) && MyStringUtil.isBlank(phoneNumber)) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print("{\"error\":\"request params error\",\"code\":550," +
                "\"message\":\"at least one of those three params: userId, userName, phoneNumber, should have value\"}");
            return false;
        }

        //set the userId in local value
        if (!MyStringUtil.isBlank(userId)) {
            localContextHolder.setLocal(ConstLocalParamKeys.LOCAL_KEY_USER_ID,userId);
        }

//        redisTemplate.opsForValue().set("userId", 1000);
        System.out.println("***********this is the preHandle**********");
//        redisTemplate.expire("userId", 10, TimeUnit.MINUTES);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("***********this is the postHandle**********");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("***********this is the completion**********");
    }
}