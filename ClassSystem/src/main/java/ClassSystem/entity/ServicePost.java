package ClassSystem.entity;

import ClassSystem.utility.Const;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class ServicePost<R> implements Serializable {
    private int code;
    private String msg;
    private R data;
    private List<R> list;
    private int total;

    public ServicePost() {
    }

    public ServicePost(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServicePost(int code, R data) {
        this.code = code;
        this.data = data;
    }

    public ServicePost(int code, List<R> list) {
        this.code = code;
        this.list = list;
    }

    public ServicePost(int code, List<R> list,int total) {
        this.code = code;
        this.list = list;
        this.total = total;
    }

    public ServicePost(int code, String msg, R data, List<R> list) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.list = list;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public R getData() {
        return data;
    }

    public void setData(R data) {
        this.data = data;
    }

    public List<R> getList() {
        return list;
    }

    public void setList(List<R> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    //返回成功信息
    public static ServicePost CreateTrueCodMsg(String msg){
        return new ServicePost(Const.true_200,msg);
    }
    //返回错误信息
    public static ServicePost CreateErrorCodMsg(String msg){
        return new ServicePost(Const.false_101,msg);
    }
    //登录验证（验证token）
    public ServicePost CreateTrueLogin(R data){
        return new ServicePost(Const.true_200,msg);
    }
    //首页获取平台数据
    public ServicePost PersonNum(R data){
        return new ServicePost(Const.true_200,data);
    }
    //返回学生and老师列表以及行数
    public ServicePost CreateTrueCodMsgList(List<R> list,int total,String msg){
        return new ServicePost(Const.true_200,list,total);
    }
}
