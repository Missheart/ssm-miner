package home.exception;

/***
 * 自定义异常类
 */
public class MyException extends RuntimeException{


    public MyException() {
    }

    public MyException(String s) {
        super(s);
    }


}
