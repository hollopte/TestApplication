package com.example.cse498.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class activity_all_reviews extends AppCompatActivity {

    ListView list;
    String[] itemname ={
            "Member 1",
            "Member 2",
            "Member 3",
            "Member 4",
            "Member 5",
            "Member 6",
            "Member 7",
            "Member 8"
    };

    Integer[] imgid={
            R.mipmap.awsomesparty,
            R.mipmap.awsomesparty,
            R.mipmap.awsomesparty,
            R.mipmap.awsomesparty,
            R.mipmap.awsomesparty,
            R.mipmap.awsomesparty,
            R.mipmap.awsomesparty,
            R.mipmap.awsomesparty
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_reviews);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

    }
}
