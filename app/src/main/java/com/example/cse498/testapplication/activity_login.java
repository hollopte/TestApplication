package com.example.cse498.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void OnClickLogin(View v)
    {
        //create an even to link the first activity to display products on the second
        Intent click_intent = new Intent(activity_login.this, MainActivity.class);
        startActivity(click_intent);
    }
}
