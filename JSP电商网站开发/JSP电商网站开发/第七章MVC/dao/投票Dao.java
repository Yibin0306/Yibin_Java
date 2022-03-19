package 第七章MVC.dao;

import 第七章MVC.entit.投票;
import 第四章新闻发布系统主题管理及首页新闻显示.实训四练习.entit.Student;

import java.util.List;

public interface 投票Dao {
    //查询所有信息
    List<投票> selectAll投票();
    //增加投票数量
    Integer add投票(Integer id);
}
