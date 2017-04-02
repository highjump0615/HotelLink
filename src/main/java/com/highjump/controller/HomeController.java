package com.highjump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Controller for main home pages
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(HttpSession session, Map<String, Object> model) {
        model.put("page", "index");

        return "index";
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Map<String, Object> model) {
        model.put("page", "index");

        return "home";
    }

    @RequestMapping("/about")
    public String about(Map<String, Object> model) {
        model.put("page", "about");

        return "aboutus";
    }

    @RequestMapping("/contact")
    public String contact(Map<String, Object> model) {
        model.put("page", "contact");

        return "contactus";
    }

    @RequestMapping("/term")
    public String term(Map<String, Object> model) {
        model.put("page", "index");

        return "term";
    }

    @RequestMapping("/privacy")
    public String privacy(Map<String, Object> model) {
        model.put("page", "index");

        return "privacy";
    }
}
