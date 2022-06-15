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
 * @ClassName selectByIdHttpServlet
 * @Author YDD
 * @Date 2022/6/8 14:01
 */
@WebServlet(value = "/sel-id")
public class selectByIdHttpServlet extends HttpServlet {
    BrandService brandService =new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Brand brand = brandService.selectById(Integer.parseInt(id));
        request.setAttribute("brand",brand);
        String behavior = request.getParameter("behavior");
        if("update".equals(behavior)){
        request.getRequestDispatcher("/jsp/updatebrand.jsp").forward(request,response);
        }else if("delete".equals(behavior)){
            request.getRequestDispatcher("/delete").forward(request,response);
        }
    }
}

