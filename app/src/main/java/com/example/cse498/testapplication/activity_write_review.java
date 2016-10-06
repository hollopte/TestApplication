package com.example.cse498.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class activity_write_review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.ViewAllProducts){
            //Toast.makeText(getApplicationContext(), "Settings option hit!", Toast.LENGTH_SHORT).show();
            Intent click_intent = new Intent(activity_write_review.this, display_products.class);
            startActivity(click_intent);
            //activity_write_review.this.finish();
            return true;
        } else if (id == R.id.ViewCategories){
            //Toast.makeText(getApplicationContext(), "item1 option hit!", Toast.LENGTH_SHORT).show();
            Intent click_intent = new Intent(activity_write_review.this, MainActivity.class);
            startActivity(click_intent);
            //activity_write_review.this.finish();
            return true;
        } else if (id == R.id.Preferences){
            Toast.makeText(getApplicationContext(), "Not Implemented Yet!", Toast.LENGTH_SHORT).show();
            // activity_write_review.this.finish();
            return true;
        } else if (id == R.id.Logout){
            //Toast.makeText(getApplicationContext(), "Not Implemented Yet!", Toast.LENGTH_SHORT).show();
            Intent click_intent = new Intent(activity_write_review.this, activity_login.class);
            startActivity(click_intent);
            //activity_write_review.this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void OnClickSubmit(View v)
    {
        //create an even to link the first activity to display products on the second
        Intent click_intent = new Intent(activity_write_review.this, activity_all_reviews.class);
        startActivity(click_intent);
    }
}
