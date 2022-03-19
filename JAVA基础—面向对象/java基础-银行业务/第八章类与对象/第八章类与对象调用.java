package 第八章类与对象;

public class 第八章类与对象调用 {
    public static void main(String[] args) {
        第八章类与对象 cs = new 第八章类与对象();
        System.out.println("**初始化书院的变量前**");
        cs.showBranch();
        cs.schoolName = "河南测绘职业学院";
        cs.classNumber = 20;
        cs.labNumber = 20;
        System.out.println("**初始化书院的变量后**");
        cs.showBranch();
    }
}
