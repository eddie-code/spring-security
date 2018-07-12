package com.lwc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author eddie.lee
 * @Package com.lwc.interceptor
 * @ClassName TimeInterceptor
 * @description 拦截器配置
 * @date created in 2018-07-12 23:24
 * @modified by
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("TimeInterceptor ==> preHandle");

        System.out.println("TimeInterceptor ==> "+((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println("TimeInterceptor ==> "+((HandlerMethod) handler).getMethod().getName());

        request.setAttribute("startTime", new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("TimeInterceptor ==> postHandle");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("TimeInterceptor ==> time interceptor 耗时1 :" + (new Date().getTime() - start));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("TimeInterceptor ==> afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        System.out.println("TimeInterceptor ==> time interceptor 耗时2 :" + (new Date().getTime() - start));
        System.out.println("TimeInterceptor ==> ex is " + ex);

    }

}

