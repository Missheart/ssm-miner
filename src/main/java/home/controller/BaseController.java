package home.controller;

import home.entity.Data;
import home.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {

    /***
     * 接口返回数据
     */
    @Autowired
    protected Data data;

    @Autowired
    protected SessionUtils sessionUtils;

    protected HttpServletRequest request;
    public void setRequest(){
        request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
