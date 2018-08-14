package com.example.user.exercise3app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;




import com.example.user.exercise3app.Data.Actor;
import com.example.user.exercise3app.Data.DataUtil;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.rv_avatar);
        List<Actor> actors = DataUtil.generateActors();
        list.setLayoutManager(new GridLayoutManager(this, 2));

        list.setAdapter(new ActorRecyclerAdapter(
                this, actors,
                (((position, view) -> ActorDetailsActivity.start(this, actors.get(position))))));
    }
}


