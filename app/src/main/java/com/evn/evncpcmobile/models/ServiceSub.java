package com.evn.evncpcmobile.models;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 21-June-2019
 * Time: 22:49
 * Version: 1.0
 */
public class ServiceSub {
    String sId;
    String sName;

    public ServiceSub(String sId, String sName) {
        this.sId = sId;
        this.sName = sName;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
