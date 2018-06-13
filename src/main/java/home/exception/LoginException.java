/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LoginException
 * Author:   Administrator
 * Date:     2018/6/13 9:49
 * Description: 登陆异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.exception;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登陆异常〉
 *
 * @author Administrator
 * @create 2018/6/13
 * @since 1.0.0
 */
public class LoginException extends RuntimeException {

    public LoginException() {
    }

    public LoginException(String s) {
        super(s);
    }
}