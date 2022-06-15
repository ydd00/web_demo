package com.ydd.web.httpservlet;

import com.ydd.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;


/**
 * @Description TODO
 * @ClassName DeleteBrandHttpServlet
 * @Author YDD
 * @Date 2022/6/8 18:40
 */
@WebServlet(value = "/delete")
public class DeleteBrandHttpServlet extends HttpServlet {
    BrandService brandService =new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Integer delete_flag = brandService.deleteById(Integer.parseInt(id));
        request.setAttribute("delete_flag",delete_flag);
        request.getRequestDispatcher("/selectAll").forward(request,response);
    }
}

