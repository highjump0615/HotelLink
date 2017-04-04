package com.highjump.controller;

import com.highjump.model.Destination;
import com.highjump.model.Nationality;
import com.highjump.webservice.WebserviceManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {

    @Autowired
    private WebserviceManager apiManager;

    @RequestMapping("/suggestion/nationality")
    public String suggestNationality(@RequestParam("key") String key) {

        // call rest api for fetching nationality suggestions
        Nationality[] nationalities = apiManager.getNationality(key);
        context.setAttribute(kNationality, nationalities);

        JSONArray jsonArray = JSONArray.fromObject(nationalities);

        return jsonArray.toString();
    }

    @RequestMapping("/suggestion/destination")
    public String suggestDestination(@RequestParam("key") String key) {

        // call rest api for fetching dstination suggestions
        Destination[] destinations = apiManager.getDestination(key);
        context.setAttribute(kDestination, destinations);

        JSONArray jsonArray = JSONArray.fromObject(destinations);

        return jsonArray.toString();
    }
}
