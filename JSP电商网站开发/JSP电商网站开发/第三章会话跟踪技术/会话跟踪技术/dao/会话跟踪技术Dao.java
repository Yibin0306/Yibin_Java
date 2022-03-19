package 第三章会话跟踪技术.会话跟踪技术.dao;

import 第三章会话跟踪技术.会话跟踪技术.entit.会话跟踪技术;

import java.util.List;

public interface 会话跟踪技术Dao {
    List<会话跟踪技术> selectAll会话跟踪技术();

    会话跟踪技术 select会话跟踪技术ByNameAndPwd(会话跟踪技术 会话跟踪技术);
}
