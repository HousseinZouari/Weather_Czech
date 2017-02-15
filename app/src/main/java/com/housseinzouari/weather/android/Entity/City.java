package com.housseinzouari.weather.android.Entity;

/**
 * Created by zouari on 13/02/2017.
 */
public class City {

    private int mid_city;
   
    private double mcode_city;
    private double mdt_city;
    private double mvisibility_city;

    private String mname_city;
    private String mbase_city;

    private Weather mweather_city;
    private Sys msys_city;
    private Coord mcoord_city;
    private Wind mwind_city;
    private Main_temp mmain_temp;

    public int getMid_city() {
        return mid_city;
    }

    public void setMid_city(int mid_city) {
        this.mid_city = mid_city;
    }

    public double getMcode_city() {
        return mcode_city;
    }

    public void setMcode_city(double mcode_city) {
        this.mcode_city = mcode_city;
    }

    public double getMdt_city() {
        return mdt_city;
    }

    public void setMdt_city(double mdt_city) {
        this.mdt_city = mdt_city;
    }

    public double getMvisibility_city() {
        return mvisibility_city;
    }

    public void setMvisibility_city(double mvisibility_city) {
        this.mvisibility_city = mvisibility_city;
    }

    public String getMname_city() {
        return mname_city;
    }

    public void setMname_city(String mname_city) {
        this.mname_city = mname_city;
    }

    public String getMbase_city() {
        return mbase_city;
    }

    public void setMbase_city(String mbase_city) {
        this.mbase_city = mbase_city;
    }

    public Weather getMweather_city() {
        return mweather_city;
    }

    public void setMweather_city(Weather mweather_city) {
        this.mweather_city = mweather_city;
    }

    public Sys getMsys_city() {
        return msys_city;
    }

    public void setMsys_city(Sys msys_city) {
        this.msys_city = msys_city;
    }

    public Coord getMcoord_city() {
        return mcoord_city;
    }

    public void setMcoord_city(Coord mcoord_city) {
        this.mcoord_city = mcoord_city;
    }

    public Wind getMwind_city() {
        return mwind_city;
    }

    public void setMwind_city(Wind mwind_city) {
        this.mwind_city = mwind_city;
    }

    public Main_temp getMmain_temp() {
        return mmain_temp;
    }

    public void setMmain_temp(Main_temp mmain_temp) {
        this.mmain_temp = mmain_temp;
    }

    @Override
    public String toString() {
        return "City{" +
                "mid_city=" + mid_city +
                ", mcode_city=" + mcode_city +
                ", mdt_city=" + mdt_city +
                ", mvisibility_city=" + mvisibility_city +
                ", mname_city='" + mname_city + '\'' +
                ", mbase_city='" + mbase_city + '\'' +
                ", mweather_city=" + mweather_city +
                ", msys_city=" + msys_city +
                ", mcoord_city=" + mcoord_city +
                ", mwind_city=" + mwind_city +
                ", mmain_temp=" + mmain_temp +
                '}';
    }
}
