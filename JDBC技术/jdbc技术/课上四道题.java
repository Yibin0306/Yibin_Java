import java.util.Scanner;

public class 课上四道题 {
    public static void main(String[] args) {
        //题1：int[] numbers = {5, 2, 56, 324, 78, 134, 56, 56, 6, 98};使用冒泡排序，从小到大
        System.out.println("题目一");
        int[] numbers = {5, 2, 56, 324, 78, 134, 56, 56, 6, 98};
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后的结果是：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        // ----------------------------------
        //题2：利用条件运算符嵌套哦来完成此题：学习成绩>=90分的同学用A表示，学习成绩>=60分的同学用B表示，学习成绩<60分的同学用C表示
        System.out.println("");
        System.out.println("题目二");
        System.out.print("请输入您的成绩：");
        Scanner scanner = new Scanner(System.in);
        double s = scanner.nextInt();
        int a = s>=90 ? 1:s >= 60 ? 2:3;
        if (a == 1){
            System.out.println("成绩为A");
        }else if(a == 2){
            System.out.println("成绩为B");
        }else {
            System.out.println("成绩为C");
        }
        //-----------------------------------
        //题3：一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第10次落地时，共经过多少米？第10次反弹多高？
        System.out.println("题目三");
        double sum = 0;
        double height = 100;
        for (int i=1;i<=10;i++){
            sum = height+height/2+sum;
            height=height/2;
        }
        sum=sum-height;
        System.out.println("经历过"+sum+"米");
        System.out.println("第十次弹了"+height+"米");
        //-----------------------------------
        //题4：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
        //方法1：
        /**
         * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少
         * 分析：
         *  按照给题的思路
         *  假设这个整数是i
         *  定义两个未知数为num1 num2
         *  num1 = (i + 100) * (i + 100)
         *  num2 = (i + 100 + 168) * (i + 100 + 168)
         *  因为不知道i为多少的情况,所以我们从0-100000遍历i来计算num1与录num2是否符合要求
         */
        System.out.println("题目四：方法一");
        double num1,num2;
        for (int i=-100;i<=2000;i++){
            num1 = Math.sqrt(i+100);
            num2 = Math.sqrt(i+100+168);
            if (num1 == (int)num1 && num2 == (int)num2){
                System.out.println(i);
            }
        }

        //方法2：
        /**
         * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少
         * 分析：
         * 按照给题的思路
         * 假设这个整数是num
         * (num+100) = i * i
         * (num+100+168) = j * j
         * 得到
         * (j * j) - (i * i) = 168
         * (j + i)(j - i) = 168
         * j - i 最小等于 1 时 j 与 i 都不大于 168 并且j > i
         * 等到如下解：
         */
        System.out.println("题目四：方法二");
        for (int i=0;i<168;i++){
            for (int j=i+1;j<168;j++){
                if (j*j - i*i == 168){
                    System.out.println(i*i-100);
                }
            }
        }
    }
}
