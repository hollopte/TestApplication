package com.example.cse498.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

    public boolean onOptionsItemsSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.home){

            activity_write_review.this.finish();
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
