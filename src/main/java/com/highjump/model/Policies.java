package com.highjump.model;

public class Policies {
    private String refundable;
    private String optionDate;
    private int safeDay;
    private String safeOptionDate;
    private String amendable;
    private String changeName;
    private String policies;

    public String getRefundable() {
        return refundable;
    }

    public void setRefundable(String refundable) {
        this.refundable = refundable;
    }

    public String getOptionDate() {
        return optionDate;
    }

    public void setOptionDate(String optionDate) {
        this.optionDate = optionDate;
    }

    public int getSafeDay() {
        return safeDay;
    }

    public void setSafeDay(int safeDay) {
        this.safeDay = safeDay;
    }

    public String getSafeOptionDate() {
        return safeOptionDate;
    }

    public void setSafeOptionDate(String safeOptionDate) {
        this.safeOptionDate = safeOptionDate;
    }

    public String getAmendable() {
        return amendable;
    }

    public void setAmendable(String amendable) {
        this.amendable = amendable;
    }

    public String getChangeName() {
        return changeName;
    }

    public void setChangeName(String changeName) {
        this.changeName = changeName;
    }

    public String getPolicies() {
        return policies;
    }

    public void setPolicies(String policies) {
        this.policies = policies;
    }

    /**
     * get policies description
     * @return
     */
    public String getDescription() {
        String strResult = "Non-refundable";

        if ("true".equalsIgnoreCase(refundable)) {
            strResult = "Refundable";
        }

        return strResult;
    }
}
