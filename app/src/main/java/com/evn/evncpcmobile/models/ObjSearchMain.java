package com.evn.evncpcmobile.models;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 24-June-2019
 * Time: 08:43
 * Version: 1.0
 */
public class ObjSearchMain {
    private String sName;
    private String sId;
    private int sImage;

    public ObjSearchMain(String sName, String sId, int sImage) {
        this.sName = sName;
        this.sId = sId;
        this.sImage = sImage;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public int getsImage() {
        return sImage;
    }

    public void setsImage(int sImage) {
        this.sImage = sImage;
    }
}
