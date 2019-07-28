package com.codepath.apps.restclienttemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {
    ImageView ivProfileImage;
    TextView tvScreenName;
    TextView tvBody;
    Tweet tweet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvScreenName = findViewById(R.id.tvScreenName);
        tvBody = findViewById(R.id.tvBody);
       // tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        String ScreenName = getIntent().getStringExtra("screenName");
        tvScreenName.setText(ScreenName);
        String Body =  getIntent().getStringExtra("body");
        tvBody.setText(Body);
        Glide.with(this).load(getIntent().getStringExtra("profileUrl")).apply(new RequestOptions().transform(new RoundedCorners(50)).placeholder(R.drawable.attente)).into(ivProfileImage);



    }
}
