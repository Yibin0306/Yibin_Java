package 第五章循环练习;

import java.util.Scanner;
public class 第五章案例7 {
    public static void main(String[] args) {
        int cj;//成绩
        int zrs;//总人数
        int num = 0;//成绩大于八十的人
        Scanner input = new Scanner(System.in);
        System.out.println("请输入班级的人数：");
        zrs = input.nextInt();//班级的总人数
        int i = 0;
        while (i<zrs){
            i++;
            System.out.println("请输入第"+i+"位的学生成绩：");
            cj = input.nextInt();
            if (cj<80){
                continue;
            }
            num++;
        }
        System.out.println("80分人数以上的学生人数是"+num);
        double rate = (double) num /zrs *100;
        System.out.println("80分以上的学生所占的比例为："+rate+"%");
    }
}
