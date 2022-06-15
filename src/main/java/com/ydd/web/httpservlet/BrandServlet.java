package com.ydd.web.httpservlet;

import com.alibaba.fastjson.JSON;
import com.ydd.pojo.Brand;
import com.ydd.pojo.PageBean;
import com.ydd.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    BrandService brandService = new BrandService();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Brand> brands = brandService.selectAllbrand();
        String s = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }
    public  void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        BufferedReader reader = request.getReader();
        System.out.println("1");
        String s = reader.readLine();
        Brand brand = JSON.parseObject(s, Brand.class);
        Integer integer = brandService.insertBrand(brand);
        if(integer>0){
            response.getWriter().write("success");
        }
    }
    public void deleteBrands(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        int[] ints = JSON.parseObject(s, int[].class);
        Integer integer = brandService.deleteByIds(ints);
        if(integer>0){
            response.getWriter().write("success");
        }
    }
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Brand> pageBean = brandService.selectPage(currentPage, pageSize);
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        BufferedReader reader = request.getReader();
        String s1 = reader.readLine();
        Brand brand = JSON.parseObject(s1, Brand.class);
        System.out.println(brand.getBrand_name());
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Brand> pageBean = brandService.selectPageAndCondition(currentPage, pageSize,brand);
        System.out.println(pageBean.getRows());
        String s = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);
    }
}
