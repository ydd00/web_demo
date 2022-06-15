package com.ydd.web.httpservlet;

import com.ydd.pojo.User;
import com.ydd.service.BrandService;
import com.ydd.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;


/**
 * @Description TODO
 * @ClassName AddUserHttpServlet
 * @Author YDD
 * @Date 2022/6/9 16:57
 */
@WebServlet("/adduser")
public class AddUserHttpServlet extends HttpServlet {
    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        Object random_checkcode = session.getAttribute("random_checkcode");
        String write_checkcode = request.getParameter("write_checkcode");
        System.out.println(random_checkcode+"  :" +write_checkcode);
        boolean flag=random_checkcode.toString().equalsIgnoreCase(write_checkcode);

        if(flag){
            boolean b = userService.addUser(username, password);
            if(b){
                request.setAttribute("register_flag","注册成功");
                request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
            }else {
                request.setAttribute("register","该用户已存在");
                request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("checkcode_flag","验证码输入错误");
            request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
        }

    }
}

