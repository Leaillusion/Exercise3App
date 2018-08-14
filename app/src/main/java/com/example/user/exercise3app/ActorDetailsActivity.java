package com.example.user.exercise3app;

import com.example.user.exercise3app.Data.Actor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import static com.example.user.exercise3app.R.id.infoView;

public class ActorDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_FULL_NAME = "fullName";
    private static final String EXTRA_PHOTO = "photo";
    private static final String EXTRA_INFO = "info";

    public static void start(Context context, Actor actor) {
    Intent intent = new Intent(context, ActorDetailsActivity.class);
    intent.putExtra(EXTRA_FULL_NAME, actor.getName());
    intent.putExtra(EXTRA_PHOTO, actor.getAvatar());
    intent.putExtra(EXTRA_INFO, actor.getInfo());

    context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_details);

        Intent intent = getIntent();
        String fullName = intent.getStringExtra(EXTRA_FULL_NAME);
        String info = intent.getStringExtra(EXTRA_INFO);
        Uri avatar = intent.getParcelableExtra(EXTRA_PHOTO);

        ImageView photoView = findViewById(R.id.iv_photo);
        TextView infoView = findViewById(R.id.infoView);

        Glide.with(this)
                .load(avatar)
                .apply(new RequestOptions()
                .placeholder(R.drawable.avatar_default_details)
                .fallback(R.drawable.avatar_default_details)
                .centerCrop())
                .into(photoView);
        infoView.setText(info);
    }

}

