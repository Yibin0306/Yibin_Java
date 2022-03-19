package 第七章抽象类和接口;

public abstract class Animal {
    public abstract void go();
    public void sleep(){
        System.out.println("小睡一会");
    }
}

class Bird extends Animal{
    @Override
    public void go() {
        System.out.println("鸟飞的快");
    }
}

 class Dog extends Animal{
     @Override
     public void go() {
         System.out.println("狗跑得快");
     }
 }

 class AnimalTest{
     public static void main(String[] args) {
         new Bird().sleep();
         new Dog().go();
         new Dog().sleep();
         new Dog().go();
     }
 }