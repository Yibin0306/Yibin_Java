package 第十一章综合项目;
import java.util.Scanner;
public class 项目 {
    public static class Spleixing{
        public String name;
        public int spkucun;
        public double spjg;
        public int spsc;
        //商品展示
        public void setSpkucun(int index){
            System.out.println(index+"\t"+name+"\t"+spjg+"\t"+spkucun+"\t"+spsc);
        }
    }
        //商品集合类
        public static class SpleixingSet{
        Spleixing[] cs = new Spleixing[50];
    }
}


