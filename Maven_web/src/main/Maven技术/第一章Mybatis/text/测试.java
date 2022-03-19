package 第一章Mybatis.text;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import 第一章Mybatis.dao.用户dao;
import 第一章Mybatis.dao.用户数据dao;
import 第一章Mybatis.dao.用户部门dao;
import 第一章Mybatis.entity.用户;
import 第一章Mybatis.entity.用户数据;
import 第一章Mybatis.entity.用户部门;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class 测试 {
    public static void main(String[] args) {

        try {
            //读取mybatis配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream("第一章Mybatis/mybatis.xml");
            //SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //生产SqlSession  默认事务是手动提交
            SqlSession sqlSession = factory.openSession();
            //获得接口对象
            用户dao 用户dao = sqlSession.getMapper(用户dao.class);
            用户数据dao 用户数据dao = sqlSession.getMapper(用户数据dao.class);
            用户部门dao 用户部门dao = sqlSession.getMapper(用户部门dao.class);
            //调用方法
            //1.查询所有用户
//            List<用户> all = 用户dao.findAll();
//            System.out.println(all);
//            2.查询单个用户
//            用户 用户 = 用户dao.selectOne(1);
//            System.out.println(用户);
            //3.添加用户
//            Integer integer = 用户dao.addUser(new 用户(5, "tom", "123"));
//            System.out.println(integer);
//            sqlSession.commit();
            //4.删除用户
//            Integer integer = 用户dao.deleteUser(5);
//            System.out.println(integer);
//            sqlSession.commit();
            //5.修改用户
//            Integer integer = 用户dao.updateUser(new 用户(5, "yibin", null));
//            System.out.println(integer);
//            sqlSession.commit();
            //6.查询用户信息
//            用户数据 findone = 用户数据dao.findone(1);
//            System.out.println(findone);
            //7.查询用户部门
//            用户部门 findone = 用户部门dao.findOne(2);
//            System.out.println(findone);
            //8.sql片段
//            用户 yibin = 用户dao.selectOneName("Tom");
//            System.out.println(yibin);
            //9.多条件搜索
//            用户 用户 = new 用户();
//            用户.setUser_id(1);
//            用户.setUser_name("Yibin");
//            第一章Mybatis.entity.用户 用户1 = 用户dao.select(用户);
//            System.out.println(用户1);
            //10.foreach批量删除用户
//            ArrayList<Integer> integers = new ArrayList<>();
//            integers.add(5);
//            integers.add(6);
//            Integer integer = 用户dao.deleteUserId(integers);
//            System.out.println(integer);
//            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}