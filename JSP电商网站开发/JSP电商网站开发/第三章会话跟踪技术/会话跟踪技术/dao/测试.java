package 第三章会话跟踪技术.会话跟踪技术.dao;

import 第三章会话跟踪技术.会话跟踪技术.entit.会话跟踪技术;

public class 测试 {
    public static void main(String[] args) {
        会话跟踪技术 tom = new 会话跟踪技术DaoImp().select会话跟踪技术ByNameAndPwd(new 会话跟踪技术("cyb", "123"));
        System.out.println(tom);

    }
}
