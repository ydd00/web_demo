package com.ydd.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter()
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest hsr=(HttpServletRequest) request;
        HttpSession session = hsr.getSession();
        String[] urls= {"/jsp/login.jsp","/jsp/register.jsp","/css/*","/img/*","/login","/checkcode","/adduser"};
        String url = hsr.getRequestURL().toString();
        for (String s:urls){
            if(url.contains(s)){
                chain.doFilter(request,response);
                return;
            }
        }
        Object user = session.getAttribute("user");
        System.out.println(user);
        if(user!=null){
            chain.doFilter(request, response);
        }else {
            request.setAttribute("login_flag","您尚未登陆");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
