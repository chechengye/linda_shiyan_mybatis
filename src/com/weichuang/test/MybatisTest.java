package com.weichuang.test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.weichuang.mapper.UserMapper;
import com.weichuang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testFn() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //true ： 开启事务的增删改方法  ， false是只具备查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getAllUsers();
        for(User u : userList){
            //System.out.println(u);
        }
        User user = mapper.getUserById(2);
        System.out.println(user);
    }
}
