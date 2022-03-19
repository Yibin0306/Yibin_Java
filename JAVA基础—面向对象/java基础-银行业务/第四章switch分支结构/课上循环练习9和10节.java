package 第四章switch分支结构;

import java.util.Scanner;

public class 课上循环练习9和10节 {
    public static void main(String[] args) {
        //用while循环+continue计算（1-100）之间含3的整数个数
        /*int i = 1;
        while (i<=100){
            i++;
            if (i % 3 != 0){
               continue;
            }
        }
        System.out.println(i);
    }*/


        //用while打印出99乘法表格
        /*int i = 1;
        while (i <= 9) {
            int j = 1;
            while (j<=i){
                System.out.print(i+"*"+j+"="+(i*j)+" ");
                j++;
            }
            System.out.println();
            i++;
        }*/


        //打印出金字塔
        /*int i = 1;
        while (i<=4){
            int m = 4;
            while (m>=i){
                System.out.print(" ");
                m--;
            }

            int j = 1;
            while (j<=2*i-1){
                System.out.print("*");
                j++;
            }

            i++;
            System.out.println();
        }*/

        //循环右边及结果  2*5=10   4*10=40    6*15=60

        /*for (int i=0,j=0;j<=100;) {
            j = j + 5;
            i = i + 2;
            System.out.println(i + "*" + j + "=" + (i * j));
            i++;
            j++;
        }*/


        //2+4+6+..+100的值
       /* int i = 1;
        int sum = 0;
        while (i<=100){
            i++;
            if (i%2!=0){
                continue;
            }
            sum+=i;
        }
        System.out.println(sum);*/

        //循环录入5个人的年龄，计算平均年龄，如果输入出现负数或大于130立即停止报错
       /* int nl;
        int sum = 0;
        int avg;
        boolean fs = false;
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (i<5){
            i++;
            System.out.println("请输入第"+i+"人的年龄");
            nl = input.nextInt();
            if (nl<0){
                fs = true;
                System.out.println("不能输入年龄为负数！");
                break;

            }
            if (nl>130){
                System.out.println("不能输入大于130的年龄！");
                break;
            }
            sum+=nl;
        }
        avg = sum / 5;
        System.out.println("平均年龄是："+avg);*/

        //
    }

}



