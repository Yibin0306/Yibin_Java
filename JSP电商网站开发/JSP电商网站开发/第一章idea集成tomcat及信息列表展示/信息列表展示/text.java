package 第一章idea集成tomcat及信息列表展示.信息列表展示;

import 第一章idea集成tomcat及信息列表展示.信息列表展示.dao.信息列表展示DaoImpl;
import 第一章idea集成tomcat及信息列表展示.信息列表展示.entit.信息列表展示;

import java.util.List;

public class text {
    public static void main(String[] args) {
        List<信息列表展示> 信息列表展示s = new 信息列表展示DaoImpl().selectAll信息列表展示();
        System.out.println(信息列表展示s);
    }
}
