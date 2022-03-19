package 第八章类与对象;

//命名类名规范  第一个字母大写
public class 第八章类与对象 {
    //属性名：第一个字母小写，后面字母首字母大写
    String schoolName;
    int classNumber;
    int labNumber;
    //定义大学分校方法
    public void showBranch(){
        System.out.println(schoolName+"分校\n"+"配备："+classNumber+"教"+labNumber+"机");
    }
}