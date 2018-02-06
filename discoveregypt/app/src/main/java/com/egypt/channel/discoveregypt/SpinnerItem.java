package com.egypt.channel.discoveregypt;


public class SpinnerItem {

    private int imageResource;
    private int name;
    private int shortLocation;

    public SpinnerItem(int imageResource, int name, int shortLocation) {
        this.imageResource = imageResource;
        this.name = name;
        this.shortLocation = shortLocation;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getName() {
        return name;
    }

    public int getShortLocation() {
        return shortLocation;
    }
}
