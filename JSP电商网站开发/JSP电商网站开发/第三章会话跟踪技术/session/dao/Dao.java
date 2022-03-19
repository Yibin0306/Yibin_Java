package 第三章会话跟踪技术.session.dao;

import 第三章会话跟踪技术.session.entit.Entit;

import java.util.List;

public interface Dao {
    List<Entit> selectAllEntit();

    Boolean selectEntitByNameAndPwd(Entit Entit);

}
