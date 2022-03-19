package 第三章封装;
// 一.java三大特性
//   1.封装：第三章
//     1.封装：保护代码私密性
//     2.封装的步骤
//       1.属性私有化   属性上加上  private 关键字
//       2.提供公开的getter/setter  方法
//       3.可以在getter/setter  设置条件
//       4.快速生产getter/setter  alt+insert
// 2.继承：第四章
// 3.多态：第五章
// 二.异常：第六章
// 三.抽象类和接口：第七章
// 四.集合     1.collection  接口  子接口  list  set  | map   第八章
// 五.泛型：第九章
// 六.I/O 流   输入输出流    第十章
// 七.线程：第十一章
public class 课上笔记 {
    //     1.封装：保护代码私密性
    //     2.封装的步骤
    //       1.属性私有化   属性上加上  private 关键字
    //       2.提供公开的getter/setter  方法
    //       3.可以在getter/setter  设置条件
    //       4.快速生产getter/setter  alt+insert
    //     3.四大访问修饰符
    //       1.private 同一类   2.不写 同一个包   3.protectde 子类   4.public 所有类
    private  String name;
    private  String pwd;
    private  int age;
    private  String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    // 注解：覆盖的意思
    @Override
    public String toString() {
        return "课上笔记{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
