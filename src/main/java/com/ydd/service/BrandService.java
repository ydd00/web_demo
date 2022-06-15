package com.ydd.service;

import com.ydd.Utils.sqlSessionFactoryUtils;
import com.ydd.mapper.BrandMapper;
import com.ydd.mapper.UserMapper;
import com.ydd.pojo.Brand;
import com.ydd.pojo.PageBean;
import com.ydd.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory=sqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Brand> selectAllbrand(){
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return  brands;
    }
    public Integer insertBrand(Brand brand){
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer i = mapper.addBrand(brand);
        sqlSession.close();
        return i;
    }
    public Brand selectById(int id){
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return  brand;
    }

    public Integer updateById(Brand brand){
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer i = mapper.updateById(brand);
        sqlSession.close();
        return i;
    }
    public Integer deleteById(Integer id){
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer i = mapper.deleteById(id);
        sqlSession.close();
        return i;
    }
    public Integer deleteByIds(int[] ids){
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Integer i = mapper.deleteByIds(ids);
        sqlSession.close();
        return i;
    }
    public PageBean<Brand> selectPage(int currentPage,int pageSize){
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int begin = (currentPage - 1) * pageSize;
        List<Brand> rows = mapper.selectPage(begin, pageSize);
        Integer integer = mapper.selectCount();
        PageBean<Brand> pageBean=new PageBean<Brand>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(integer);
        sqlSession.close();
        return pageBean;
    }

    public PageBean<Brand> selectPageAndCondition(int currentPage,int pageSize,Brand brand){
        SqlSession sqlSession = factory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int begin = (currentPage - 1) * pageSize;

        String brand_name = brand.getBrand_name();
        if(brand_name!=null&&brand_name!=""){
            brand.setBrand_name("%" +brand_name+"%");
        }

        String company_name = brand.getCompany_name();
        if(company_name!=null&&company_name!=""){
            brand.setCompany_name("%" +company_name+"%");
        }


        System.out.println("1"+brand_name);
        System.out.println("1"+company_name);
        List<Brand> rows = mapper.selectPageAndCondition(begin, pageSize,brand);
        Integer integer = mapper.selectCountAndCondition(brand);
        PageBean<Brand> pageBean=new PageBean<Brand>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(integer);
        sqlSession.close();
        return pageBean;
    }


}
