package 第十一章综合项目;
import java.util.Scanner;
public class 综合项目 {
    //初始化
    String name;
    int spkucun;
    double spjg;
    int spsc;
    public void setSpkucun(int index){
        System.out.println(index+"\t"+name+"\t"+spjg+"\t"+spkucun+"\t"+spsc);
    }
    public static void main(String[] args) {
        项目.Spleixing[] cs = new 项目.Spleixing[50];
        项目.SpleixingSet spleixingSet = new 项目.SpleixingSet();
        Scanner input = new Scanner(System.in);


        //初始化商品数据
        项目.Spleixing xiaoMi9 = new 项目.Spleixing();
        xiaoMi9.name = "小米9";
        xiaoMi9.spjg = 2799;
        xiaoMi9.spkucun = 60;
        xiaoMi9.spsc = 0;
        项目.Spleixing xiaoMi8 = new 项目.Spleixing();
        xiaoMi8.name = "小米8";
        xiaoMi8.spjg = 2099;
        xiaoMi8.spkucun = 40;
        xiaoMi8.spsc = 0;
        项目.Spleixing redMi7 = new 项目.Spleixing();
        redMi7.name = "RedMi7";
        redMi7.spjg = 699;
        redMi7.spkucun = 80;
        redMi7.spsc = 0;
        项目.Spleixing xiaoMi6x = new 项目.Spleixing();
        xiaoMi6x.name = "小米6x";
        xiaoMi6x.spjg = 749;
        xiaoMi6x.spkucun = 100;
        xiaoMi6x.spsc = 0;
        spleixingSet.cs[0] = xiaoMi9;
        spleixingSet.cs[1] = xiaoMi8;
        spleixingSet.cs[2] = redMi7;
        spleixingSet.cs[3] = xiaoMi6x;


        boolean flag = true;//是否继续操作
        do {
            System.out.println("欢迎使用前程商城后台管理系统");
            System.out.println("-----------------------------");
            System.out.println("1.查看商品信息");
            System.out.println("2.新增商品信息");
            System.out.println("3.删除商品信息");
            System.out.println("4.卖出商品");
            System.out.println("5.商品销售排名榜");
            System.out.println("6.退出");
            System.out.println("-----------------------------");
            System.out.print("请选择要执行的操作：");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("查看商品信息");
                    System.out.println("编号\t名称\t\t价格\t\t库存\t售出");
                    for (int i=0;i<spleixingSet.cs.length;i++){
                        if (spleixingSet.cs[i]!=null){
                            spleixingSet.cs[i].setSpkucun(i+1);
                        }
                    }
                    break;
                case 2:
                    System.out.println("新增商品信息");
                    System.out.print("请输入商品名称：");
                    String name = input.next();
                    System.out.print("请输入价格：");
                    int spjg = input.nextInt();
                    System.out.print("请输入库存：");
                    int spkucun = input.nextInt();
                    项目.Spleixing spleixing = new 项目.Spleixing();
                    spleixing.name=name;
                    spleixing.spjg=spjg;
                    spleixing.spkucun=spkucun;
                    spleixing.spsc=0;
                    for (int i = 0;i<spleixingSet.cs.length;i++){
                        if (spleixingSet.cs[i]==null){
                            spleixingSet.cs[i]=spleixing;
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("删除商品信息");
                    System.out.print("请输入商品编号：");
                    boolean gta5 = true;
                    int card = input.nextInt();
                    for (int i=0;i<spleixingSet.cs.length;i++){
                        if (spleixingSet.cs[i]!=null&&(i+1)==card){
                            int j = i;
                            while (spleixingSet.cs[j+1]!=null){
                                spleixingSet.cs[j]=spleixingSet.cs[j+1];
                                j++;
                            }
                            spleixingSet.cs[j]=null;
                            flag=true;
                            break;
                        }else {
                            flag=false;
                        }
                    }
                    if (flag){
                        System.out.println("删除成功！");
                    }else {
                        System.out.println("删除失败，请重新操作！");
                    }
                    break;
                case 4:
                    System.out.println("卖出商品");
                    System.out.print("请输入你要卖出商品的名称：");
                    String mz = input.next();
                    boolean zz = true;
                    for (int i=0;i<spleixingSet.cs.length;i++){
                        if (spleixingSet.cs[i]!=null&&spleixingSet.cs[i].name.equals(mz)){
                            System.out.print("请输入你卖出的数量：");
                            int spsc = input.nextInt();
                            if (spsc<=spleixingSet.cs[i].spkucun){
                                spleixingSet.cs[i].spsc=spleixingSet.cs[i].spsc+spsc;
                                spleixingSet.cs[i].spkucun=spleixingSet.cs[i].spkucun-spsc;
                                zz=true;
                            }else {
                                System.out.println("商品数量不够，请抓紧进货！");
                                zz=false;
                            }
                            break;
                        }else {
                            zz=false;
                        }
                    }
                    if (zz){
                        System.out.println("卖出商品成功！");
                    }else {
                        System.out.println("卖出商品失败！");
                    }
                    break;
                case 5:
                    System.out.println("商品销售排行榜");
                    for (int i=0;i<cs.length;i++){
                        if (spleixingSet.cs[i]!=null){
                            cs[i]=spleixingSet.cs[i];
                        }
                    }
                    for (int i=0;i<spleixingSet.cs.length-1;i++){
                        for (int j=0;j<cs.length-i-1;j++){
                            if (cs[j+1]!=null){
                                if (cs[j].spsc<cs[j+1].spsc){
                                    项目.Spleixing ss= cs[j];
                                    cs[j]=cs[j+1];
                                    cs[j+1]=ss;
                                }
                            }
                        }
                    }
                    System.out.println("*******************");
                    System.out.println("名次\t销售数量\t商品名称");
                    for (int i=0;i< cs.length;i++){
                    if (cs[i]!=null){
                        System.out.println(i+1+"\t"+cs[i].spsc+"\t"+cs[i].name);
                        }
                    }
                    break;
                case 6:
                    System.out.println("感 谢 使 用！");
                    flag = false;
                    break;
            }
        }while (flag);
    }
}