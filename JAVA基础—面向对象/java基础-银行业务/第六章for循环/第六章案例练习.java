package 第六章for循环;

import java.util.Scanner;
public class 第六章案例练习 {
    //案例银行卡输入三次错误密码，银行卡被吞
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("*******************");
        System.out.println("   欢迎登录银行系统   ");
        System.out.println("*******************");
        for (int i=2;i>=0;i--){
            System.out.println("请输入用户名");
            String yhm = cs.next();
            System.out.println("请输入密码");
            int mm = cs.nextInt();
            if (yhm.equals("cyb") && mm==123){
                System.out.println("1.取款 2.存款 3.退出");
                break;
            }else {
                System.out.println("密码错误，剩余"+i+"次错误");
                if (i==0){
                    System.out.println("你的卡被吞...");
                }
            }

        }
    }


}
