package com.ydd.web.httpservlet;

import com.ydd.pojo.Brand;
import com.ydd.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;


/**
 * @Description TODO
 * @ClassName InsertBrandHttpServlet
 * @Author YDD
 * @Date 2022/6/8 13:04
 */
@WebServlet(value = "/insert")
public class InsertBrandHttpServlet extends HttpServlet {
    BrandService brandService =new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Brand brand=new Brand();
        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        brand.setBrand_name(brandName);
        brand.setCompany_name(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setdescription(description);
        brand.setStatus(Integer.parseInt(status));
        Integer i = brandService.insertBrand(brand);
        System.out.println(i);
        request.setAttribute("i",i);
        request.getRequestDispatcher("/selectAll").forward(request,response);
    }
}

