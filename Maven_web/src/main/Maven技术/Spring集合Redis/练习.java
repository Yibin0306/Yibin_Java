package Spring集合Redis;

public class 练习 {
}
/*
    课上练习：
        D:\BianCheng\Redis\Redis-x64-5.0.14>redis-cli.exe -h 127.0.0.1 -p 6379
        127.0.0.1:6379> set mykey abc
        OK
        127.0.0.1:6379> get mykey
        "abc"
        127.0.0.1:6379> get name
        (nil)
        127.0.0.1:6379> set name cyb
        OK
        127.0.0.1:6379> get name
        "cyb"
        127.0.0.1:6379> set name rose
        OK
        127.0.0.1:6379> get name
        "rose"
        127.0.0.1:6379> set age 18
        OK
        127.0.0.1:6379> get age
        "18"
        127.0.0.1:6379> DEL runoob
        (integer) 0
        127.0.0.1:6379> HMSET name field1 "cyb" field2 "xjl"
        (error) WRONGTYPE Operation against a key holding the wrong kind of value
        127.0.0.1:6379> DEL runoob
        (integer) 0
        127.0.0.1:6379> DEL name
        (integer) 1
        127.0.0.1:6379> HMSET name field1 "cyb" field2 "xjl"
        OK
        127.0.0.1:6379> get field1
        (nil)
        127.0.0.1:6379> hget field1
        (error) ERR wrong number of arguments for 'hget' command
        127.0.0.1:6379> hget name field1
        "cyb"
        127.0.0.1:6379> hgetall name
        1) "field1"
        2) "cyb"
        3) "field2"
        4) "xjl"
        127.0.0.1:6379> lpush s1 java
        (integer) 1
        127.0.0.1:6379> lpush s1 tomcat
        (integer) 2
        127.0.0.1:6379> lpush s1 mysql
        (integer) 3
        127.0.0.1:6379> lpush s1 maven
        (integer) 4
        127.0.0.1:6379> lrange s1 0 1
        1) "maven"
        2) "mysql"
        127.0.0.1:6379> lrange s1 0 9
        1) "maven"
        2) "mysql"
        3) "tomcat"
        4) "java"
        127.0.0.1:6379> sadd s2 aaa
        (integer) 1
        127.0.0.1:6379> sadd s2 bbb
        (integer) 1
        127.0.0.1:6379> sadd s2 ccc
        (integer) 1
        127.0.0.1:6379> sadd s2 ccc
        (integer) 0
        127.0.0.1:6379> sadd s2 ddd
        (integer) 1
        127.0.0.1:6379> smambers s2
        (error) ERR unknown command `smambers`, with args beginning with: `s2`,
        127.0.0.1:6379> smembers s2
        1) "ccc"
        2) "aaa"
        3) "ddd"
        4) "bbb"
        127.0.0.1:6379> zadd s3 A
        (error) ERR wrong number of arguments for 'zadd' command
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
        127.0.0.1:6379> ZRANGE S3 0 10
        (empty list or set)
        127.0.0.1:6379> zrange s3 0 10
        1) "A"
        2) "B"
        3) "C"
        4) "D"
        127.0.0.1:6379> zadd s3 1 F
        (integer) 1
        127.0.0.1:6379> zrange s3 0 10
        1) "A"
        2) "F"
        3) "B"
        4) "C"
        5) "D"

*/