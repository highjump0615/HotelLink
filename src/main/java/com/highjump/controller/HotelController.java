package com.highjump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Controller for hotel management
 */

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @RequestMapping("/search")
    public String find(Map<String, Object> model) {
        model.put("page", "index");

        return "search";
    }
}
