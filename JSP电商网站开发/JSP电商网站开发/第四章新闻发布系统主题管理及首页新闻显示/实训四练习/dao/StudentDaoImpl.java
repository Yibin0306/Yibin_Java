package 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao;

import 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> findAllstudent(Integer pages) {
        int begingIndex = (pages-1)*5;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得链接
            String url="jdbc:mysql://localhost:3306/实训四练习";
            String uname = "root";
            String upwd = "202306";//自己的密码
            Connection connection = DriverManager.getConnection(url, uname, upwd);
            //3.获得Statement 执行sql
            Statement statement = connection.createStatement();
            String sql = "select * from student limit "+begingIndex+",5";
            ResultSet resultSet = statement.executeQuery(sql);
            //4.处理结果 ORM 数据库-->java对象
            List<Student> students = new ArrayList<>();
            while (resultSet.next()){
                Student student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
                students.add(student);
            }
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
        }
        return null;
    }

    @Override
    public Student findOneStudent(Integer sid) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得链接
            String url="jdbc:mysql://localhost:3306/实训四练习";
            String uname = "root";
            String upwd = "202306";//自己的密码
            Connection connection = DriverManager.getConnection(url, uname, upwd);
            //3.获得Statement 执行sql
            Statement statement = connection.createStatement();
            String sql = "select * from student where sid = "+sid;
            ResultSet resultSet = statement.executeQuery(sql);
            //4.处理结果 ORM 数据库-->java对象
            Student student1 = new Student();
            while (resultSet.next()){
                student1.setSid(resultSet.getInt(1));
                student1.setSname(resultSet.getString(2));
                student1.setSage(resultSet.getInt(3));
                student1.setSsex(resultSet.getString(4));
            }
            return student1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
        }
        return null;
    }

    @Override
    public Integer updateStudent(Student student) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得链接
            String url="jdbc:mysql://localhost:3306/实训四练习";
            String uname = "root";
            String upwd = "202306";//自己的密码
            Connection connection = DriverManager.getConnection(url, uname, upwd);
            //3.获得Statement 执行sql
            Statement statement = connection.createStatement();
            String sql = "update student set sname='"+student.getSname()+"',sage="+student.getSage()+",ssex='"+student.getSsex()+"'where sid = "+student.getSid();
            int i = statement.executeUpdate(sql);
            //4.处理结果 ORM 数据库-->java对象
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
        }
        return null;
    }

    @Override
    public Integer deleteStudent(Integer sid) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得链接
            String url="jdbc:mysql://localhost:3306/实训四练习";
            String uname = "root";
            String upwd = "202306";//自己的密码
            Connection connection = DriverManager.getConnection(url, uname, upwd);
            //3.获得Statement 执行sql
            Statement statement = connection.createStatement();
            String sql = "delete from student where sid ="+sid;
            int i1 = statement.executeUpdate(sql);
            //4.处理结果 ORM 数据库-->java对象
            return i1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
        }
        return null;
    }

    @Override
    public Integer addStudent(Student student) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得链接
            String url="jdbc:mysql://localhost:3306/实训四练习";
            String uname = "root";
            String upwd = "202306";//自己的密码
            Connection connection = DriverManager.getConnection(url, uname, upwd);
            //3.获得Statement 执行sql
            Statement statement = connection.createStatement();
            String sql = "insert into student(sname,sage,ssex)value ('"
                    +student.getSname()+"',"
                    +student.getSage()+",'"
                    +student.getSsex()+"')";
            int i2 = statement.executeUpdate(sql);
            //4.处理结果 ORM 数据库-->java对象
            return i2;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
        }
        return null;
    }

    @Override
    public Integer getpages() {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得链接
            String url="jdbc:mysql://localhost:3306/实训四练习";
            String uname = "root";
            String upwd = "202306";//自己的密码
            Connection connection = DriverManager.getConnection(url, uname, upwd);
            //3.获得Statement 执行sql
            Statement statement = connection.createStatement();
            String sql = "select count(*) from student";
            ResultSet resultSet = statement.executeQuery(sql);
            //4.处理结果 ORM 数据库-->java对象
            int totalCounts = 0;
            int pages =0;
            while (resultSet.next()){
                totalCounts=resultSet.getInt(1);
                if (totalCounts%5==0){
                    pages=totalCounts/5;
                }else {
                    pages=totalCounts/5+1;
                }

            }
            return pages;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
        }


        return null;
    }
}
