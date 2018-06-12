package home.controller;

import home.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    /***
     * 接口返回数据
     */
    @Autowired
    protected Data data;
}
