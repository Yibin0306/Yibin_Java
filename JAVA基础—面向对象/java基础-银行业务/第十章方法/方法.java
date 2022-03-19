package 第十章方法;

public class 方法 {
    public int getsum(int a,int b,int c){
        return a+b+c;
    }

    public static void main(String[] args) {
       方法 cs = new 方法();
       int sum = cs.getsum(5,6,7);
        System.out.println(sum);
    }
}
