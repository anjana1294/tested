package com.example.admin.demoretrofit.Model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Response implements Serializable {
    @SerializedName("id")
    public String userId;

    public String name;

    @SerializedName("username")
    public String userName;

    @SerializedName("email")
    public String email;

    @SerializedName("phone")
    public String phone;

    @SerializedName("website")
    public String website;

    @SerializedName("address")
    Address address;

    @SerializedName("company")
    Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }



}
