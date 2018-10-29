package com.example.interceptor.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 11:45 2018/10/11
 */
@Component
public class DemoInterceptor implements HandlerInterceptor {

    // This is used to perform operations before sending the request to the controller.
    // This method should return true to return the response to the client
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("Pre Handle method is Calling");
        return true;
    }

    // This is used to perform operations before sending the response to the client
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method is Calling");
    }

    // This is used to perform operations after completing the request and response
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("Request and Response is completed");
    }
}
