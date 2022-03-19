package 第四章新闻发布系统主题管理及首页新闻显示.实训四练习;

import 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.dao.StudentDaoImpl;
import 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student;

import java.util.List;

public class text {
    public static void main(String[] args) {
        List<Student> allstudent = new StudentDaoImpl().findAllstudent(3);
        System.out.println(allstudent);
//        Integer getpages = new StudentDaoImpl().getpages();
//        System.out.println(getpages);
    }
}
