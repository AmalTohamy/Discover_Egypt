package com.egypt.channel.discoveregypt;

/**
 * Created by shohayeb on 12/01/2018.
 */

public class Place {
    private int[] imageResource;
    private int location;
    private int history;
    private int info;


    public Place(int[] imageResource, int location, int history, int info) {
        this.imageResource = imageResource;
        this.location = location;
        this.history = history;
        this.info = info;

    }

    public int[] getImageResource() {
        return imageResource;
    }

    public int getLocation() {
        return location;
    }

    public int getHistory() {
        return history;
    }

    public int getInfo() {
        return info;
    }


}
