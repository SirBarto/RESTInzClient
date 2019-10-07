package com.example.restclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.restclient.activities.LoginActivity;
import com.example.restclient.activities.MainActivity;

public class SplashScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        findViewById(R.id.btnUserLogin).setOnClickListener(this);
        findViewById(R.id.btnUserRegister).setOnClickListener(this);

/*
        Thread mythread = new Thread(){

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(5000);
                }catch (Exception e){

                }finally {
                    Intent i = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        mythread.start();*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUserLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btnUserRegister:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
