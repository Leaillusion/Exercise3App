package com.example.user.exercise3app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.user.exercise3app.Data.Actor;

import java.util.ArrayList;
import java.util.List;

public class ActorRecyclerAdapter extends
        RecyclerView.Adapter<ActorRecyclerAdapter.ViewHolder> {

    private List<Actor> actors;

    private LayoutInflater inflater;

    Context context;

    private OnItemClickListener clickListener;

    private RequestOptions imageOption;

    public ActorRecyclerAdapter( Context context, List<Actor> actors,
                                 OnItemClickListener clickListener) {

        this.actors = actors;
        this.context = context;
        this.clickListener =clickListener;
        this.inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        this.imageOption = new RequestOptions()
                .placeholder(R.drawable.avatar_default_list)
                .fallback(R.drawable.avatar_default_list)
                .centerCrop();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item_actor, parent, false),
                 clickListener);
    }


        @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actor actor = actors.get(position);

            Glide.with(context)
                    .load(actor.getAvatar())
                    .apply(imageOption)
                    .into(holder.photoView);
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

   static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView photoView;


        ViewHolder(View itemView, final OnItemClickListener clickListener) {
            super(itemView);
            itemView.setOnClickListener(((view) -> {
                int position = getAdapterPosition();
                if (clickListener != null && position != RecyclerView.NO_POSITION) {
                    clickListener.onItemClick(position, view);
                }
            }));
            photoView = itemView.findViewById(R.id.iv_photo);
        }
    }
}