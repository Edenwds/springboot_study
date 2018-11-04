package com.example.filter.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 16:21 2018/10/18
 */
//@WebFilter(urlPatterns = "/hello",filterName = "demofilter")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Remote Host: " + servletRequest.getRemoteHost());
        System.out.println("Remote Address: " + servletRequest.getLocalAddr());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
