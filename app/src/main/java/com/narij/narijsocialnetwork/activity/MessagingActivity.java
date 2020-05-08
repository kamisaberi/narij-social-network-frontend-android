package com.narij.narijsocialnetwork.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.adapter.recycler.MessagingListRecyclerAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.base.Message;
import com.narij.narijsocialnetwork.model.retrofit.MessagesRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessagingActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    EditText edtMessage;
    ImageView imgSend;

    public ArrayList<Message> messages = new ArrayList<>();


    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        recyclerView = (RecyclerView) findViewById(R.id.rcMessages);
        edtMessage = (EditText) findViewById(R.id.edtMessage);
        edtMessage.setTypeface(Globals.typeface, Typeface.NORMAL);
        imgSend = (ImageView) findViewById(R.id.imgSend);


        apiInterface = APIClient.getClient().create(APIInterface.class);


        int memberId = getIntent().getIntExtra("memberId", 0);

        if (memberId == 0) {
            return;
        }

        Call<MessagesRetrofitModel> call = apiInterface.getConversation(
                Globals.token,
                memberId,
                System.currentTimeMillis()
        );

        call.enqueue(new Callback<MessagesRetrofitModel>() {
            @Override
            public void onResponse(Call<MessagesRetrofitModel> call, Response<MessagesRetrofitModel> response) {

                messages = response.body().messages;
                WebServiceMessage message = response.body().message;
                MessagingListRecyclerAdapter adapter = new MessagingListRecyclerAdapter(messages, getBaseContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

            }

            @Override
            public void onFailure(Call<MessagesRetrofitModel> call, Throwable t) {

            }
        });

        imgSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
