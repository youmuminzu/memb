package com.croplanet.memb.runtime.http.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Repository
public class LocalContextHolder {
    @Autowired
    private HttpServletRequest httpRequest;

    public void setLocal(String key, String value) {
        HttpSession httpSession = httpRequest.getSession();
        httpSession.setAttribute(key, value);
    }

    public String getLocalValue(String key) {
        HttpSession httpSession = httpRequest.getSession();
        return String.valueOf(httpSession.getAttribute(key));
    }

}
