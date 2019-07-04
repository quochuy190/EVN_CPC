package com.evn.evncpcmobile.models.request_api;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 02-July-2019
 * Time: 15:05
 * Version: 1.0
 */
public class GetAccessToken_Request implements RequestApi {
    private String userAccessId;
    private String customerCode;
    private String token;

    public GetAccessToken_Request(String userAccessId, String customerCode, String token) {
        this.userAccessId = userAccessId;
        this.customerCode = customerCode;
        this.token = token;
    }

    public String getUserAccessId() {
        return userAccessId;
    }

    public void setUserAccessId(String userAccessId) {
        this.userAccessId = userAccessId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
