package com.housseinzouari.weather.android.Entity;

/**
 * Created by zouari on 13/02/2017.
 */
public class Sys {
    private int mtype_sys;
    private int mid_sys;
    private int msunrise_sys;
    private int msunset_sys;

    private String mmessage_sys;
    private String mcountry_sys;

    public int getMtype_sys() {
        return mtype_sys;
    }

    public void setMtype_sys(int mtype_sys) {
        this.mtype_sys = mtype_sys;
    }

    public int getMid_sys() {
        return mid_sys;
    }

    public void setMid_sys(int mid_sys) {
        this.mid_sys = mid_sys;
    }

    public int getMsunrise_sys() {
        return msunrise_sys;
    }

    public void setMsunrise_sys(int msunrise_sys) {
        this.msunrise_sys = msunrise_sys;
    }

    public int getMsunset_sys() {
        return msunset_sys;
    }

    public void setMsunset_sys(int msunset_sys) {
        this.msunset_sys = msunset_sys;
    }

    public String getMmessage_sys() {
        return mmessage_sys;
    }

    public void setMmessage_sys(String mmessage_sys) {
        this.mmessage_sys = mmessage_sys;
    }

    public String getMcountry_sys() {
        return mcountry_sys;
    }

    public void setMcountry_sys(String mcountry_sys) {
        this.mcountry_sys = mcountry_sys;
    }
}
