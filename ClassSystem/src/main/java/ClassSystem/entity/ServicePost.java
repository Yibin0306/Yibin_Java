package ClassSystem.entity;

import ClassSystem.utility.Const;

import java.io.Serializable;
import java.util.List;

public class ServicePost<R> implements Serializable {
    private int code;
    private String msg;
    private R data;
    private List<R> list;

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

    public ServicePost(int code, String msg, R data, List<R> list) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.list = list;
    }

    public static ServicePost CreateTrueCodMsg(String msg){
        return new ServicePost(Const.true_200,msg);
    }

    public static ServicePost CreateErrorCodMsg(String msg){
        return new ServicePost(Const.false_101,msg);
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

    @Override
    public String toString() {
        return "ServicePost{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", list=" + list +
                '}';
    }
}
