package 第四章继承;
    // 案例4.2.1
public class 案例 {
    public int WheelNum;     //车轮数量

    // 私有方法
    private void flaeout(){
        System.out.println("车辆熄火");
    }

    public void launch(){
        System.out.println("启动车辆");
    }
}


class car extends 案例{
    public double carHeight; //车辆的高度

    public void run(){
        System.out.println("启动快，跑起来嗖嗖的");
    }

    public static void main(String[] args) {
        car car = new car();

        // 正常调用 public
        car.launch();

        //car.fleaout();   无法调用，子类无法调用父类的私有方法
    }
}
    //案例4.2.2
class Seden extends car{
    public void manned(){
        System.out.println("可载人...");
    }

    public static void main(String[] args) {

        Seden seden = new Seden();

        //car继承案例，Seden继承car
        //也可以使用案例中的方法，多层继承
        seden.launch();
    }
}