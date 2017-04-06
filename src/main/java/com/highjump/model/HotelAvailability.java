package com.highjump.model;

public class HotelAvailability {
    private Hotel hotel;
    private double lowestRate;
    private Availability[] availabilities;
    private Availability[] supplierAvailabilities;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getLowestRate() {
        return lowestRate;
    }

    public void setLowestRate(double lowestRate) {
        this.lowestRate = lowestRate;
    }

    public Availability[] getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(Availability[] availabilities) {
        this.availabilities = availabilities;
    }

    public Availability[] getSupplierAvailabilities() {
        return supplierAvailabilities;
    }

    public void setSupplierAvailabilities(Availability[] supplierAvailabilities) {
        this.supplierAvailabilities = supplierAvailabilities;
    }
}
