package com.example.cse498.testapplication;

import android.app.Activity;
        import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;


public class display_products extends AppCompatActivity {

    ListView list;
    String[] itemname ={
            "Credit Card",
            "Credit Card Visa",
    };

    Integer[] imgid={
            R.mipmap.creditcards,
            R.mipmap.creditcards2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                //create an even to link the first activity to display products on the second
                Intent click_intent = new Intent(display_products.this,activity_product_ratings.class);
                startActivity(click_intent);
            }
        });
    }



}