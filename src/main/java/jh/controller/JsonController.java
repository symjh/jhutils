package jh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsonController {

    @RequestMapping("/json")
    public String json(){
        return "utils/json";
    }

}
