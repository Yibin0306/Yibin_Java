package 第七章MVC.entit;

public class 投票 {
    private Integer id;
    private String item;
    private Integer times;

    @Override
    public String toString() {
        return "投票{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", times=" + times +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public 投票(Integer id, String item, Integer times) {
        this.id = id;
        this.item = item;
        this.times = times;
    }

    public 投票() {
    }
}
