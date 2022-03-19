package springboot整合rides;

public class 课上笔记 {
    /*
    1.启动redis
    2.添加依赖
     <!-- Spring Data Redis 依赖  -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
            <version>2.6.4</version>
        </dependency>
    3.配置yml文件
      #配置redis相关信息
      redis:
        host: 127.0.0.1
        port: 6379
        password:
    4.引入template 调用相关函数

    redis使用场景
    1.该数据块被频繁使用
    2.该数据库不经常变化

    redis的string类型的数据crud操作

    下载redis的桌面管理工具，安装并配置


    @Aspect
    作用是把当前类标识为一个切面供容器读取
    @Before
    标识一个前置增强方法，相当于BeforeAdvice的功能
    @AfterReturning
    后置增强，相当于AfterReturningAdvice，方法退出时执行
    @AfterThrowing
    异常抛出增强，相当于ThrowsAdvice
    @After
    final增强，不管是抛出异常或者正常退出都会执行
    @Around
    环绕增强，相当于MethodInterceptor
    */

}
