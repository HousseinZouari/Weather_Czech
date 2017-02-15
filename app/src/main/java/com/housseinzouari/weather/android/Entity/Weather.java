package com.housseinzouari.weather.android.Entity;

/**
 * Created by zouari on 13/02/2017.
 */
public class Weather {

    private int mid_weather;
    private String mincon_weather;
    private String mdescription_weather;
    private String mmain_weather;

    public int getMid_weather() {
        return mid_weather;
    }

    public void setMid_weather(int mid_weather) {
        this.mid_weather = mid_weather;
    }

    public String getMincon_weather() {
        return mincon_weather;
    }

    public void setMincon_weather(String mincon_weather) {
        this.mincon_weather = mincon_weather;
    }

    public String getMdescription_weather() {
        return mdescription_weather;
    }

    public void setMdescription_weather(String mdescription_weather) {
        this.mdescription_weather = mdescription_weather;
    }

    public String getMmain_weather() {
        return mmain_weather;
    }

    public void setMmain_weather(String mmain_weather) {
        this.mmain_weather = mmain_weather;
    }
}
