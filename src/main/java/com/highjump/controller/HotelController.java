package com.highjump.controller;

import com.highjump.model.Destination;
import com.highjump.model.ExchangeRate;
import com.highjump.model.HotelAvailability;
import com.highjump.model.Nationality;
import com.highjump.webservice.WebserviceManager;
import com.highjump.webservice.WebserviceProperties;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Controller for hotel management
 */

@Controller
@RequestMapping("/hotel")
public class HotelController extends BaseController {

    // key for supplier markup
    private final String kMarkup = "markup";
    private final String kExchange = "exchange";

    @Autowired
    private WebserviceManager apiManager;

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String hotel(@PathVariable("id") int id, Map<String, Object> model) {
        model.put("page", "index");

        return "hotel";
    }

    /**
     * Shows search hotel page
     * @param destinationId
     * @param nationalityId
     * @param checkIn
     * @param checkOut
     * @param roomCount
     * @param adultCount
     * @param childCount
     * @param childAge
     * @param model
     * @return vm template
     */
    @RequestMapping("/search")
    public String search(@RequestParam("destination") int destinationId,
                         @RequestParam("nationality") int nationalityId,
                         @RequestParam("checkin") String checkIn,
                         @RequestParam("checkout") String checkOut,
                         @RequestParam("roomcount") int roomCount,
                         @RequestParam("adultcnt") int adultCount,
                         @RequestParam("childcnt") int childCount,
                         @RequestParam(value = "childage", required = false) int[] childAge,
                         HttpServletRequest request,
                         Map<String, Object> model) {

        Destination destination = null;
        Nationality nationality = null;

        //
        // get destination
        //
        Destination[] destinations = (Destination[])context.getAttribute(kDestination);
        if (destinations != null) {
            for (Destination dst : destinations) {
                if (destinationId == dst.getId()) {
                    destination = dst;
                    break;
                }
            }
        }

        //
        // get nationality
        //
        Nationality[] nationalities = (Nationality[])context.getAttribute(kNationality);
        if (nationalities != null) {
            for (Nationality nat : nationalities) {
                if (nationalityId == nat.getId()) {
                    nationality = nat;
                    break;
                }
            }
        }

        //
        // get supplier markup
        //
        Map<String, Double> mapMarkup = (Map<String, Double>) context.getAttribute(kMarkup);
        if (mapMarkup == null) {
            // call rest api for fetching supplier markup
            mapMarkup = apiManager.getSupplierMarkup();
            context.setAttribute(kMarkup, mapMarkup);
        }

        //
        // get exchange rate
        //
        ExchangeRate[] exchangeRates = (ExchangeRate[])context.getAttribute(kExchange);
        if (exchangeRates == null) {
            // call rest api for fetching exchange rate
            exchangeRates = apiManager.getExchangeRate();
            context.setAttribute(kExchange, exchangeRates);
        }

        //
        // Json for availability web service
        //

        // request
        JSONObject jsonParam = new JSONObject();
        JSONObject jsonRequest = new JSONObject();

        // todo - test, delete it
//        jsonRequest.put("countryId", "TH");
//        jsonRequest.put("cityId", 47521);

        if (destination != null) {
            jsonRequest.put("countryId", destination.getCountryId());
            jsonRequest.put("cityId", destination.getCityId());

            // if hotel, add hotel parameter
            if (destination.getType().equals("hotel")) {
                jsonRequest.put("hotelId", destination.getHotelId());
            }
        }

        // date convert
        try {
            SimpleDateFormat sdfFrom = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat sdfTo = new SimpleDateFormat("yyyy-MM-dd");

            Date date = sdfFrom.parse(checkIn);
            jsonRequest.put("checkIn", sdfTo.format(date));

            date = sdfFrom.parse(checkOut);
            jsonRequest.put("checkOut", sdfTo.format(date));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        JSONArray jsonRooms = new JSONArray();
        for (int i = 0; i < roomCount; i++) {
            JSONObject jsonRoom = new JSONObject();
            jsonRoom.put("roomIndex", i + 1);
            jsonRoom.put("rooms", 1);
            jsonRoom.put("roomType", "");
            jsonRoom.put("roomRateCode", "");
            jsonRoom.put("adults", adultCount);
            jsonRoom.put("children", childCount);

            JSONArray jsonAges = new JSONArray();
            for (int nAge : childAge) {
                jsonAges.add(nAge);
            }
            jsonRoom.put("ages", jsonAges);
            jsonRoom.put("infants", 0);

            jsonRooms.add(jsonRoom);
        }
        jsonRequest.put("rooms", jsonRooms);

        // todo - test, delete it
//        jsonRequest.put("nationality", "CN");

        if (nationality != null) {
            jsonRequest.put("nationality", nationality.getCountryId());
        }
        jsonRequest.put("currency", "USD");

        // query id
        int nRnd = (int)(Math.random() * 10000);
        String strQueryId = String.valueOf(System.currentTimeMillis()) + String.valueOf(nRnd);
        jsonRequest.put("queryId", strQueryId);

        jsonRequest.put("supplierId", "expedia,gta,veturis");
        jsonParam.put("request", jsonRequest);

        // exchangeRates
        JSONArray jsonExchanges = new JSONArray();
        for (ExchangeRate er : exchangeRates) {
            JSONObject jsonExchange = new JSONObject();
            jsonExchange.put("id", er.getId());
            jsonExchange.put("date", null);
            jsonExchange.put("currency0", er.getFromCurrency());
            jsonExchange.put("currency1", er.getToCurrency());
            jsonExchange.put("rate", er.getRate());
            jsonExchange.put("rateTime", null);

            jsonExchanges.add(jsonExchange);
        }
        jsonParam.put("exchangeRates", jsonExchanges);

        // markup
        JSONObject jsonMarkup = JSONObject.fromObject(mapMarkup);
        jsonParam.put("markups", jsonMarkup);

        // starRating
        JSONObject jsonStar = new JSONObject();
        jsonStar.put("low", 0);
        jsonStar.put("high", 100);
        jsonParam.put("starRating", jsonStar);

        // score
        jsonParam.put("score", 0);

        // sort
        JSONObject jsonSort = new JSONObject();
        jsonSort.put("field", "rate");
        jsonSort.put("mode", "ascend");
        jsonParam.put("sort", jsonSort);

        // limit
        JSONObject jsonLimit = new JSONObject();
        jsonLimit.put("start", 0);
        jsonLimit.put("length", 20);
        jsonParam.put("limit", jsonLimit);

        // call availabilty web service
        HotelAvailability[] hotelAvailabilities = apiManager.getCityAvailability(jsonParam);


        //
        // parameters for page
        //
        model.put("page", "index");
        // merge all parameters
        model.putAll(request.getParameterMap());

        // update nationality
        model.remove("nationality");
        if (nationality != null) {
            model.put("nationality", nationality);
        }

        // update destination
        model.remove("destination");
        if (destination != null) {
            model.put("destination", destination);
        }

        model.put("checkin", checkIn);
        model.put("checkout", checkOut);
        model.put("roomcount", roomCount);
        model.put("adultcnt", adultCount);
        model.put("childcnt", childCount);
        model.put("childage", childAge);

        // hotel data
        model.put("hotelAvailabilities", hotelAvailabilities);

        return "search";
    }
}
