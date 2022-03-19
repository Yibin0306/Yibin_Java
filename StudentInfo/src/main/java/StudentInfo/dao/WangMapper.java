package StudentInfo.dao;

import StudentInfo.entity.Wang;
import StudentInfo.entity.WangExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WangMapper {
    long countByExample(WangExample example);

    int deleteByExample(WangExample example);

    int insert(Wang record);

    int insertSelective(Wang record);

    List<Wang> selectByExample(WangExample example);

    int updateByExampleSelective(@Param("record") Wang record, @Param("example") WangExample example);

    int updateByExample(@Param("record") Wang record, @Param("example") WangExample example);
}