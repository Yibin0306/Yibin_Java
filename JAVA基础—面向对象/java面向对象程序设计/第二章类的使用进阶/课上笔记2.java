package 第二章类的使用进阶;

public class 课上笔记2 {
    {
        System.out.println("aaaa");
    }
    static {
        System.out.println("bbbb");
    }
    public 课上笔记2(){
        System.out.println("无参..");
    }
    public 课上笔记2(int a){
        System.out.println("有参..");
    }

    public static void main(String[] args) {
        new 课上笔记2();
        new 课上笔记2();
        new 课上笔记2(1);

    }
}
