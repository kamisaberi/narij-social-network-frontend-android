package com.narij.narijsocialnetwork.flexibleadapter.services;


import com.narij.narijsocialnetwork.flexibleadapter.items.InstagramHeaderItem;
import com.narij.narijsocialnetwork.flexibleadapter.items.InstagramItem;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;

public class DatabaseService {

    private static DatabaseService mInstance;
    private List<AbstractFlexibleItem> mItems = new ArrayList<AbstractFlexibleItem>();
    private DatabaseService() {
    }

    public static DatabaseService getInstance() {
        if (mInstance == null) {
            mInstance = new DatabaseService();
        }
        return mInstance;
    }

    public void createInstagramHeadersDatabase(int startSize) {
        mItems.clear();
        for (int i = 0; i < startSize; i++) {
            mItems.add(newInstagramItem(i + 1));
        }
    }

    public static InstagramItem newInstagramItem(int i) {
        InstagramHeaderItem header = new InstagramHeaderItem("H" + i);
        String place = InstagramRandomData.getRandomPlace();
        return new InstagramItem("I" + i, header)
                .withName(InstagramRandomData.getRandomName())
                .withPlace(place)
                .withImageUrl(InstagramRandomData.getImageUrl(place));
    }
    public List<AbstractFlexibleItem> getDatabaseList() {
        return mItems;
    }
}