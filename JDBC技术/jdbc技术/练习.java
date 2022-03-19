public class 练习 {
    public static void main(String[] args) {
        /*继承，封装，多态
        * new
        * object
        * public，默认-----------
        * pritave
        * super
        * en--------
        * -------
        * static---------
        * */
        int[] numbers = {5, 2, 56, 324, 78, 134, 56, 56, 6, 98};
        for (int i=0;i<numbers.length-1;i++){
            for (int j=0;j<numbers.length-1-i;j++){
                if (numbers[j]>numbers[j+1]){
                    int sc = numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=sc;
                }
            }
        }
        for (int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
