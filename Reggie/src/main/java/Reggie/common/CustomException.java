package Reggie.common;

/**
 * 自定义业务异常类
 */
//RuntimeException运行时异常
public class CustomException extends RuntimeException {
    public CustomException(String message){
        super(message);
    }
}
