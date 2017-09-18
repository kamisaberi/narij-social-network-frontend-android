package com.narij.narijsocialnetwork.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.activity.AddAudioDocumentActivity;
import com.narij.narijsocialnetwork.activity.AddPhotoDocumentActivity;
import com.narij.narijsocialnetwork.activity.AddTextDocumentActivity;
import com.narij.narijsocialnetwork.activity.AddVideoDocumentActivity;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.enumeration.MediaType;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDocumentFragment extends Fragment {


    public NewDocumentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_document, container, false);

        ImageView imgPhoto = (ImageView) view.findViewById(R.id.imgPhoto);
        ImageView imgText = (ImageView) view.findViewById(R.id.imgText);
        ImageView imgVideo = (ImageView) view.findViewById(R.id.imgVideo);
        ImageView imgAudio = (ImageView) view.findViewById(R.id.imgAudio);

        imgText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentPostToSend.setMediaType(MediaType.TEXT);
                Intent intent = new Intent(getContext(), AddTextDocumentActivity.class);
                startActivity(intent);
            }
        });

        imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentPostToSend.setMediaType(MediaType.PHOTO);
                Intent intent = new Intent(getContext(), AddPhotoDocumentActivity.class);
                startActivity(intent);

            }
        });

        imgAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentPostToSend.setMediaType(MediaType.AUDIO);
                Intent intent = new Intent(getContext(), AddAudioDocumentActivity.class);
                startActivity(intent);

            }
        });

        imgVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentPostToSend.setMediaType(MediaType.VIDEO);
                Intent intent = new Intent(getContext(), AddVideoDocumentActivity.class);
                startActivity(intent);

            }
        });


        return view;
    }

}
