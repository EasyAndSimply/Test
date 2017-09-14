package com.home.logpastest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText nameMain;
    EditText passMain;
    Button enterBTN;
    TextView registerTV;
    public static final String APP_PREFERENCES = "MYPREFS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameMain = (EditText) findViewById(R.id.nameMain);
        passMain  = (EditText) findViewById(R.id.passMain);
        enterBTN = (Button) findViewById(R.id.enterBTN);
        registerTV = (TextView) findViewById(R.id.registerTV);


      if(sp.contains(APP_PREFERENCES)) {
            Intent register = new Intent(MainActivity.this, workScreen.class);
            startActivity(register);

            }


        enterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LogitChek();
            }
        });

        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(MainActivity.this , Register.class);
                startActivity(register);
            }
        });
    }
         void LogitChek(){
             String user = nameMain.getText().toString();
             String pass = passMain.getText().toString();
             sp = getSharedPreferences(APP_PREFERENCES , Context.MODE_PRIVATE);
             String userDetails = sp.getString(user + pass + "data", "User name or Password is Incorrect.");
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("display",userDetails);
            editor.commit();


        Intent workScreen = new Intent(MainActivity.this, workScreen.class);
        startActivity(workScreen);
    }
    }

