/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ManagerController
 * Author:   Administrator
 * Date:     2018/6/11 15:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.controller;

import home.entity.Data;
import home.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/6/11
 * @since 1.0.0
 */
@Api("管理员")
@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/login")
    @ApiOperation("管理员登陆界面")
    public String login() throws Exception
    {
        System.out.println("用户登陆界面");
        return "manager/login";
    }

    @ApiOperation(value = "管理员登陆接口", httpMethod = "POST")
    @ResponseBody
    @PostMapping(value = "/login")
    public Data login(
            @ApiParam(value = "管理员账号", required = true) @RequestParam("username") String username,
            @ApiParam(value = "管理员密码", required = false) @RequestParam("password") String password
    )
        throws Exception
    {
        if ( username != null && password != null ) {
            //登陆
            boolean res = managerService.login(username, password);
            if( !res )
                return data.setCode(1).setMsg("账号错误或密码错误");

            return data;
        }
        return data.setCode(1).setMsg("入参错误");

    }

    @ApiOperation("退出登陆")
    @ResponseBody
    @GetMapping("/logout")
    public Data logout()
    {
        boolean logout = managerService.logout();
        if( logout )
            return data;
        else
            return data.setCode(1).setMsg("操作错误");

    }
}