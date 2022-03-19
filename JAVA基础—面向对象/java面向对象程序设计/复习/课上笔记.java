package 复习;

public class 课上笔记 {
    // 声明一个年龄变量，初始的值为23
    int age = 23;
    // 声明一个变量工资：精确到小数点后10位
    double salary;
    // 定义一个变量 初始值为男
    char sex = '男';
    // 声明一个getsum的方法，接收三个整型的参数，返回三个整数的和
    public int getsum(int num1,int num2,int num3){
        int sum = num1+num2+num3;
        return sum;
    }
    // 声明一个say方法，打印“hello..”
    public void say() {
        System.out.println("hello..");
    }
    // 方法的使用   声明main函数   psvm
    public static void main(String[] args) {
        // 看看方法在哪个类   课上笔记
        // 创建方法所在类的对象 new
        课上笔记 sc = new 课上笔记();//alt + 回车提取变量名
        //调用方法   .
        sc.getsum(1,2,1);
    }
}
