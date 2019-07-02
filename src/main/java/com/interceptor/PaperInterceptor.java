package com.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaperInterceptor extends HandlerInterceptorAdapter {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception{
        System.out.println("preHandler");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handle, ModelAndView modelAndView)throws Exception {
        System.out.println("postHandle");
    }

    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handle,Exception e)throws Exception {
        System.out.println("afterCompletion");
    }

}
