package 第六章for循环;

public class 第六章打印正方形三角形 {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 8; j++) {
                if ((i == 2 || i == 3) && (j > 1 && j < 8)) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.print("\n");
        }
        System.out.println("---------------------------");

        for (int i=1;i<=5;i++){
            for (int j=4;j>=i;j--){
                System.out.print(" ");
            }
            for (int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i=4;i>=1;i--){
            for (int j=4;j>=i;j--){
                System.out.print(" ");
            }
            for (int j=2*i-1;j>=1;j--){
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
