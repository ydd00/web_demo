package com.ydd.mapper;

import com.ydd.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();
    Integer addBrand(Brand brand);
    Brand selectById(Integer id);
    Integer updateById(Brand brand);
    Integer deleteById(Integer id);
    Integer deleteByIds(@Param("ids") int[] ids);
    List<Brand> selectPage(@Param("begin")int begin,@Param("size")int size);
    Integer selectCount();
    List<Brand> selectPageAndCondition(@Param("begin")int begin,@Param("size")int size,@Param("brand")Brand brand);
    Integer selectCountAndCondition(Brand brand);
}
