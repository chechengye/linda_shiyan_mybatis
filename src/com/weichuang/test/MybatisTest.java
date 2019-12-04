package com.weichuang.test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.weichuang.mapper.OrderMapper;
import com.weichuang.mapper.UserMapper;
import com.weichuang.pojo.Order;
import com.weichuang.pojo.User;
import com.weichuang.vo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

    @Test
    public void testFn1() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //true ： 开启事务的增删改方法  ， false是只具备查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("wuyifan");
        user.setMoney(1000);
        mapper.addUser(user);
    }

    @Test
    public void testFn2() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //true ： 开启事务的增删改方法  ， false是只具备查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("w");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);
        List<User> userList = mapper.getUsersByQueryVo(queryVo);
        System.out.println(userList);
    }

    @Test
    public void testFn3() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //true ： 开启事务的增删改方法  ， false是只具备查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.getUserCount();
        System.out.println(count);
    }

    @Test
    public void testFn4() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //true ： 开启事务的增删改方法  ， false是只具备查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.getAllOrders();
        System.out.println(orderList);
    }

    @Test
    public void testFn5() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //true ： 开启事务的增删改方法  ， false是只具备查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        //user.setName("wangwu");
        user.setSex(1);
        List<User> userList = mapper.getUsersBySexAndName(user);
        System.out.println(userList);
    }

    @Test
    public void testFn6() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //true ： 开启事务的增删改方法  ， false是只具备查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        QueryVo vo = new QueryVo();
        vo.setIds(ids);
        List<User> userList = mapper.getUserListByQueryVo(vo);
        //List<User> userList = mapper.getUsersByIds(ids);
        System.out.println(userList);
    }

    @Test
    public void testFn7() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //true ： 开启事务的增删改方法  ， false是只具备查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.getAllOrdersAndUser();
        System.out.println(orderList);
    }

    @Test
    public void testFn8() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //true ： 开启事务的增删改方法  ， false是只具备查询方法
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getAllUsersAndOrders();
        System.out.println(userList);
    }
}
