package com.ydd.web.httpservlet;

import com.ydd.Utils.VerifyCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;


/**
 * @Description TODO
 * @ClassName CheckcodeHttpServlet
 * @Author YDD
 * @Date 2022/6/10 13:39
 */
@WebServlet("/checkcode")
public class CheckcodeHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServletOutputStream os = response.getOutputStream();
        String s = VerifyCodeUtils.generateVerifyCode(4);
        VerifyCodeUtils.outputImage(100,50,os,s);
        HttpSession session = request.getSession();
        session.setAttribute("random_checkcode",s);
    }
}

