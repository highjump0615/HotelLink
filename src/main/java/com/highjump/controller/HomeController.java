package com.highjump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 3/3/17.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("page", "index");

        return "index";
    }

    @RequestMapping("/about")
    public String about(Map<String, Object> model) {
        model.put("page", "about");

        return "aboutus";
    }
}
