package 复习;

public class 课上练习 {
    // 整数类型变量
    int age;
    // 声明一个char类型变量sex 初始值女
    char sex = '女';
    // 声明一个getAge方法，方法中打印四的sex变量的值
    public void getAge(){
        System.out.println(sex);
    }
    // 声明一个getsum方法，接受两个整数参数m，n，返回m+n
    public int getSum(int m,int n){
        int sum = m+n;
        return sum;
    }
    //声明一个getsum2的方法，接受一个整数参数n，返回1+2+..+（n-1）+n的和
    public  int getSum2(int n){
        int sum=0;
        for (int i=1;i<=n;i++){
             sum+=i;
        }
        return sum;
    }

    //声明一个getavg函数，接受三个整数参数x，y，z返回（x+y+z）/3的平均值
    public int getAvg(int x,int y,int z){
        int avg = (x+y+z)/3;
        return avg;
    }

    // 调用
    public static void main(String[] args) {
        课上练习 sc = new 课上练习();
        sc.getAge();

        int sum = sc.getSum(3,4);
        System.out.println(sum);

        int sum2 = sc.getSum2(5);
        System.out.println(sum2);

        int avg = sc.getAvg(3,4,3);
        System.out.println(avg);
    }
}
