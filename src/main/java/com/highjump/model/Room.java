package com.highjump.model;

public class Room extends BaseModel {
    private String referenceId;
    private String roomIndex;
    private int roomCount;
    private String currency;
    private String roomCode;

    private String roomName;
    private String roomType;
    private String roomTypeCode;
    private String roomRateId;
    private String roomRateCode;
    private String roomRateKey;

    private String sharingBedding;
    private String thirdParty;
    private double totalRate;
    private double totalOriginalRate;

    private Meal meal;
    private Policies policies;

    private String priceBreakdowns;
    private String messages;
    private String cancellationPolicyCode;
    private String allotment;
    private String group;
    private String occupancy;
    private String status;

    public String getRoomIndex() {
        return roomIndex;
    }

    public void setRoomIndex(String roomIndex) {
        this.roomIndex = roomIndex;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getRoomRateId() {
        return roomRateId;
    }

    public void setRoomRateId(String roomRateId) {
        this.roomRateId = roomRateId;
    }

    public String getRoomRateCode() {
        return roomRateCode;
    }

    public void setRoomRateCode(String roomRateCode) {
        this.roomRateCode = roomRateCode;
    }

    public String getRoomRateKey() {
        return roomRateKey;
    }

    public void setRoomRateKey(String roomRateKey) {
        this.roomRateKey = roomRateKey;
    }

    public String getSharingBedding() {
        return sharingBedding;
    }

    public void setSharingBedding(String sharingBedding) {
        this.sharingBedding = sharingBedding;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
    }

    public double getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(double totalRate) {
        this.totalRate = totalRate;
    }

    public double getTotalOriginalRate() {
        return totalOriginalRate;
    }

    public void setTotalOriginalRate(double totalOriginalRate) {
        this.totalOriginalRate = totalOriginalRate;
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

    public String getPriceBreakdowns() {
        return priceBreakdowns;
    }

    public void setPriceBreakdowns(String priceBreakdowns) {
        this.priceBreakdowns = priceBreakdowns;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getCancellationPolicyCode() {
        return cancellationPolicyCode;
    }

    public void setCancellationPolicyCode(String cancellationPolicyCode) {
        this.cancellationPolicyCode = cancellationPolicyCode;
    }

    public String getAllotment() {
        return allotment;
    }

    public void setAllotment(String allotment) {
        this.allotment = allotment;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
