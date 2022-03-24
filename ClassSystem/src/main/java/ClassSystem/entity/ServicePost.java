package ClassSystem.entity;

public class ServicePost {
    private String msg;
    private Integer code;

    public ServicePost() {
    }

    public ServicePost(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ServicePost{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
