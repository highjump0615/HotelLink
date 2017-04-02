package com.highjump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Controller for user management
 */
@Controller
public class UserController {

    @RequestMapping("/signup")
    public String signup(Map<String, Object> model) {
        model.put("page", "index");

        return "signup";
    }
}
