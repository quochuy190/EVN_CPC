package com.evn.evncpcmobile.models;

import java.io.Serializable;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 21-June-2019
 * Time: 17:18
 * Version: 1.0
 */
public class ObjNotifyMain  implements Serializable {
    private String sName;
    private String sNumber;
    private int sImage;

    public ObjNotifyMain(String sName, String sNumber, int sImage) {
        this.sName = sName;
        this.sNumber = sNumber;
        this.sImage = sImage;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public int getsImage() {
        return sImage;
    }

    public void setsImage(int sImage) {
        this.sImage = sImage;
    }
}
