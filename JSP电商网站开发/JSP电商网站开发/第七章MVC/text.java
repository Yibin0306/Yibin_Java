package 第七章MVC;

import 第七章MVC.dao.投票DaoImpl;
import 第七章MVC.entit.投票;

import java.util.List;

public class text {
    public static void main(String[] args) {
//        List<投票> 投票s = new 投票DaoImpl().selectAll投票();
//        System.out.println(投票s);
        Integer integer = new 投票DaoImpl().add投票(2);
        System.out.println(integer);
    }
}
