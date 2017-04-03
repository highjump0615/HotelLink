package com.highjump.webservice;

import com.highjump.model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
        return  resp.getBody();
    }
}
