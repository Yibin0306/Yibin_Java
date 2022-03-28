package ClassSystem.entity;

public class Student {
    private String studentid;
    private String name;
    private String phone;
    private String dorm;
    private String address;
    private String classname;

    public Student() {
    }

    public Student(String studentid, String name, String phone, String dorm, String address, String classname) {
        this.studentid = studentid;
        this.name = name;
        this.phone = phone;
        this.dorm = dorm;
        this.address = address;
        this.classname = classname;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDorm() {
        return dorm;
    }

    public void setDorm(String dorm) {
        this.dorm = dorm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid='" + studentid + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", dorm='" + dorm + '\'' +
                ", address='" + address + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
