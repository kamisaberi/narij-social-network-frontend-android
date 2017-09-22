package com.narij.narijsocialnetwork.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.model.base.Member;
import com.narij.narijsocialnetwork.model.retrofit.MemberRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private long memberId;

    ImageView imgProfile;
    TextView txtName;
    TextView txtNumberOfPosts;
    TextView txtNumberOfFollowings;
    TextView txtNumberOfFollowers;
    Button btnFollow;

    APIInterface apiInterface;

    public ProfileFragment(long memberId) {
        this.memberId = memberId;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        imgProfile = (ImageView) view.findViewById(R.id.imgProfile);
        txtName = (TextView) view.findViewById(R.id.txtName);
        txtNumberOfFollowers = (TextView) view.findViewById(R.id.txtNumberOfFollowers);
        txtNumberOfFollowings = (TextView) view.findViewById(R.id.txtNumberOfFollowings);
        txtNumberOfPosts = (TextView) view.findViewById(R.id.txtNumberOfPosts);
        btnFollow = (Button) view.findViewById(R.id.btnFollow);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<MemberRetrofitModel> call = apiInterface.getMemberDetails(Globals.token, memberId);
        call.enqueue(new Callback<MemberRetrofitModel>() {
            @Override
            public void onResponse(Call<MemberRetrofitModel> call, Response<MemberRetrofitModel> response) {

                MemberRetrofitModel model = response.body();
                Member member = model.member;
                WebServiceMessage message = model.message;

                txtName.setText(member.getFullName());
                txtNumberOfFollowers.setText(member.getFollowings().size() + "");
                txtNumberOfFollowings.setText(member.getFollowers().size() + "");


            }

            @Override
            public void onFailure(Call<MemberRetrofitModel> call, Throwable t) {

            }
        });


        return view;
    }

}
