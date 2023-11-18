package com.yunyun.application.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunyun.application.domain.User;
import com.yunyun.application.service.impl.UserServiceimpl;
import com.yunyun.application.util.JsonData;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private static ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("init LoginFilter");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("doFilter LoginFilter=========");

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String token = req.getHeader("token");
        if(token == null){
            token = req.getParameter("token");
        }
        System.out.println("token :"+ token);

        /*if(token==null){
            return;
        }else{
           User user = UserServiceimpl.sessionMap.get(token);

           if(user !=null){
               filterChain.doFilter(servletRequest,servletResponse);
           }
        }*/

        if(token !=null){
            User user = UserServiceimpl.sessionMap.get(token);

            if(user !=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
              JsonData jsonData=  JsonData.buildError("登陆失败，token无效",-2);

              String jsonStr = objectMapper.writeValueAsString(jsonData);
              renderJson(resp, jsonStr);
            }

        }else {
            JsonData jsonData=  JsonData.buildError("未登录",-2);

            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(resp, jsonStr);
        }
    }


    private void renderJson(HttpServletResponse response, String json){

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        try(PrintWriter writer = response.getWriter()){
            writer.print(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

        System.out.println("destroy LoginFilter");

    }
}
