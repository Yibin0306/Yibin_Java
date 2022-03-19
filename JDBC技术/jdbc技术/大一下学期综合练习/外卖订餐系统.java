package 大一下学期综合练习;

import jdbc工具.jdbc工具;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class 外卖订餐系统 {

    static Scanner sc = new Scanner(System.in);

    //查询所有外卖信息
    public static List<Food>getFoods(){
        Statement statement = jdbc工具.getStatement("foodtogo", "root", "202306");
        List<Food> foods = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from food");
            while (resultSet.next()){
                Food food = new Food(resultSet.getInt(1), resultSet.getString("name"), resultSet.getDouble("price"));
                foods.add(food);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //jdbc工具.close();
        }
        return foods;
    }

    //登录：查询
    public static void login() throws SQLException, ClassNotFoundException {

        /**
         * 1.根据用户名去数据库中找到这条数据
         * 2.拿userpwd和你查询密码比较，相等   不等
         */
        System.out.println("输入用户名");
        String username = sc.next();
        System.out.println("输入密码");
        String userpwd = sc.next();


        Statement statement = jdbc工具.getStatement("foodtogo", "root", "202306");
        ResultSet resultSet = statement.executeQuery("select * from user where username = '" + username + "'");
        String pwd = null;
        while (resultSet.next()){
            pwd = resultSet.getString(3);
        }
        System.out.println(pwd);
        if(pwd.equals(userpwd)){
            System.out.println("登陆成功");
            //获得商品列表并展示
            List<Food> foods = getFoods();
            for(Food f:foods){
                System.out.println(f);
            }
            //选择订购商品，准备生成订单
            System.out.println("选择商品，输入商品编号");
            Scanner sc = new Scanner(System.in);
            int foodid = sc.nextInt();
            //生成订单 编号： 时间    名称   日期
            //1。通过外卖的编号，拿到外卖名字
            ResultSet resultSet1 = jdbc工具.getStatement("foodtogo", "root", "202306").executeQuery("select name from food where id=" + foodid);
            String foodName=null;
            while (resultSet1.next()){
                foodName=resultSet1.getString(1);
            }
            //生成类似时间订单编号
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
            String orderid = sdf.format(date);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String orderdate = sdf2.format(date);

            int i = jdbc工具.getStatement("foodtogo", "root", "202306").executeUpdate("insert into order1 values('" + orderid + "','" + foodName + "','" + orderdate + "','"+username+"')");
            //显示当前用户的所有订单
            printOdersInfo(username);

        }else{
            System.out.println("登陆失败");
            //矫正信息重新登陆
        }
    }

    private static void printOdersInfo(String username) {
        Statement statement = jdbc工具.getStatement("foodtogo", "root", "202306");
        try {
            ResultSet resultSet = statement.executeQuery("select * from order1 where username='" + username + "'");
            List<Order> orders = new ArrayList<>();
            while (resultSet.next()){
                Order order = new Order();
                order.setOrderid(resultSet.getString(1));
                order.setFoodname(resultSet.getString(2));;
                order.setOrderdate(resultSet.getString(3));
                orders.add(order);
            }

            for (Order o:orders){
                System.out.println(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        login();

    }
}



