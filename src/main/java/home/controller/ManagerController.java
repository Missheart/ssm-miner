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
import home.entity.Manager;
import home.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @ApiOperation(value = "管理员登陆接口", httpMethod = "POST")
    @ResponseBody
    @PostMapping(value = "/login")
    public Data login(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            @ApiParam(value = "管理员账号", required = true) @RequestParam("username") String username,
            @ApiParam(value = "管理员密码", required = false) @RequestParam("password") String password
    ) throws Exception{
        Manager mine = managerService.getManagerByName("mine");
        System.out.println(mine);
        return data.setCode(1).setMsg("哈哈");
    }
}