package 第四章switch分支结构;/*
switch 分支结构

    语法：
    关键字 switch（内部数字和case数字对应）   case（新一个）  default（如果之前都没有，运行这一个）   break（结束这一行）

    switch(2){
        case 1: sout语句1  break;
        case 2: sout语句2  break;
        case 3: sout语句3  break;
        case 4: sout语句4  break;

        defalult sout语句5 break;
    }
package chapter4;

import java.util.Scanner;
*/


import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class 第四章switch分支结构 {
    public static void main(String[] args) {
        //输入名次
        System.out.println("请输入1-3的奖励..");
        //条件
        Scanner mc = new Scanner(System.in);
        int cj = mc.nextInt();
        switch (cj) {
            case 1:
                System.out.println("参加夏令营一个月");
                break;
            case 2:
                System.out.println("奖励笔记本一个月");
                break;
            case 3:
                System.out.println("奖励移动硬盘一个");
                break;
            default:
                System.out.println("没有奖励..");
                break;
        }
    }
}
