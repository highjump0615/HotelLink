package com.highjump.controller;

import com.highjump.model.ExchangeRate;
import com.highjump.webservice.WebserviceManager;
import com.highjump.webservice.WebserviceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Controller for hotel management
 */

@Controller
@RequestMapping("/hotel")
public class HotelController extends BaseController {

    // key for supplier markup
    private static String kMarkup = "markup";
    private static String kExchange = "exchange";

    @Autowired
    private WebserviceManager apiManager;

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

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String hotel(@PathVariable("id") int id, Map<String, Object> model) {
        model.put("page", "index");

        return "hotel";
    }

    @RequestMapping("/search")
    public String search(HttpServletRequest request, Map<String, Object> model) {

        model.put("page", "index");
        // merge all parameters
        model.putAll(request.getParameterMap());

        // get supplier markup
        Map<String, Double> mapMarkup = (Map<String, Double>) context.getAttribute(kMarkup);
        if (mapMarkup == null) {
            // call rest api for fetching supplier markup
            mapMarkup = apiManager.getSupplierMarkup();
            context.setAttribute(kMarkup, mapMarkup);
        }

        // get exchange rate
        ExchangeRate[] exchangeRates = (ExchangeRate[])context.getAttribute(kExchange);
        if (exchangeRates == null) {
            // call rest api for fetching exchange rate
            exchangeRates = apiManager.getExchangeRate();
            context.setAttribute(kExchange, exchangeRates);
        }

        return "search";
    }
}
