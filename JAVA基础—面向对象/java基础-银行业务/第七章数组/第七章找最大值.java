package 第七章数组;

import java.util.Scanner;
public class 第七章找最大值 {
    public static void main(String[] args) {
        Scanner cj = new Scanner(System.in);
        int[] c = new int[5];
        System.out.println("请输入五位学员的成绩");
        for (int i=0;i<c.length;i++){
            int cs = cj.nextInt();
            c[i] = cs;
        }
        //求最大值
        int max = c[0];
        for (int i = 1;i<c.length;i++){
            if (c[i]>max){
                max = c[i];
            }
        }
        System.out.print("最高成绩为："+max);
    }
}
