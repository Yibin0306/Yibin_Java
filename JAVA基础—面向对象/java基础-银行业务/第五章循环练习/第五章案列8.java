package 第五章循环练习;

import java.util.Scanner;
public class 第五章案列8 {
    public static void main(String[] args) {
        //命名用户账户和密码
        String yhm = "chuyibin";
        String mm = "202306";
        System.out.println("*****************************\n\t\t欢迎登录ATM系统\n*****************************");
        System.out.println("\n");
        //初始化钱数
        int moeny = 500;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：\n");
        String sryhm = input.next();
        System.out.print("请输入密码：\n");
        String srmm = input.next();
        //判断用户名密码是否能登陆
        if (sryhm.equals(yhm)&&srmm.equals(mm))/*这里不可以用 = 需要用equals*/{
            System.out.println("登录成功！");
            System.out.println("1.存钱\n2.取钱\n3.退出");
            System.out.println("请你选择要进行的操作");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("输入存款金额");
                    double setmomey = input.nextDouble();
                    if (setmomey>1000){
                        System.out.println("单次存款不能大于1000");
                        setmomey=0;
                    }else if (setmomey<0){
                        System.out.println("不能存入为负数的钱！！");
                        setmomey=0;
                    }else if (setmomey%100 != 0){
                        System.out.println("不能存零钱");
                    }else {
                        System.out.println("存款成功！"+setmomey+"余额："+(setmomey+moeny));
                    }
                    break;
                case 2:
                    System.out.println("请输入取款金额");
                    double getmony = input.nextDouble();
                    if (getmony>moeny){
                        System.out.println("余额不足");
                    }else if (getmony%100 !=0){
                        System.out.println("不能取零钱");
                    }else if (getmony>1000){
                        System.out.println("单次存款不能大于1000");
                    }else {
                        System.out.println("取款成功！"+getmony+"余额："+(moeny-getmony));
                    }
                    break;
                case 3:
                    System.out.println("退出成功,请拔出");
                    break;
            }
        }else {
            System.out.println("用户或密码错误！");
        }
    }
}