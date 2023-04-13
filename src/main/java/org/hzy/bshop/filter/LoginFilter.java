package org.hzy.bshop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/frontPhone/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("登录过滤器");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String requestURI = request.getRequestURI();
        if(requestURI.toLowerCase().contains("login")){
            chain.doFilter(request,response);
        }else{
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if(user==null){
                response.sendRedirect("/login.html");
            }else{
                chain.doFilter(request,response);
            }
        }

    }

}
