package com.evn.evncpcmobile.models.response_api;

import com.evn.evncpcmobile.models.ObjINIT;
import com.google.gson.annotations.SerializedName;


/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 02-July-2019
 * Time: 15:06
 * Version: 1.0
 */
public class Init_Response {
    @SerializedName("RSCODE")
    String sERROR;
    @SerializedName("RSINFO")
    String RSINFO;
    @SerializedName("DATA")
    ObjINIT mObjINIT;

    public String getsERROR() {
        return sERROR;
    }

    public void setsERROR(String sERROR) {
        this.sERROR = sERROR;
    }

    public String getRSINFO() {
        return RSINFO;
    }

    public void setRSINFO(String RSINFO) {
        this.RSINFO = RSINFO;
    }

    public ObjINIT getmObjINIT() {
        return mObjINIT;
    }

    public void setmObjINIT(ObjINIT mObjINIT) {
        this.mObjINIT = mObjINIT;
    }
}
