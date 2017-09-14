package com.home.logpastest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.home.logpastest.MainActivity.APP_PREFERENCES;

/**
 * Created by kamina on 14.09.2017.
 */

public class workScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);


        SharedPreferences preferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        String displey = preferences.getString("display","");

        TextView workTV = (TextView) findViewById(R.id.workTV);
        workTV.setText(displey);
    }
}
