package 第三章逻辑运算符和多分支;

import java.util.Scanner;
public class 第三章逻辑运算符 {
    public static void main(String[] args) {
        System.out.println("输入你的成绩：");
        Scanner fs = new Scanner(System.in);
        int cj = fs.nextInt();
        //&&是且
//        if (cj >= 0 && cj <60){// 且 一假则假
//            System.out.println("不及格");
//        }else {
//            System.out.println("及格");
//        }

        //||是或
//        if (cj >= 0 || cj <60){// 或 一真则真
//            System.out.println("不及格");
//        }else {
//            System.out.println("及格");
//        }

        //！是非
        if (!(cj<60)){// ！ 非 取反
            System.out.println("不及格");
        }else {
            System.out.println("及格");
        }
    }
}
