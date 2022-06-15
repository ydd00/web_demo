package com.ydd.web.httpservlet;

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
 * @ClassName SelectAllBrandsHttpServlet
 * @Author YDD
 * @Date 2022/6/7 16:37
 */
@WebServlet(value = "/selectAll")
public class SelectAllBrandsHttpServlet extends HttpServlet {
    BrandService brandService =new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("123"+request.getContextPath());
        List<Brand> brands = brandService.selectAllbrand();
        request.setAttribute("brands",brands);
        request.getRequestDispatcher("/jsp/brands.jsp").forward(request,response);
    }

}

