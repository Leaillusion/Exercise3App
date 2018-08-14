package com.example.user.exercise3app.Data;

import android.net.Uri;

public class Actor {
    private final String name;
    private final Uri avatar;
    private final Uri image;
    private final String info;

    public Actor(String name, Uri avatar, Uri image, String info) {
        this.name = name;
        this.avatar = avatar;
        this.image = image;
        this.info = info;
    }
    public String getName() { return name; }

    public Uri getAvatar() { return avatar; }

    public Uri getImage() { return image; }

    public String getInfo() { return info; }


    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", avatar=" + avatar +
                ", image=" + image +
                ", info=" + info+
                '}';
    }
}
