package com.ydd.service;

import com.ydd.Utils.sqlSessionFactoryUtils;
import com.ydd.mapper.BrandMapper;
import com.ydd.mapper.UserMapper;
import com.ydd.pojo.Brand;
import com.ydd.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory= sqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username, String password){
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.login(username, password);
        sqlSession.close();
        return user;
    }
    public boolean addUser(String username, String password){
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = selectByUsername(username);
        if(user==null){
            mapper.addUser(username, password);
        }
        sqlSession.close();
        return user==null;


    }
    public User selectByUsername(String username){
        SqlSession sqlSession = factory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByName(username);
        sqlSession.close();
        return  user;
    }
}
