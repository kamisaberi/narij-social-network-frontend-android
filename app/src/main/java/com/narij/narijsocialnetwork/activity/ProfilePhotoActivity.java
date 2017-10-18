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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.library.CircleTransform;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import mehdi.sakout.fancybuttons.FancyButton;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePhotoActivity extends AppCompatActivity {

    APIInterface apiInterface;

    String phone;
    Button btnTakePhoto;
    Button btnFromGalley;

    ImageView imgProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_photo);

        //getActionBar().setTitle("Photo");


        //Log.d(Globals.LOG_TAG, "PHOTO 1");
        apiInterface = APIClient.getClient().create(APIInterface.class);
        //Log.d(Globals.LOG_TAG, "PHOTO 2");
        imgProfile = (ImageView) findViewById(R.id.imgProfile);

        FancyButton btnSend = (FancyButton) findViewById(R.id.btnSend);
        //Log.d(Globals.LOG_TAG, "PHOTO 3");
        btnSend.setCustomTextFont(Globals.LATO_MEDIUM_FONT);

        //Log.d(Globals.LOG_TAG, "PHOTO 4");
        phone = getIntent().getStringExtra("phone");
        final ProgressBar prgLoading = (ProgressBar) findViewById(R.id.prgLoading);


        btnFromGalley = (Button) findViewById(R.id.btnFromGallery);

        //Log.d(Globals.LOG_TAG, phone);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prgLoading.setVisibility(View.VISIBLE);

                RequestBody mFile = RequestBody.create(okhttp3.MediaType.parse("image/*"), Globals.selectedProfilePhotoToUpload);
                MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", Globals.selectedProfilePhotoToUpload.getName(), mFile);

                Call<WebServiceMessage> call = apiInterface.setProfilePhoto(phone, fileToUpload);
                call.enqueue(new Callback<WebServiceMessage>() {
                    @Override
                    public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                        try {
                            WebServiceMessage message = response.body();
                            if (!message.isError()) {
                                Log.d(Globals.LOG_TAG, message.getMessage());
                                Intent intent = new Intent(getBaseContext(), ThankYouActivity.class);
                                //intent.putExtra("phone", phone);
                                startActivity(intent);
                            } else {

                            }
                        } catch (Exception e) {
                            Log.d(Globals.LOG_TAG, e.getMessage());
                        }

                    }

                    @Override
                    public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                    }
                });

            }
        });


        btnFromGalley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK);
//                openGalleryIntent.setType("image/*");
                startActivityForResult(openGalleryIntent, 1001);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.skip, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;
        switch (item.getItemId()) {
            case R.id.mnuSkip:
                intent = new Intent(getBaseContext(), ThankYouActivity.class);
                intent.putExtra("phone", phone);
                startActivity(intent);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK && requestCode == 1001) {
            Uri uri = data.getData();
            if (EasyPermissions.hasPermissions(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                String filePath = getRealPathFromURIPath(uri, ProfilePhotoActivity.this);

                Globals.selectedProfilePhotoToUpload = new File(filePath);

                try {
                    InputStream imageStream = getContentResolver().openInputStream(uri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    imgProfile.setImageBitmap(selectedImage);
                    Picasso.with(this).load(Globals.selectedProfilePhotoToUpload ).transform(new CircleTransform()).into(imgProfile);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
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
