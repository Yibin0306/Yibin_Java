package 第五章多态;

public class 案例 {
    //自定义动物的叫法
    public void shout(){
        System.out.println("动物发出叫声");
    }
}

class dog extends 案例 {
    //自定义狗是怎么叫的
    public void shout(){
        System.out.println("汪汪汪汪汪...");
    }
}

class cat extends 案例{
    //自定义猫是怎么叫的
    public void shout(){
        System.out.println("喵喵喵喵喵...");
    }
}

// 测试
//  案例 1
class Sample{
    public static void main(String[] args) {
        //调用 dog 的 shout 方法
        案例 dog = new dog();
        dog.shout();
        //调用 cat 的 shout 方法
        案例 cat = new cat();
        cat.shout();
        animaShout(cat);
    }

    public static void animaShout(案例 animal) {
        // 将Animal 强制转换为 Cat
        cat cat = (cat) animal;
        cat.shout();
    }
}

// 案例 2
class Sample1{
    public static void main(String[] args) {
        // 调用dog的shout方法
        案例 dog = new dog();
        dog.shout();
        //调用 cat 的 shout 方法
        案例 cat = new cat();
        cat.shout();

        animalShout(dog);
        animalShout(cat);
    }

    public static void animalShout(案例 animal) {
        if (animal instanceof  cat){
            // 将Animal 强制转换为 Cat
            cat cat = (cat) animal;
            cat.shout();
        }else {
            System.out.println("传入参数类型错误");
        }
    }
}