package com.example.administrator.retroitfetchdata.network.country;

public class Provience {
    String provienceId;
    String provienceName;
    String provienceCode;
    String countryId;
    String isActive;

    public Provience(String provienceId, String provienceName, String provienceCode, String countryId, String isActive) {
        this.provienceId = provienceId;
        this.provienceName = provienceName;
        this.provienceCode = provienceCode;
        this.countryId = countryId;
        this.isActive = isActive;
    }

    public String getProvienceId() {
        return provienceId;
    }

    public String getProvienceName() {
        return provienceName;
    }

    public String getProvienceCode() {
        return provienceCode;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getIsActive() {
        return isActive;
    }
}
