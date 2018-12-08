package com.example.administrator.retroitfetchdata;

public class Country {
    public String countryName;
    public String countryCode;
    public String isActive;
    public String isProvienceRequired;
    public String phoneCode;
    int countryId;

    public Country(int countryId, String countryName, String countryCode, String isActive, String isProvienceRequired, String phoneCode) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.isActive = isActive;
        this.isProvienceRequired = isProvienceRequired;
        this.phoneCode = phoneCode;
    }
}
