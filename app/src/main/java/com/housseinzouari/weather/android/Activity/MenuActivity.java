package com.housseinzouari.weather.android.Activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.housseinzouari.weather.android.Adapter.CustomAndroidGridViewAdapter;
import com.housseinzouari.weather.android.R;

public class MenuActivity extends AppCompatActivity {

    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;
    CoordinatorLayout rootLayoutAndroid;
    GridView gridView;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public static String[] gridViewStrings = {
            "Prague",
            "Brno"

    };
    public static int[] gridViewImages = {
            R.drawable.weather1,
            R.drawable.weather2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // for the shared pref to set the choice of the user
        pref = getApplicationContext().getSharedPreferences(getString(R.string.user), MODE_PRIVATE);
        editor = pref.edit();

        // toolbar of our menu
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // declaration of the gridview
        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new CustomAndroidGridViewAdapter(this, gridViewStrings, gridViewImages));
        //set the itemclick
        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {    int choice =1;
                if (i==0)
                {       choice=0;
                }
                // validate the choice and pass to the next activity
                 editor.putInt(getString(R.string.choice), choice);
                 editor.commit();
                  startDetailsActivity();
            }
        });
        // to set up the toolbar
        initInstances();
    }

    private void initInstances() {
      rootLayoutAndroid = (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayoutAndroid = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);
        collapsingToolbarLayoutAndroid.setTitle(getString(R.string.toolbar_title));
    }


    private void startDetailsActivity(){

        if (isNetworkConnected()) {
            startActivity(new Intent(MenuActivity.this, DetailsActivity.class));
        }else {
            Toast.makeText(getApplication(), getString(R.string.error),
                    Toast.LENGTH_LONG).show();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}