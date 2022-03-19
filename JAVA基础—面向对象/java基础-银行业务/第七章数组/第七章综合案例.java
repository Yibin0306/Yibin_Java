package 第七章数组;

import java.util.Scanner;
public class 第七章综合案例 {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("***************");
        System.out.println("    ATM系统    ");
        System.out.println("***************");
        System.out.println();
        System.out.print("请输入用户名:");
        String name = cs.next();
        System.out.print("请输入密码:");
        int mm = cs.nextInt();
        int money = 2000;
        if (name.equals("cyb")&&mm==202306){
            String[] changmoney = new String[10000];
            int tuichu;
            do {
                System.out.println("1.存款 2.取款 3.交易信息 4.查询余额 5.退出");
                tuichu = cs.nextInt();
                switch (tuichu){
                    case 1:
                        System.out.print("请输入存款金额:");
                        double setmoney = cs.nextDouble();
                        if (setmoney>1000){
                            System.out.println("存款金额不能大于1000！");
                        }else if (setmoney<0){
                            System.out.println("存款不能为负数");
                        }else if (setmoney%100!=0){
                            System.out.println("不能存零钱");
                        }else {
                            money+=setmoney;
                            for (int i=0;i<changmoney.length;i++){
                                if (changmoney[i]==null){
                                    String msg = "存"+setmoney+"元";
                                    changmoney[i]=msg;
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.print("请输入取款金额:");
                        double getmoney = cs.nextDouble();
                        if (getmoney>1000){
                            System.out.println("取款金额不能大于1000！");
                        }else if (getmoney<0){
                            System.out.println("取款不能为负数");
                        }else if (getmoney%100!=0){
                            System.out.println("不能取零钱");
                        }else if (getmoney>money){
                            System.out.println("余额不足");
                        } else {
                            money-=getmoney;
                            for (int i=0;i<changmoney.length;i++){
                                if (changmoney[i]==null){
                                    String msg = "取"+getmoney+"元";
                                    changmoney[i]=msg;
                                    break;
                                }
                            }
                        }
                        break;
                    case 3:
                        for (int i=0;i<changmoney.length;i++){
                            if (changmoney[i]!=null){
                                System.out.println(changmoney[i]);
                            }
                        }
                        break;
                    case 4:{
                        System.out.println("余额"+money);
                    }

                }
            }while (tuichu!=5);
            System.out.println("退出成功！");
        }else {
            System.out.println("账户或密码错误，请重新登录！");
        }
    }
}