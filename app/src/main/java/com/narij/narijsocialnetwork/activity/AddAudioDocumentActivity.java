package com.narij.narijsocialnetwork.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;

import java.io.File;

import mehdi.sakout.fancybuttons.FancyButton;
import pub.devrel.easypermissions.EasyPermissions;

public class AddAudioDocumentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_audio_document);


        Globals.selectedFileToUpload = null;

        ImageView imgFolder = (ImageView) findViewById(R.id.imgFolder);
        imgFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
//                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK);
//                openGalleryIntent.setType("audio/*");
                startActivityForResult(openGalleryIntent, 1001);

            }
        });


        FancyButton btnNext = (FancyButton) findViewById(R.id.btnNext);
        btnNext.setCustomIconFont(Globals.LATO_MEDIUM_FONT);
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


//        Intent intent_upload = new Intent();
//        intent_upload.setType("audio/*");
//        intent_upload.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent_upload,1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK && requestCode == 1001) {
            Uri uri = data.getData();
            if (EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE) == false) {
                String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                EasyPermissions.requestPermissions(this, "This app needs access to your location and contacts to know where and who you are.", 124, perms);
            }

            String filePath = getRealPathFromURIPath(uri, AddAudioDocumentActivity.this);
            Globals.selectedFileToUpload = new File(filePath);

//                ImageView imgPhoto = (ImageView) findViewById(R.id.imgPhoto);
//                try {
//                    InputStream imageStream = getContentResolver().openInputStream(uri);
//                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
//                    imgPhoto.setImageBitmap(selectedImage);
//
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
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
