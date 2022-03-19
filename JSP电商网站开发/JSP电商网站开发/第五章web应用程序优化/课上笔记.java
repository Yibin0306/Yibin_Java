package 第五章web应用程序优化;

public class 课上笔记 {
}

/*
    1.limit a，b
        a：代表起始行下标（第一行下标为0）
        b：查询结果集的数量，行数
        select * from student  limit 3，5[4-8]
        --------------------------------------------------
        分页：页码pages      规定：每页显示5条数据     起始行下标
              1                                     0
              2                                     5
              3                                     10
              4                                     15
        规律：起始行的下标=（页码-1）*5

    2.文件上传
        1.原理：io流把本地文件读--》写在服务器里
        2.<from method="post" enctype="multipart/form-data">
          <input type="file">


*/