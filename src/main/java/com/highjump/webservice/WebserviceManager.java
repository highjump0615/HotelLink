package com.highjump.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.highjump.model.Destination;
import com.highjump.model.ExchangeRate;
import com.highjump.model.HotelAvailability;
import com.highjump.model.Nationality;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Component
public class WebserviceManager {

    private RestTemplate restTemplate;

    @Autowired
    private WebserviceProperties svcProperty;

    public WebserviceManager() {
        restTemplate = new RestTemplate();
    }

    /**
     * fetch supplier markup
     * @return
     */
    public Map<String, Double> getSupplierMarkup() {
        Object markup = restTemplate.getForObject(svcProperty.getRootUrl() + "/customer/supplier-markup/0", Map.class);

        return (Map<String, Double>)markup;
    }

    /**
     * fetch exchange rates
     * @return array
     */
    public ExchangeRate[] getExchangeRate() {
        ResponseEntity<ExchangeRate[]> resp = restTemplate.getForEntity(svcProperty.getRootUrl() + "/customer/exchange-rate", ExchangeRate[].class);
        return resp.getBody();
    }

    /**
     * fetch nationality suggestions
     * @param key keyword
     * @return array
     */
    public Nationality[] getNationality(String key) {
        ResponseEntity<Nationality[]> resp = restTemplate.getForEntity(svcProperty.getRootUrl() + "/suggestion/nationality?key=" + key, Nationality[].class);
        return resp.getBody();
    }

    /**
     * fetch destination suggestions
     * @param key keyword
     * @return array
     */
    public Destination[] getDestination(String key) {
        ResponseEntity<Destination[]> resp = restTemplate.getForEntity(svcProperty.getRootUrl() + "/suggestion/destination?key=" + key, Destination[].class);
        return resp.getBody();
    }

    /**
     * fetch hotel availabilities
     * @param param json
     * @param isHotel true if destination is hotel
     * @return
     */
    public HotelAvailability[] getCityAvailability(JSONObject param, boolean isHotel) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(param.toString(), headers);

        // determine url
        String strUrl = "/hotel/availability/city";
        if (isHotel) {
            strUrl = "/hotel/availability/hotel";
        }

        // call available web service
        ResponseEntity<JSONObject> response = restTemplate.exchange(svcProperty.getRootUrl() + strUrl, HttpMethod.POST, entity, JSONObject.class);
        JSONObject jsonResponse = response.getBody();
        JSONArray jsonArray = jsonResponse.getJSONArray("hotelAvailabilities");;

        //
        // transfer json to object
        //
        HotelAvailability[] hotelAvailabilities = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            hotelAvailabilities = mapper.readValue(jsonArray.toString(), HotelAvailability[].class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return hotelAvailabilities;
    }
}
