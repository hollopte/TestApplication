package com.example.cse498.testapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class activity_preference extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewJSON;
    private Button buttonGet;
    private Button buttonParse;

    public static final String MY_JSON ="MY_JSON";
    //http://www.simplifiedcoding.16mb.com/myjson.php
    private static final String JSON_URL = "http://35.9.22.107/RatingSystem/newServerTest.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        textViewJSON = (TextView) findViewById(R.id.textViewJSON);
        textViewJSON.setMovementMethod(new ScrollingMovementMethod());
        buttonGet = (Button) findViewById(R.id.buttonGet);
        buttonParse = (Button) findViewById(R.id.buttonParse);
        buttonGet.setOnClickListener(this);
        buttonParse.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.home){

            activity_preference.this.finish();
            return true;
        } else if (id == R.id.ViewAllProducts){
            //Toast.makeText(getApplicationContext(), "Settings option hit!", Toast.LENGTH_SHORT).show();
            Intent click_intent = new Intent(activity_preference.this, display_products.class);
            startActivity(click_intent);
            activity_preference.this.finish();
            return true;
        } else if (id == R.id.ViewCategories){
            //Toast.makeText(getApplicationContext(), "item1 option hit!", Toast.LENGTH_SHORT).show();
            Intent click_intent = new Intent(activity_preference.this, MainActivity.class);
            startActivity(click_intent);
            return true;
        } else if (id == R.id.Preferences){
            Toast.makeText(getApplicationContext(), "Not Implemented Yet!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.Logout){
            //Toast.makeText(getApplicationContext(), "Not Implemented Yet!", Toast.LENGTH_SHORT).show();
            Intent click_intent = new Intent(activity_preference.this, activity_login.class);
            startActivity(click_intent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onClick(View v) {
        if(v==buttonGet){
            getJSON(JSON_URL);
        }

        if(v==buttonParse){
            showParseActivity();
        }
    }

    private void showParseActivity() {
        Intent intent = new Intent(this, ParseJSON.class);
        intent.putExtra(MY_JSON,textViewJSON.getText().toString());
        startActivity(intent);
    }


    private void getJSON(String url) {
        class GetJSON extends AsyncTask<String, Void, String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(activity_preference.this, "Please Wait...",null,true,true);
            }

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine())!= null){
                        sb.append(json+"\n");
                    }

                    return sb.toString().trim();

                }catch(Exception e){
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                textViewJSON.setText(s);
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute(url);
    }
}