package 第九章字符串;
import java.util.Scanner;
public class 课上案例练习 {
    public static void main(String[] args) {
        //案例1  判断字符串长短
       /* Scanner cj = new Scanner(System.in);
        String yhm,mm;
        System.out.print("请输入用户名：");
        yhm=cj.next();
        System.out.print("请输入密码：");
        mm=cj.next();
        if (mm.length()>=6){
            System.out.println("登录成功！");
        }else {
            System.out.println("密码长度不能小于六位数！");
        } */

        //案例2  判断账户密码是否正确
       /* Scanner cj = new Scanner(System.in);
        String yhm,mm;
        System.out.print("请输入用户名：");
        yhm=cj.next();
        System.out.print("请输入密码：");
        mm=cj.next();
        if (yhm.equals("cyb")&&mm.equals("202306")){
            System.out.println("登陆成功！");
        }else {
            System.out.println("登录失败！密码或账户不匹配！");
        } */

        //案例3  == 和 equals 的区别，判断字符串
       /* String arr1 = new String("秋天不回来");
        String arr2 = new String("秋天不回来");
        if (arr1.equals(arr2)){
            System.out.println("两个字符串相同");
        }else {
            System.out.println("两个字符串不相同");
        }
        if (arr1 == arr2){
            System.out.println("两个字符串相同");
        }else {
            System.out.println("两个字符串不相同");
        } */

        //案例4  equalsIgnoreCase()  用法：在比较字符串时忽略大小写
       /* Scanner cj = new Scanner(System.in);
        String yhm,mm;
        System.out.print("请输入用户名：");
        yhm=cj.next();
        System.out.print("请输入密码：");
        mm=cj.next();
        if (yhm.equalsIgnoreCase("CYB")  &&  mm.equalsIgnoreCase("CHU202306")){
            System.out.println("登陆成功！");
        }else {
            System.out.println("登录失败！密码或账户不匹配！");
        } */

        //案例5  拼接字符串
       /* int SQT = 80;
        int JAVA = 90;
        double html = 85.5;
        String lb = "SQT:"+SQT+"   JAVA:"+JAVA+"   HTML"+html;
        System.out.println("      ****成绩单****");
        System.out.println(lb); */
    }
}
