package com.example.demo.Utils;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SimpleFilter implements Filter {
    @Override
    public void destroy(){

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("remote host: " + servletRequest.getLocalAddr());
        System.out.println("remote addr: " + servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig config) throws ServletException{

    }
}
