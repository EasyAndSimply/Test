package com.home.logpastest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.home.logpastest.MainActivity.APP_PREFERENCES;

/**
 * Created by kamina on 14.09.2017.
 */

public class Register extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        final EditText userName = (EditText) findViewById(R.id.userName);
        final EditText passRegister = (EditText) findViewById(R.id.passRegister);
        final EditText mailRegister = (EditText) findViewById(R.id.mailRegister);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences registerDATA = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newPassword = passRegister.getText().toString();
                String newMail = mailRegister.getText().toString();

                SharedPreferences.Editor editor = registerDATA.edit();
                editor.putString(newUser + newPassword + "data", newUser + "/n" + newMail);
                editor.commit();

                Intent LoginScreen = new Intent(Register.this, MainActivity.class);
                startActivity(LoginScreen);
            }
        });
    }
}
