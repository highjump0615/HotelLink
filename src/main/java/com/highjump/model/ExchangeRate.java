package com.highjump.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExchangeRate extends BaseModel {
    private String fromCurrency;
    private String toCurrency;

    protected double rate;
    private Object rateType;
    private Date rateTime;

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Object getRateType() {
        return rateType;
    }

    public void setRateType(Object rateType) {
        this.rateType = rateType;
    }

    public Date getRateTime() {
        return rateTime;
    }

    public void setRateTime(String rateTime) {
        // string to date
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
            this.rateTime = sdf.parse(rateTime);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
