package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder> {
    private Context context;
    private List<Tweet> tweets;

    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    // for each row inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_tweet,parent, false);
       return new ViewHolder(view);



    }
// bind values on the position of  the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Tweet tweet = tweets.get(position);
        holder.tvBody.setText(tweet.body);
        holder.tvScreenName.setText(tweet.user.screenName);
        int radius = 50;
        int margin = 10;
       //Glide.with(context).load(tweet.user.profileImageUrl).transform(new RoundedCornersTransformation(radius,margin)).into(holder.ivProfileImage);
        Glide.with(context).load(tweet.user.profileImageUrl).apply(new RequestOptions().transform(new RoundedCorners(50)).placeholder(R.drawable.attente)).into(holder.ivProfileImage);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,DetailsActivity.class);
                i.putExtra("screenName",tweet.user.screenName);
                i.putExtra("profileUrl",tweet.user.profileImageUrl);
                i.putExtra("body",tweet.body);
             //   i.putExtra("tweet", Parcels.wrap(tweet));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addTweets(List<Tweet> tweetList) {
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }



    // Define the View Holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivProfileImage;
        public TextView tvScreenName;
        public TextView tvBody;
        public RelativeLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvBody = itemView.findViewById(R.id.tvBody);
            container= itemView.findViewById(R.id.container);
        }
    }




}
