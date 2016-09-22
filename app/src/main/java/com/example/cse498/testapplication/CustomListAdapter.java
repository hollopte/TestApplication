package com.example.cse498.testapplication;

/**
 * Created by cse498 on 9/21/16.
 * Using www.androidinterview.com/android-custom-listview-with-image-and-text-using-arrayadapter/
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomListAdapter (Activity context, String[] itemname, Integer[] imgid){
        super(context, R.layout.mylist, itemname);

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource((imgid[position]));
        extratxt.setText("Description "+itemname[position]);
        return rowView;

    };
}