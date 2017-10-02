package com.narij.narijsocialnetwork.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import mehdi.sakout.fancybuttons.FancyButton;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDocumentDescriptionActivity extends AppCompatActivity {

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_document_description);

        final EditText edtTitle = (EditText) findViewById(R.id.edtTitle);
        final EditText edtContent = (EditText) findViewById(R.id.edtContent);
        final EditText edtTags = (EditText) findViewById(R.id.edtTags);

        if (Globals.DEBUG_MODE) {
            edtTitle.setText("T1");
            edtContent.setText("CCCCC1");
            edtTags.setText("tags1");
        }


        apiInterface = APIClient.getClient().create(APIInterface.class);

        FancyButton btnSend = (FancyButton) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.currentPostToSend.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.TEXT)) {

                    Call<WebServiceMessage> call = apiInterface.createTextPost(
                            Globals.token,
                            edtTitle.getText().toString(),
                            edtContent.getText().toString(),
                            edtTags.getText().toString()
                    );

                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {
                            Log.d(Globals.LOG_TAG, response.body().getMessage());
                            finish();
                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {
                            Log.d(Globals.LOG_TAG, t.getMessage());
                        }
                    });


                } else if (Globals.currentPostToSend.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.IMAGE)) {

                    RequestBody mFile = RequestBody.create(okhttp3.MediaType.parse("image/*"), Globals.selectedFileToUpload);
                    MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", Globals.selectedFileToUpload.getName(), mFile);

                    Call<WebServiceMessage> call = apiInterface.createPhotoPost(
                            fileToUpload,
                            Globals.token,
                            edtTitle.getText().toString(),
                            edtContent.getText().toString(),
                            edtTags.getText().toString()
                    );

                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                            finish();
                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                        }
                    });

                } else if (Globals.currentPostToSend.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.VIDEO)) {

                    RequestBody mFile = RequestBody.create(okhttp3.MediaType.parse("image/*"), Globals.selectedFileToUpload);
                    MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", Globals.selectedFileToUpload.getName(), mFile);

                    Call<WebServiceMessage> call = apiInterface.createVideoPost(
                            fileToUpload,
                            Globals.token,
                            edtTitle.getText().toString(),
                            edtContent.getText().toString(),
                            edtTags.getText().toString()
                    );

                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                            finish();
                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                        }
                    });


                } else if (Globals.currentPostToSend.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.AUDIO)) {

                    RequestBody mFile = RequestBody.create(okhttp3.MediaType.parse("image/*"), Globals.selectedFileToUpload);
                    MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", Globals.selectedFileToUpload.getName(), mFile);

                    Call<WebServiceMessage> call = apiInterface.createAudioPost(
                            fileToUpload,
                            Globals.token,
                            edtTitle.getText().toString(),
                            edtContent.getText().toString(),
                            edtTags.getText().toString()
                    );

                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                            finish();
                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                        }
                    });

                }


            }
        });


    }
}
