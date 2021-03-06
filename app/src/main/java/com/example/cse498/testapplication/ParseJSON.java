package com.example.cse498.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ParseJSON extends AppCompatActivity implements View.OnClickListener{

    private String myJSONString;

    private static final String JSON_ARRAY ="category";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String RATING = "rating";

    private JSONArray users = null;

    private int TRACK = 0;

    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextRating;

    Button btnPrev;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_json);

        Intent intent = getIntent();
        myJSONString = intent.getStringExtra(activity_preference.MY_JSON);


        editTextId = (EditText) findViewById(R.id.editTextID);
        editTextName = (EditText) findViewById(R.id.editTextUsername);
        editTextRating = (EditText) findViewById(R.id.editTextPassword);

        btnPrev = (Button) findViewById(R.id.buttonPrev);
        btnNext = (Button) findViewById(R.id.buttonNext);

        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        extractJSON();

        showData();
    }



    private void extractJSON(){
        try {
            JSONArray jsonObject = new JSONArray(myJSONString);
            users = jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void moveNext(){
        if(TRACK<users.length()){
            TRACK++;
        }
        showData();
    }

    private void movePrev(){
        if(TRACK>0){
            TRACK--;
        }
        showData();
    }

    private void showData(){
        try {
            JSONObject jsonObject = users.getJSONObject(TRACK);

            editTextId.setText(jsonObject.getString(ID));
            editTextName.setText(jsonObject.getString(NAME));
            editTextRating.setText(jsonObject.getString(RATING));
        } catch (JSONException e) {
            e.printStackTrace();
        }

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

            ParseJSON.this.finish();
            return true;
        } else if (id == R.id.ViewAllProducts){
            //Toast.makeText(getApplicationContext(), "Settings option hit!", Toast.LENGTH_SHORT).show();
            Intent click_intent = new Intent(ParseJSON.this, display_products.class);
            startActivity(click_intent);
            ParseJSON.this.finish();
            return true;
        } else if (id == R.id.ViewCategories){
            //Toast.makeText(getApplicationContext(), "item1 option hit!", Toast.LENGTH_SHORT).show();
            Intent click_intent = new Intent(ParseJSON.this, MainActivity.class);
            startActivity(click_intent);
            return true;
        } else if (id == R.id.Preferences){
            Toast.makeText(getApplicationContext(), "Not Implemented Yet!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.Logout){
            //Toast.makeText(getApplicationContext(), "Not Implemented Yet!", Toast.LENGTH_SHORT).show();
            Intent click_intent = new Intent(ParseJSON.this, activity_login.class);
            startActivity(click_intent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onClick(View v) {
        if(v == btnNext){
            moveNext();
        }
        if(v == btnPrev){
            movePrev();
        }
    }
}