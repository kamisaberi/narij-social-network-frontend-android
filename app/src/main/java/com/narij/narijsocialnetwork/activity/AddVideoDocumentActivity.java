package com.narij.narijsocialnetwork.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import mehdi.sakout.fancybuttons.FancyButton;
import pub.devrel.easypermissions.EasyPermissions;

public class AddVideoDocumentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video_document);


        Globals.selectedFileToUpload = null;
        ImageView imgGallery = (ImageView) findViewById(R.id.imgGallery);
        imgGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
//                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK);
//                openGalleryIntent.setType("video/*");
                startActivityForResult(openGalleryIntent, 1001);

            }
        });

        FancyButton btnNext = (FancyButton) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.selectedFileToUpload != null) {

                    Intent intent = new Intent(getBaseContext(), AddDocumentDescriptionActivity.class);
//                    intent.putExtra("type", "photo");
                    startActivity(intent);

                }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK && requestCode == 1001) {
            Uri uri = data.getData();
            if (EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

                String filePath = getRealPathFromURIPath(uri, AddVideoDocumentActivity.this);
                Globals.selectedFileToUpload = new File(filePath);
                VideoView vwVideo = (VideoView) findViewById(R.id.vwVideo);
                vwVideo .setVisibility(View.VISIBLE);
                vwVideo .setVideoPath(filePath);
                vwVideo .start();

            }
        }
    }

    private String getRealPathFromURIPath(Uri contentURI, Activity activity) {
        Cursor cursor = activity.getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }


}
