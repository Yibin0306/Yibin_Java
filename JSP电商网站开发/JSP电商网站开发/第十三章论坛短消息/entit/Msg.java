package 第十三章论坛短消息.entit;

public class Msg {
    private Integer msgid;
    private String title;
    private String username;
    private String datetime;
    private Integer slate;
    private String conter;
    private String sendto;

    @Override
    public String toString() {
        return "Msg{" +
                "msgid=" + msgid +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", datetime='" + datetime + '\'' +
                ", slate=" + slate +
                ", conter='" + conter + '\'' +
                ", sendto='" + sendto + '\'' +
                '}';
    }

    public Integer getMsgid() {
        return msgid;
    }

    public void setMsgid(Integer msgid) {
        this.msgid = msgid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getSlate() {
        return slate;
    }

    public void setSlate(Integer slate) {
        this.slate = slate;
    }

    public String getConter() {
        return conter;
    }

    public void setConter(String conter) {
        this.conter = conter;
    }

    public String getSendto() {
        return sendto;
    }

    public void setSendto(String sendto) {
        this.sendto = sendto;
    }

    public Msg(Integer msgid, String title, String username, String datetime, Integer slate, String conter, String sendto) {
        this.msgid = msgid;
        this.title = title;
        this.username = username;
        this.datetime = datetime;
        this.slate = slate;
        this.conter = conter;
        this.sendto = sendto;
    }

    public Msg() {
    }
}
