package 第七章数组;

import java.util.Arrays;
import java.util.Scanner;
public class 数组练习题 {
    public static void main(String[] args) {
        //1.录入五个整数，找出最小值
    /*    Scanner cj = new Scanner(System.in);
        int[] c = new int[5];
        System.out.println("请输入五个整数");
        for (int i=0;i<c.length;i++){
            int cs = cj.nextInt();
            c[i] = cs;
        }
        //求最小值
        int min = c[0];
        for (int i = 1;i<c.length;i++){
            if (c[i]<min){
                min = c[i];
            }
        }
        System.out.print("最小值为："+min);  */


        //2.打印五个整数，求第二大的数
       /* Scanner sz = new Scanner(System.in);
        int[] a = new int[5];
        System.out.println("请输入五个整数：");
        for (int i=0;i<a.length;i++){
            a[i]=sz.nextInt();
        }
        Arrays.sort(a);
        System.out.println("第二大值为："+a[a.length-2]); */


        //3.循环输入十个数字，去掉最大的一个数去掉一个最小的，求剩下的平均数
        /*Scanner cs = new Scanner(System.in);
        int[] a = new int [10];
        System.out.println("请输入十个数字");
        for (int i=0;i<10;i++){
            int cj = cs.nextInt();
            a[i]=cj;
        }
        Arrays.sort(a);
        int sum = 0;
        for (int i=1;i<a.length-1;i++){
            sum+=a[i];
        }
        System.out.println("剩下数的平均数："+sum/8);*/

        //4.对下面数组进行从大到小排列
       /* int[] arr1 = {45,3,78,22,67};
        //排序从小到大 Arrays.sort(数组名)
        System.out.print("排序前");
        for (int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+",");
        }
        //工具类Arrays 排序方法sort(); 参数 数据
        Arrays.sort(arr1);
        System.out.println("\n排序后");
        for (int i=4;i<arr1.length;i--){
            System.out.print(arr1[i]+",");
            if (i==0){
                break;
            }
        }*/

        //5.求上个一题的数组的和
        /*int [] arr1 = {45,3,78,22,67};
        double sum = 0;
        for (int i=0;i<arr1.length;i++){
            sum+=arr1[i];
        }
        System.out.println(sum);*/

        //6.输入10个整数存入数组，求出数组中的奇数的个数，偶数的个数
        /*Scanner cs = new Scanner(System.in);
        int[] a = new int [10];
        System.out.println("请输入十个数字");
        int o = 0;
        int j = 0;
        for (int i=0;i<10;i++){
            int cj = cs.nextInt();
            if (i%2==0){
                o++;
            }else {
                j++;
            }
            a[i]=cj;
        }
        System.out.println("偶数是："+o+"奇数是："+j);*/



        //7.对下面的数组进行翻转
        /*int[] arr1 = {45,3,78,22,67};
        System.out.print("翻转前");
        for (int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+",");
        }
        System.out.println("\n翻转后");
        for (int i=4;i<arr1.length;i--){
            System.out.print(arr1[i]+",");
            if (i==0){
                break;
            }
        }*/
    }
}
