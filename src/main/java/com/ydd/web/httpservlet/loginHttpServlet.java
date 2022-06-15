package com.ydd.web.httpservlet;

import com.ydd.pojo.User;
import com.ydd.service.BrandService;
import com.ydd.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * @Description TODO
 * @ClassName ServletDemo1
 * @Author YDD
 * @Date 2022/5/28 20:15
 */
@WebServlet("/login")
public class loginHttpServlet extends HttpServlet {
    UserService userService =new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String zzz = request.getParameter("zzz");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        System.out.println(zzz);
        User user = userService.login(username, password);
        System.out.println("daf"+user);
        if(user!=null){
            //跳转不能在发送cooikes之前
            if("on".equals(remember)){
                System.out.println(remember);
                Cookie c_username=new Cookie("username",username);
                Cookie c_password=new Cookie("password",password);
                c_password.setMaxAge(60*60*24*7);
                c_username.setMaxAge(60*60*24*7);
                response.addCookie(c_password);
                response.addCookie(c_username);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            System.out.println("user"+user);
            request.getRequestDispatcher("/selectAll").forward(request,response);
        }
        else{
            request.setAttribute("login_flag","用户名或密码错误");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        }
        System.out.println(user);
    }
}

