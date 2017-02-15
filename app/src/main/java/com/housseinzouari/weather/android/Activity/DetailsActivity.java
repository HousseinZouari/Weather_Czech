package com.housseinzouari.weather.android.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.housseinzouari.weather.android.Entity.City;
import com.housseinzouari.weather.android.R;
import com.housseinzouari.weather.android.Utility.JsonConvert;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {
    // declaration vars
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    ProgressDialog pd;
    City city ;
    TextView descriptioncountry_text,
             longtitudecountry_text,
             latitudecontry_text,name_country_text,sealevel_text,grndlevel_text,
             temparture_text,humidity_text,pression_text,max_temparture_text,
            min_temparture_text,wind_degree_text,wind_speed_text;

    CircleImageView weather_icon;
    String link_city_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        setupchoiceuser();
        setupview();

        if (isNetworkConnected()) {
            new JsonTask().execute(link_city_user);
        }else {
           setupview();
            Toast.makeText(getApplication(),getString(R.string.error),
                    Toast.LENGTH_LONG).show();
        }
    }


    private class JsonTask extends AsyncTask<String, String, City > {

        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(DetailsActivity.this);
            pd.setMessage(getString(R.string.wait));
            pd.setCancelable(false);
            pd.show();
        }

        protected City doInBackground(String... params) {

            try {
                URL url = new URL(params[0]);
                City city_final= loadData(url);
                return city_final;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(City result) {
            super.onPostExecute(result);
            if (pd.isShowing()){
                setupdetailscity(result);
                pd.dismiss();
            }
        }
    }


    // to get the user choice
    public void setupchoiceuser() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(getString(R.string.user), MODE_PRIVATE);
        int choice = pref.getInt(getString(R.string.choice), 0);
        if (choice == 0) {
            link_city_user = getString(R.string.prague_link);
        } else {
            link_city_user = getString(R.string.brno_link);
        }
    }


    // setup view
    public void setupview(){
        name_country_text =(TextView)findViewById(R.id.country_name);
        longtitudecountry_text=(TextView)findViewById(R.id.country_longitude);
        latitudecontry_text=(TextView)findViewById(R.id.country_latitude);
        descriptioncountry_text=(TextView)findViewById(R.id.country_description);
        temparture_text=(TextView)findViewById(R.id.weather_temparture);
        humidity_text=(TextView)findViewById(R.id.weather_humidity);
        pression_text=(TextView)findViewById(R.id.weather_pression);
        max_temparture_text=(TextView)findViewById(R.id.weather_max_temp);
        min_temparture_text=(TextView)findViewById(R.id.weather_min_temp);
        wind_degree_text=(TextView)findViewById(R.id.wind_degree);
        wind_speed_text=(TextView)findViewById(R.id.wind_speed);
        sealevel_text=(TextView)findViewById(R.id.weather_sealevel);
        grndlevel_text=(TextView)findViewById(R.id.weather_grnd_level);
        weather_icon=(CircleImageView)findViewById(R.id.picture_weather);

    }


    //get details city
    public void  setupdetailscity(City city) {

        try {

            setupdetailsgeneral(city);
            String icon = city.getMweather_city().getMincon_weather();
            String iconUrl = getString(R.string.url_img) + icon + getString(R.string.format_img) ;

            Picasso.with(getApplicationContext()).load(iconUrl).into(weather_icon);
        } catch (Exception e) {
            Toast.makeText(getApplication(),getString(R.string.error),
                    Toast.LENGTH_LONG).show();
        }
    }


        // parse details from api
    public City loadData(URL url) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {

            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
            city = JsonConvert.LOADCITYJSON(buffer.toString());
            return city;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    //Network connection
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }




    // load information in right places
    private void setupdetailsgeneral(City city){
        name_country_text.setText(city.getMname_city());
        longtitudecountry_text.setText(String.valueOf(city.getMcoord_city().getMlogitude_weather()));
        latitudecontry_text.setText(String.valueOf(city.getMcoord_city().getMlangitude_weather()));
        descriptioncountry_text.setText(city.getMweather_city().getMdescription_weather());

        pression_text.setText(String.valueOf(city.getMmain_temp().getMpressure_main()));
        humidity_text.setText(String.valueOf(city.getMmain_temp().getMhumidity_main()));
        temparture_text.setText(String.valueOf(city.getMmain_temp().getMtemp_avg_main()));
        min_temparture_text.setText(String.valueOf(city.getMmain_temp().getMtemp_min_main()));
        max_temparture_text.setText(String.valueOf(city.getMmain_temp().getMtemp_max_main()));
        sealevel_text.setText(String.valueOf(city.getMmain_temp().getMsea_level_main()));
        grndlevel_text.setText(String.valueOf(city.getMmain_temp().getMgrnd_level_main()));

        wind_speed_text.setText(String.valueOf(city.getMwind_city().getMspeed_wind()));
        wind_degree_text.setText(String.valueOf(city.getMwind_city().getMdeg_wind()));

    }

}