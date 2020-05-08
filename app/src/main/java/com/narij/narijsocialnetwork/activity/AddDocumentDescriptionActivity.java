package com.narij.narijsocialnetwork.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;
import com.narij.narijsocialnetwork.retrofit.ProgressRequestBody;

import mehdi.sakout.fancybuttons.FancyButton;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddDocumentDescriptionActivity extends AppCompatActivity implements ProgressRequestBody.UploadCallbacks {

    APIInterface apiInterface;

    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_document_description);

        final EditText edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtTitle.setTypeface(Globals.typeface, Typeface.NORMAL);
        final EditText edtContent = (EditText) findViewById(R.id.edtContent);
        edtContent.setTypeface(Globals.typeface, Typeface.NORMAL);
        final EditText edtTags = (EditText) findViewById(R.id.edtTags);
        edtTags.setTypeface(Globals.typeface, Typeface.NORMAL);


        //TODO NEW SHOULD BE TESTED 2018.03.20
        Spinner spnCategories = (Spinner) findViewById(R.id.spnCategories);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Globals.loggedInData.postCategories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategories.setAdapter(adapter);


        spnCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });



        progressBar = (ProgressBar) findViewById(R.id.prg);
        progressBar.setProgress(0);

        if (Globals.DEBUG_MODE) {
            edtTitle.setText("T1");
            edtContent.setText("CCCCC1");
            edtTags.setText("tags1");
        }


        apiInterface = APIClient.getClient().create(APIInterface.class);

        FancyButton btnSend = (FancyButton) findViewById(R.id.btnSend);
        btnSend.setCustomIconFont(Globals.LATO_MEDIUM_FONT);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Globals.currentPostToSend.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.TEXT)) {

                    Call<WebServiceMessage> call = apiInterface.createTextPost(
                            Globals.token,
                            edtTitle.getText().toString(),
                            edtContent.getText().toString(),
                            edtTags.getText().toString()
                            , System.currentTimeMillis()
                    );

                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {
                            Log.d(Globals.LOG_TAG, response.body().getMessage());
                            Intent intent = new Intent(AddDocumentDescriptionActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {
                            Log.d(Globals.LOG_TAG, t.getMessage());
                        }
                    });


                } else if (Globals.currentPostToSend.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.IMAGE)) {

//                    RequestBody mFile = RequestBody.create(okhttp3.MediaType.parse("image/*"), Globals.selectedFileToUpload);

                    ProgressRequestBody mFile = new ProgressRequestBody(Globals.selectedFileToUpload, AddDocumentDescriptionActivity.this);


                    MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", Globals.selectedFileToUpload.getName(), mFile);

                    Call<WebServiceMessage> call = apiInterface.createPhotoPost(
                            fileToUpload,
                            Globals.token,
                            edtTitle.getText().toString(),
                            edtContent.getText().toString(),
                            edtTags.getText().toString(),
                            System.currentTimeMillis()
                    );

                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {


                            try {
                                WebServiceMessage webServiceMessage = response.body();
                                Log.d(Globals.LOG_TAG, webServiceMessage.getMessage());

                            } catch (Exception e) {
                                Log.d(Globals.LOG_TAG, e.getMessage());
                            }

                            Intent intent = new Intent(AddDocumentDescriptionActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                            Log.d(Globals.LOG_TAG, t.getMessage());
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
                            , System.currentTimeMillis()
                    );

                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                            Intent intent = new Intent(AddDocumentDescriptionActivity.this, MainActivity.class);
                            startActivity(intent);
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
                            edtTags.getText().toString(),
                            System.currentTimeMillis()
                    );

                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {

                            Intent intent = new Intent(AddDocumentDescriptionActivity.this, MainActivity.class);
                            startActivity(intent);
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

    @Override
    public void onProgressUpdate(int percentage) {

        Log.d(Globals.LOG_TAG, "P : " + percentage);
        progressBar.setProgress(percentage);
    }

    @Override
    public void onError() {

    }

    @Override
    public void onFinish() {

        Log.d(Globals.LOG_TAG, "FINISHED");
        progressBar.setProgress(100);
    }
}
