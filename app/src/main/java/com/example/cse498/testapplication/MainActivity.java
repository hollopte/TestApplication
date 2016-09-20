package com.example.cse498.testapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    //initialize button
    Button btnCredit = (Button) findViewById(R.id.creditBtn);

   //btnCredit.setOnClickListener(new View.OnContextClickListener());
}
    public void OnClick(View v) {
        Intent intent = new Intent(MainActivity.this, display_products.class);
        startActivity(intent);
    }


}
