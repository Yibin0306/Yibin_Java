package 第四章继承;

public class 案例2 {
    //自定义动物的叫法
    public void shout(){
        System.out.println("动物发出叫声");
    }
}

class dog extends 案例2{
    //自定义狗是怎么叫的
    public void shout(){
        System.out.println("喵喵喵喵...");
    }
}

// 测试
class Sample{
    public static void main(String[] args) {
        dog dog = new dog();
        dog.shout();
    }
}