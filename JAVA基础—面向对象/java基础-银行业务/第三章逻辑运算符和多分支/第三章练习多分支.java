package 第三章逻辑运算符和多分支;

import java.util.Scanner;
public class 第三章练习多分支 {
    public static void main(String[] args) {
        Scanner cj = new Scanner(System.in);
        System.out.println("请输入你的分数：");
        int fs = cj.nextInt();
        if (fs > 95 && fs <= 100){
            System.out.println("考的不错，奖励你一块手表");
        }else if (fs >= 60 && fs <= 95){
            System.out.println("继续努力，为了得到手表");
        }else if (fs >= 0 && fs <60){
            System.out.println("考试不及格，请努力学习");
        }else {
            System.out.println("虚假成绩");
        }
    }
}
