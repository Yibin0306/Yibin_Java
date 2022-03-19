package Spring集合Redis.笔记;

public class 课上笔记 {
}
/*
    启动服务器：
        到根目录下输入
            redis-server.exe redis.windows.conf

    存值：
        到根目录下输入
            redis-cli.exe -h 127.0.0.1 -p 6379
    1.Redis 数据类型
        1.String（字符串）
            存：
                set mykey abc
            取：
                get mykey
        2.Hash（哈希）
            存：
                 HMSET name field1 "cyb" field2 "xjl"
            取：
                 hgetall name
        3.List（列表）  有序 可重复
            存：
                 127.0.0.1:6379> lpush s1 java
                (integer) 1
                127.0.0.1:6379> lpush s1 tomcat
                (integer) 2
                127.0.0.1:6379> lpush s1 mysql
                (integer) 3
                127.0.0.1:6379> lpush s1 maven
                (integer) 4
            取：
                127.0.0.1:6379> lrange s1 0 9
                1) "maven"
                2) "mysql"
                3) "tomcat"
                4) "java"
        4.Set（集合）  无序 不可重复
            存：
                127.0.0.1:6379> sadd s2 aaa
                (integer) 1
                127.0.0.1:6379> sadd s2 bbb
                (integer) 1
                127.0.0.1:6379> sadd s2 ccc
                (integer) 1
                127.0.0.1:6379> sadd s2 ccc
                (integer) 0
            取：
                127.0.0.1:6379> smembers s2
                1) "ccc"
                2) "aaa"
                3) "ddd"
                4) "bbb"
        5.Zset(sorted set：有序集合)
            存：
                127.0.0.1:6379> zadd s3 1 A
                (integer) 1
                127.0.0.1:6379> zadd s3 2 B
                (integer) 1
                127.0.0.1:6379> zadd s3 3 C
                (integer) 1
                127.0.0.1:6379> zadd s3 3 C
                (integer) 0
                127.0.0.1:6379> zadd s3 4 D
                (integer) 1
            取：
                127.0.0.1:6379> zrange s3 0 10
                1) "A"
                2) "B"
                3) "C"
                4) "D"
*/