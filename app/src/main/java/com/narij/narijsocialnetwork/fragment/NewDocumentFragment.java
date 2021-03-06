package com.narij.narijsocialnetwork.fragment;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.activity.AddAudioDocumentActivity;
import com.narij.narijsocialnetwork.activity.AddDocumentDescriptionActivity;
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
        TextView txtPhoto = (TextView) view.findViewById(R.id.txtPhoto);
        txtPhoto.setTypeface(Globals.typeface, Typeface.NORMAL);
        ImageView imgText = (ImageView) view.findViewById(R.id.imgText);
        TextView txtText= (TextView) view.findViewById(R.id.txtText);
        txtText.setTypeface(Globals.typeface, Typeface.NORMAL);
        ImageView imgVideo = (ImageView) view.findViewById(R.id.imgVideo);
        TextView txtVideo= (TextView) view.findViewById(R.id.txtVideo);
        txtVideo.setTypeface(Globals.typeface, Typeface.NORMAL);
        ImageView imgAudio = (ImageView) view.findViewById(R.id.imgAudio);
        TextView txtAudio= (TextView) view.findViewById(R.id.txtAudio);
        txtAudio.setTypeface(Globals.typeface, Typeface.NORMAL);

        imgText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentPostToSend.setMediaType(com.narij.narijsocialnetwork.env.MediaType.TEXT);
                Intent intent = new Intent(getContext(), AddDocumentDescriptionActivity.class);
//                intent.putExtra("type", "text");
                startActivity(intent);
            }
        });

        imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentPostToSend.setMediaType(com.narij.narijsocialnetwork.env.MediaType.IMAGE);
                Intent intent = new Intent(getContext(), AddPhotoDocumentActivity.class);
//                intent.putExtra("type", "photo");
                startActivity(intent);

            }
        });

        imgAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentPostToSend.setMediaType(com.narij.narijsocialnetwork.env.MediaType.AUDIO);
                Intent intent = new Intent(getContext(), AddAudioDocumentActivity.class);
//                intent.putExtra("type", "audio");
                startActivity(intent);

            }
        });

        imgVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Globals.currentPostToSend.setMediaType(com.narij.narijsocialnetwork.env.MediaType.VIDEO);
                Intent intent = new Intent(getContext(), AddVideoDocumentActivity.class);
//                intent.putExtra("type", "video");
                startActivity(intent);

            }
        });


        return view;
    }

}
