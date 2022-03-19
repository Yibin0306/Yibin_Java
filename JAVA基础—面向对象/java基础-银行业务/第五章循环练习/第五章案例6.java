package 第五章循环练习;

import java.util.Scanner;
import java.util.SplittableRandom;

public class 第五章案例6 {
    public static void main(String[] args) {
        int cj;//每门课成绩
        int sum = 0;//成绩的和
        int avg;//平均数
        boolean fs = false;//是否为负数
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生的姓名：");
        String name = input.next();
        int i = 0;
        while (i<3){
            System.out.println("请输入第"+(i+1)+"门的成绩:");
            cj = input.nextInt();
            if (cj<0){
                fs = true;
                break;
            }
            sum+=cj;
            i++;
        }
        if (fs){
            System.out.println("成绩有误，请重新输入！");
        }else {
            avg = sum / 3;
            System.out.println(name+"的平均数是："+avg);
        }
    }
}