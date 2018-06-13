/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: NoticeController
 * Author:   Administrator
 * Date:     2018/6/13 14:16
 * Description: 热门资讯
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.controller;

import home.Aspectj.Login;
import home.entity.Data;
import home.entity.Notice;
import home.service.impl.NoticeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈热门资讯〉
 *
 * @author Administrator
 * @create 2018/6/13
 * @since 1.0.0
 */
@Controller
@RequestMapping("/notice")
public class NoticeController extends BaseController {

    @Autowired
    private NoticeServiceimpl noticeServiceimpl;

    @GetMapping("index")
    public String index(
            HttpServletRequest request,
            HttpServletResponse response
    ){

        return "notice/index";
    }

    @Login
    @ResponseBody
    @PostMapping("add")
    public Data add(
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("notice") Notice notice
            ){
        Integer integer = noticeServiceimpl.addNotice(notice);
        System.out.println(notice);
        System.out.println(integer);
        if( integer == 0 ){
            return data.setCode(1).setMsg("录入错误");
        }

        return data;
    }

    @Login
    @GetMapping("add")
    public String add(){
        return "notice/add";
    }
}