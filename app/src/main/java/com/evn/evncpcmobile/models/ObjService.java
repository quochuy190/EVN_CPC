package com.evn.evncpcmobile.models;

import java.util.List;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 21-June-2019
 * Time: 22:50
 * Version: 1.0
 */
public class ObjService {
    String sId;
    String sName;
    int sImage;
    List<ServiceSub> mListSub;
    boolean isShowSub;

    public ObjService(String sId, String sName, int sImage, List<ServiceSub> mListSub, boolean isShowSub) {
        this.sId = sId;
        this.sName = sName;
        this.sImage = sImage;
        this.mListSub = mListSub;
        this.isShowSub = isShowSub;
    }

    public void setsImage(int sImage) {
        this.sImage = sImage;
    }

    public boolean isShowSub() {
        return isShowSub;
    }

    public void setShowSub(boolean showSub) {
        isShowSub = showSub;
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

    public int getsImage() {
        return sImage;
    }

    public List<ServiceSub> getmListSub() {
        return mListSub;
    }

    public void setmListSub(List<ServiceSub> mListSub) {
        this.mListSub = mListSub;
    }
}
