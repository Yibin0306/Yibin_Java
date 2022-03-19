package 大一下学期综合练习;


import java.util.Date;

public class Order {
    private String orderid;
    private String foodname;
    private String orderdate;

    public Order() {
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public Order(String orderid, String foodname, String orderdate) {
        this.orderid = orderid;
        this.foodname = foodname;
        this.orderdate = orderdate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", foodname='" + foodname + '\'' +
                ", orderdate='" + orderdate + '\'' +
                '}';
    }
}
