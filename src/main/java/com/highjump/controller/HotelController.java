package com.highjump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Controller for hotel management
 */

@Controller
@RequestMapping("/hotel")
public class HotelController {

//    @RequestMapping("/search")
//    public String search(@RequestParam("destination") String destination,
//                         @RequestParam("nationality") String nationality,
//                         @RequestParam("roomcount") int roomCount,
//                         @RequestParam("roomtype") int roomType,
//                         @RequestParam("adultcnt") int adultCount,
//                         @RequestParam("childcnt") int childCount,
//                         @RequestParam(value = "childage", required = false) int[] childAge,
//                         Map<String, Object> model) {
//
//        model.put("page", "index");
//        model.put("destination", destination);
//        model.put("nationality", nationality);
//
//        return "search";
//    }

    @RequestMapping("/search")
    public String search(HttpServletRequest request, Map<String, Object> model) {

        model.put("page", "index");
        // merge all parameters
        model.putAll(request.getParameterMap());

        return "search";
    }
}
