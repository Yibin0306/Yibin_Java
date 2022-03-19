package 第十一章多线程;

/*
1.线程的状态
2.线程类的创建方式
    1.继承 Thread
        class MyThread1 extends Thread{}
            // 创建线程
            Thread t1 =  new MyThread1；
    2.实现 Runnable 接口
        class MyThreads implements Runnable{}
            // 创建线程
            Thread t2 = new Thread（new MyThread2（））；
 */