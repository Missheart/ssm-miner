package home.controller;

import home.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    @Autowired
    protected Data data;
}
