package com.housseinzouari.weather.android.Entity;

/**
 * Created by zouari on 13/02/2017.
 */
public class Coord {

    private double mlogitude_weather;
    private double mlangitude_weather;

    public double getMlogitude_weather() {
        return mlogitude_weather;
    }

    public void setMlogitude_weather(double mlogitude_weather) {
        this.mlogitude_weather = mlogitude_weather;
    }

    public double getMlangitude_weather() {
        return mlangitude_weather;
    }

    public void setMlangitude_weather(double mlangitude_weather) {
        this.mlangitude_weather = mlangitude_weather;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "mlogitude_weather=" + mlogitude_weather +
                ", mlangitude_weather=" + mlangitude_weather +
                '}';
    }
}
