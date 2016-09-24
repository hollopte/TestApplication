package com.example.cse498.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class activity_product_ratings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_ratings);
    }

    public void OnClick(View v)
    {
        //create an even to link the first activity to display products on the second
        Intent click_intent = new Intent(activity_product_ratings.this, activity_write_review.class);
        startActivity(click_intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_options_menu,menu);
        return true;
    }

    public boolean onOptionsItemsSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.home){

            activity_product_ratings.this.finish();
            return true;
        } else if (id == R.id.ViewAllProducts){
            //Toast.makeText(getApplicationContext(), "Settings option hit!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.ViewCategories){
            //Toast.makeText(getApplicationContext(), "item1 option hit!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.Prefrences){
            //Toast.makeText(getApplicationContext(), "item2 otion hit!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.Logout){
            //Toast.makeText(getApplicationContext(), "item3 option hit!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);


    }
}
