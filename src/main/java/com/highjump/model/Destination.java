package com.highjump.model;

public class Destination extends Country {
    private int cityId;
    private String cityName;
    private int hotelId;
    private String hotelName;
    private int hotelStarRating;
    private int hotelCount;
    private String type;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelStarRating() {
        return hotelStarRating;
    }

    public void setHotelStarRating(int hotelStarRating) {
        this.hotelStarRating = hotelStarRating;
    }

    public int getHotelCount() {
        return hotelCount;
    }

    public void setHotelCount(int hotelCount) {
        this.hotelCount = hotelCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * text representation
     * @return Hotel, City, Country
     */
    public String toString() {
        String strResult = "";

        // hotel name
        if (hotelName != null && hotelName.isEmpty()) {
            strResult += hotelName + ",";
        }

        // city name
        strResult += cityName + ',';

        // country name
        strResult += getCountryName();

        return strResult;
    }
}
