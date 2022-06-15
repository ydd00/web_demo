package com.ydd.web.httpservlet;

import com.ydd.pojo.User;
import com.ydd.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;


/**
 * @Description TODO
 * @ClassName AjaxHttpServlet
 * @Author YDD
 * @Date 2022/6/10 20:53
 */
@WebServlet(value = "/ajax")
public class AjaxHttpServlet extends HttpServlet {
    UserService userService =new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        User user = userService.selectByUsername(username);
        System.out.println(user);
        if(user!=null){
            response.getWriter().write(" "+true);
        }else {
            response.getWriter().write(" "+false);
        }

    }
}

