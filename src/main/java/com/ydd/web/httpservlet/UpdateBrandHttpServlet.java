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
 * @ClassName UpdateBrandHttpServlet
 * @Author YDD
 * @Date 2022/6/8 18:03
 */
@WebServlet(value = "/update")
public class UpdateBrandHttpServlet extends HttpServlet {
    BrandService brandService =new BrandService();
    Brand brand=new Brand();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String brand_name = request.getParameter("brand_name");
        String company_name = request.getParameter("company_name");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        brand.setId(Integer.parseInt(id));
        brand.setBrand_name(brand_name);
        brand.setCompany_name(company_name);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setdescription(description);
        brand.setStatus(Integer.parseInt(status));

        Integer update_flag = brandService.updateById(brand);
        request.setAttribute("update_flag",update_flag);
        request.getRequestDispatcher("/selectAll").forward(request,response);
    }
}

