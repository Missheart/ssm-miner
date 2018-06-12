/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CommonFunction
 * Author:   Administrator
 * Date:     2018/6/12 11:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.utils;

import org.springframework.util.DigestUtils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/6/12
 * @since 1.0.0
 */
public class CommonFunction {

    /***
     * 管理员登录密码生成
     * @param password
     * @param salt
     * @return
     */
    public static String getManagerPassword(String password , String salt){
        return DigestUtils.md5DigestAsHex((password + DigestUtils.md5DigestAsHex((password + salt).getBytes()) + salt).getBytes());
    }

}