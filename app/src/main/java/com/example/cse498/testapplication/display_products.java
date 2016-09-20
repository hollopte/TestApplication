package com.example.cse498.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static android.R.attr.id;

public class display_products extends AppCompatActivity {

    ListView productsList;
    String[] CreditCards = {"Visa Credit Card", "Visa Plus Credit Card"};
    String[] Loans = {"Visa Credit Card", "Visa Plus Credit Card"};
    String[] Accounts = {"Visa Credit Card", "Visa Plus Credit Card"};
    String[] Certificates_IRAs = {"Visa Credit Card", "Visa Plus Credit Card"};
    String[] Services = {"Visa Credit Card", "Visa Plus Credit Card"};

    Integer[] img_CC = {R.mipmap.creditcards};

    ArrayAdapter<String> prod_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products);



        productsList = (ListView) findViewById(R.id.list);


        prod_array = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, CreditCards);
        productsList.setAdapter(prod_array);

    }
}
