package com.example.cse498.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_product_ratings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_ratings);
    }

    public void OnClickWriteReview(View v)
    {
        //create an even to link the first activity to display products on the second
        Intent click_intent = new Intent(activity_product_ratings.this, activity_write_review.class);
        startActivity(click_intent);
    }

    public void OnClickAllReviews(View v)
    {
        //create an even to link the activity product ratings to all reviews on the second
        Intent click_intent = new Intent(activity_product_ratings.this, activity_all_reviews.class);
        startActivity(click_intent);
    }
}
