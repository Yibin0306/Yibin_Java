package 第五章循环练习;

public class 第五章循环练习 {
    public static void main(String[] args) {
        //  while循环（1-10）之间的和，方法1
        /*int i = 1;
        int sum = 0;
        while (i<=10){
            sum=sum+i;
            i++;
        }
        System.out.println(sum);
         */


        //（1-10）之间的和,方法2
        /*int i = 1;
        int sum = 0;
        do {
            sum+=i;
            i++;

        }while (i<=10);

        System.out.println(sum);
         */


        //（1-10）之间的和
       /* int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);
        */


        //打印出1-100整数，到77的倍数停止
        /*for (int i=1;i<=100;i++){
            if (i%77 == 0){
                break;
            }
            System.out.print(i+",");
        }
         */



    }
}