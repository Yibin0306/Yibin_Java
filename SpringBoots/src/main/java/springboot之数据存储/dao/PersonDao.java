package springboot之数据存储.dao;

import org.apache.ibatis.annotations.Mapper;
import springboot之数据存储.entity.Person;

import java.util.List;

@Mapper
public interface PersonDao {
    /*
    查所有
    return List<Person>
     */
    List<Person> getAll();

    /*
    根据ID查询
    {id} 要查询人员的 id
     */
    List<Person> findOne(Integer id);
    /*
    删除
    {id} 要删除人员的 id
     */
    void delete(int id);

    /*
    修改
    {p} 要更新的Person实例
     */
    void update(Person p);

    /*
    增加
    {p} 要新增的Person实例
     */
    void newp(Person p);
}
