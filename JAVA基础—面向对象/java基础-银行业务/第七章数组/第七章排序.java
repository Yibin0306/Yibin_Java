package 第七章数组;

import java.util.Arrays;
public class 第七章排序 {
    public static void main(String[] args) {
        int[] arr1 = {50,60,8,30,3};
            //排序从小到大 Arrays.sort(数组名)
        System.out.print("排序前");
        for (int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+",");
        }
        //工具类Arrays 排序方法sort(); 参数 数据
        Arrays.sort(arr1);
        System.out.println("\n排序后");
        for (int i=0;i<arr1.length;i++){
            System.out.print(arr1[i]+",");
        }
    }
}
