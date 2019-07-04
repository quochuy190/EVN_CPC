package com.evn.evncpcmobile.models.request_api;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 02-July-2019
 * Time: 15:05
 * Version: 1.0
 */
public class Init_Request implements RequestApi {
    private String APPVERSION;
    private String DEVICEMODEL;
    private String DEVICETYPE;
    private String OSVERSION;
    private String TOKENKEY;
    private String UUID;

    public Init_Request(String APPVERSION, String DEVICEMODEL, String DEVICETYPE,
                        String OSVERSION, String TOKENKEY, String UUID) {
        this.APPVERSION = APPVERSION;
        this.DEVICEMODEL = DEVICEMODEL;
        this.DEVICETYPE = DEVICETYPE;
        this.OSVERSION = OSVERSION;
        this.TOKENKEY = TOKENKEY;
        this.UUID = UUID;
    }

    public String getAPPVERSION() {
        return APPVERSION;
    }

    public void setAPPVERSION(String APPVERSION) {
        this.APPVERSION = APPVERSION;
    }

    public String getDEVICEMODEL() {
        return DEVICEMODEL;
    }

    public void setDEVICEMODEL(String DEVICEMODEL) {
        this.DEVICEMODEL = DEVICEMODEL;
    }

    public String getDEVICETYPE() {
        return DEVICETYPE;
    }

    public void setDEVICETYPE(String DEVICETYPE) {
        this.DEVICETYPE = DEVICETYPE;
    }

    public String getOSVERSION() {
        return OSVERSION;
    }

    public void setOSVERSION(String OSVERSION) {
        this.OSVERSION = OSVERSION;
    }

    public String getTOKENKEY() {
        return TOKENKEY;
    }

    public void setTOKENKEY(String TOKENKEY) {
        this.TOKENKEY = TOKENKEY;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

}
