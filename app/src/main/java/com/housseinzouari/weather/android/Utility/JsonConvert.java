package com.housseinzouari.weather.android.Utility;

import com.housseinzouari.weather.android.Entity.City;
import com.housseinzouari.weather.android.Entity.Coord;
import com.housseinzouari.weather.android.Entity.Main_temp;
import com.housseinzouari.weather.android.Entity.Weather;
import com.housseinzouari.weather.android.Entity.Wind;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public   class JsonConvert {

    public  static Coord LOADCOORDJSON(JSONObject coord_json) throws JSONException {

        Coord coord = new Coord();
        coord.setMlangitude_weather(coord_json.getDouble("lat"));
        coord.setMlogitude_weather(coord_json.getDouble("lon"));
        return coord;
    }

    public  static Wind LOADWINDJSON(JSONObject wind_json) throws JSONException {

        Wind wind = new Wind();
        wind.setMspeed_wind(wind_json.getDouble("speed"));
        wind.setMdeg_wind(wind_json.getDouble("deg"));
        return wind;
    }

    public static Weather LOADWEATHERJSON(JSONArray weather_json) throws JSONException {
        Weather weather = new Weather();
        weather.setMid_weather(weather_json.getJSONObject(0).getInt("id"));
        weather.setMdescription_weather(weather_json.getJSONObject(0).getString("description"));
        weather.setMincon_weather(weather_json.getJSONObject(0).getString("icon"));
        return weather;
    }
    public static Main_temp LOADMAIN_TEMPJSON(JSONObject maintemp_json) throws  JSONException{
        Main_temp main_temp = new Main_temp();
        main_temp.setMtemp_avg_main(maintemp_json.getDouble("temp"));
        main_temp.setMpressure_main(maintemp_json.getDouble("pressure"));
        main_temp.setMhumidity_main(maintemp_json.getDouble("humidity"));
        main_temp.setMtemp_max_main(maintemp_json.getDouble("temp_max"));
        main_temp.setMtemp_min_main(maintemp_json.getDouble("temp_min"));
        main_temp.setMsea_level_main(maintemp_json.getDouble("sea_level"));
        main_temp.setMgrnd_level_main(maintemp_json.getDouble("grnd_level"));

        return main_temp;
    }

    public static City LOADCITYJSON(String json) throws  JSONException{


        JSONObject city_json= new JSONObject(json.toString());
        City city = new City();


        JSONObject coord = (JSONObject) city_json.get("coord");
        JSONObject main = (JSONObject) city_json.get("main");
        JSONObject wind =(JSONObject)city_json.get("wind");
        JSONArray weather= (JSONArray)city_json.get("weather");


        city.setMname_city((String) city_json.get("name"));
        city.setMcoord_city(LOADCOORDJSON(coord));
        city.setMweather_city(LOADWEATHERJSON(weather));
        city.setMmain_temp(LOADMAIN_TEMPJSON(main));
        city.setMwind_city(LOADWINDJSON(wind));

        return city;
    }

}
