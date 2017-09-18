package com.narij.narijsocialnetwork.model.enumeration;

/**
 * Created by kami on 9/15/2017.
 */

public enum MediaType {
    TEXT(1), PHOTO(2), AUDIO(3), VIDEO(4);

    private int value;

    MediaType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MediaType getType(int value) {
        switch (value) {

            case 1:
                return MediaType.TEXT;
            case 2:
                return MediaType.PHOTO;
            case 3:
                return MediaType.AUDIO;
            case 4:
                return MediaType.VIDEO;
            default:
                return MediaType.TEXT;
        }
    }
}
