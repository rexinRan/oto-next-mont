package com.buss.common.filter;

/**
 * Created by Administrator on 2016/8/17.
 */
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
/**
 * 支持跨域请求
 * 跨域问题的解决方案：W3C标准CORS(Cross-Origin Resource Sharing)规范，在服务器端使用filter来设置response头的跨域相关属性。
 */
public class CorsFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //允许哪些url可以跨域请求到本域
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers",
                "origin, content-type, accept, x-requested-with, sid, mycustom, smuser"); //允许哪些请求头可以跨域
//        response.setHeader("Access-Control-Max-Age","3600"); // 缓存控制:max-age
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        filterChain.doFilter(request, response);
    }
}