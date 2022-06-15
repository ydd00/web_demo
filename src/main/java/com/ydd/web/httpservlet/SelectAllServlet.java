package com.ydd.web.httpservlet;

import com.alibaba.fastjson.JSON;
import com.ydd.pojo.Brand;
import com.ydd.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;


/**
 * @Description TODO
 * @ClassName SelectAllServlet
 * @Author YDD
 * @Date 2022/6/11 14:39
 */
@WebServlet(value = "/selectall1")
public class SelectAllServlet extends HttpServlet {
    BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Brand> brands = brandService.selectAllbrand();
        String s = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }
}

