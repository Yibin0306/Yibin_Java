package ClassSystem.entity;

import java.util.List;

public class PersonNum {
    private int teacherNum;
    private int studentNum;
    private String Notice;

    public PersonNum() {
    }

    public PersonNum(int teacherNum, int studentNum, String notice) {
        this.teacherNum = teacherNum;
        this.studentNum = studentNum;
        Notice = notice;
    }

    public int getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(int teacherNum) {
        this.teacherNum = teacherNum;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
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
        return "PersonNum{" +
                "teacherNum=" + teacherNum +
                ", studentNum=" + studentNum +
                ", Notice='" + Notice + '\'' +
                '}';
    }

}
