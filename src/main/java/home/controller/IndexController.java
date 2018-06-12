/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IndexController
 * Author:   Administrator
 * Date:     2018/6/12 14:00
 * Description: 后台首页
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.controller;

import home.Aspectj.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈后台首页〉
 *
 * @author Administrator
 * @create 2018/6/12
 * @since 1.0.0
 */
@Controller
@Api("首页")
@RequestMapping("/index")
public class IndexController {

    @Login
    @ApiOperation("首页")
    @GetMapping("/index")
    public String index(){

        return "index/index";
    }
}