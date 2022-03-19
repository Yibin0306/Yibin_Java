package 第二章Spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdive implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("开启事物");
        //执行真实的业务方法
        Object proceed = methodInvocation.proceed();
        System.out.println("提交事物");
        return proceed;
    }
}
