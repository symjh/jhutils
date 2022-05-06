package jh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 导航界面
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
