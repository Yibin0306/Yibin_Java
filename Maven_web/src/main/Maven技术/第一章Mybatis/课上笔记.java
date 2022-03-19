package 第一章Mybatis;

public class 课上笔记 {
}
/*
    一.基础
        1.持久层（持久化技术）的框架
        2.封装原生的JDBC
        3.JDBC缺点
            1.代码复杂（冗余）
            2.ORM对象关系映射，手动的
            3.JDBC效率低
        4.开发
            1.开发整个dao数据访问层
                1.表
                2.实体类
                3.dao接口
                4.dao实现类
            2.Mybatis开发dao数据层
                1.表
                2.实体类
                3.dao接口
                4. .xml
        5.Mybatis环境的搭建
            1.创建模块
            2.引入jar  Mybatis.jar  mysql驱动
            3.实体类

    二.实体-实体
        1.一对一
            用户数据
        2.一对多
            用户部门
        3.多对多

    三.动态sql
        1.sql片段

        2.多条件搜索

        3.Foreach
    四.缓存
        存在的问题：查询相同的数据，大量的网络IO JDBC:mysql：//.....
        查出出数据，存放到缓存区内
        配置Mybatis缓存
        Mybatis核心配置文件
        <settings>
            <setting name="cacheEnabled" value="ture"></setting>
        </settings>

        mapper.xml中配置
        <cache/>

*/

