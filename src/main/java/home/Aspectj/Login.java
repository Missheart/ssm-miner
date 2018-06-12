/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Login
 * Author:   Administrator
 * Date:     2018/6/12 15:03
 * Description: 判断管理员登陆权限
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.Aspectj;

import java.lang.annotation.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自定义注解--用户登录〉
 *
 * @author Administrator
 * @create 2018/6/12
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {

}
