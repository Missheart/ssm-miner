/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: HandleExceptionController
 * Author:   Administrator
 * Date:     2018/6/13 9:33
 * Description: 异常处理控制
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.controller;

import com.sun.org.apache.regexp.internal.RE;
import home.entity.Data;
import home.exception.LoginException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈异常处理控制〉
 *
 * @author Administrator
 * @create 2018/6/13
 * @since 1.0.0
 */
@Controller
@RequestMapping("/exception")
public class HandleExceptionController extends BaseController {

    @GetMapping("/getHandle")
    public String getHandle(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        Exception exception = (Exception) request.getAttribute("exception");
        if( exception instanceof LoginException){
            //未登陆异常
            try {
                //去登陆
                response.sendRedirect(request.getContextPath()+"/manager/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "/exception/error";
    }

    @ResponseBody
    @RequestMapping("/postHandle")
    public Data postHandle(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        return data.setCode(1).setMsg((String)request.getAttribute("message"));
    }

}