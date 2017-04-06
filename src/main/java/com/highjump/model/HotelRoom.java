package com.highjump.model;

public class HotelRoom extends BaseModel {
    private String currency;

    private double totalRate;
    private double totalOriginalRate;

    private String thirdParty;

    private Meal meal;
    private Policies policies;

    private String messages;

    private Room[] rooms;
    private String group;

    private boolean matched;
    private String indexRoomType;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(double totalRate) {
        this.totalRate = totalRate;
    }

    /**
     * Calculate Discount Percentage
     * @return int
     */
    public int getDiscountPercent() {
        int nRes = 0;
        nRes = (int) Math.round((totalOriginalRate - totalRate) / totalOriginalRate * 100);

        return nRes;
    }

    public double getTotalOriginalRate() {
        return totalOriginalRate;
    }

    public void setTotalOriginalRate(double totalOriginalRate) {
        this.totalOriginalRate = totalOriginalRate;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Policies getPolicies() {
        return policies;
    }

    public void setPolicies(Policies policies) {
        this.policies = policies;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public String getIndexRoomType() {
        return indexRoomType;
    }

    public void setIndexRoomType(String indexRoomType) {
        this.indexRoomType = indexRoomType;
    }
}
