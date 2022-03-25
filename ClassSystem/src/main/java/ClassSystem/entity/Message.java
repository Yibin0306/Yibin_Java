package ClassSystem.entity;

import org.springframework.stereotype.Component;

@Component
public class Message {
    private Integer teacherNum;
    private Integer studentNum;
    private String Notice;

    public Message() {
    }

    public Message(Integer teacherNum, Integer studentNum, String notice) {
        this.teacherNum = teacherNum;
        this.studentNum = studentNum;
        Notice = notice;
    }

    public Integer getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(Integer teacherNum) {
        this.teacherNum = teacherNum;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        Notice = notice;
    }

    @Override
    public String toString() {
        return "Message{" +
                "teacherNum=" + teacherNum +
                ", studentNum=" + studentNum +
                ", Notice='" + Notice + '\'' +
                '}';
    }
}
