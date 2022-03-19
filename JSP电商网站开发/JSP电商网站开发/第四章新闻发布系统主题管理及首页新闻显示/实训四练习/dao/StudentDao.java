package 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao;

import 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student;

import java.util.List;

public interface StudentDao {
    //查询所有学生信息的方法
    List<Student> findAllstudent(Integer pages);
    //查询单个学生方法
    Student findOneStudent(Integer sid);
    //修改学生信息
    Integer updateStudent(Student student);
    //删除学生信息
    Integer deleteStudent(Integer sid);
    //添加学生信息
    Integer addStudent(Student student);
    //查询总页数
    Integer getpages();
}
