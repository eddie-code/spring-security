package com.lwc.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author eddie.lee
 * @Package com.lwc.filter
 * @ClassName TimeFilter
 * @description 过滤器
 * @date created in 2018-07-12 23:08
 * @modified by
 */
//@Component
public class TimeFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("TimeFilter ==> time filter destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("TimeFilter ==> time filter start");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("TimeFilter ==> time filter 耗时:"+ (new Date().getTime() - start));
        System.out.println("TimeFilter ==> time filter finish");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("TimeFilter ==> time filter init");
    }

}