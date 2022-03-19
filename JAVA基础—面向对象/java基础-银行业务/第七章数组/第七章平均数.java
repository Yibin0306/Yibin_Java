package 第七章数组;

import java.util.Scanner;
//五名学生平均分
public class 第七章平均数 {
    public static void main(String[] args) {
        int [] cj = new int[5];
        Scanner cs = new Scanner(System.in);
        System.out.println("请输入学生成绩");
        double sum = 0;
        for (int i=0 ;i<5;i++){
            int c = cs.nextInt();
            sum+=c;
            cj[i]=c;
        }
        System.out.println(sum/ cj.length);
    }
}
