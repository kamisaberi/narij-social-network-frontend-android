package com.narij.narijsocialnetwork.fragment;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.activity.ProfileActivity;
import com.narij.narijsocialnetwork.adapter.fragmentadapter.MainFragmentPageAdapter;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.flexibleadapter.items.ProgressItem;
import com.narij.narijsocialnetwork.library.CircleTransform;
import com.narij.narijsocialnetwork.model.base.Member;
import com.narij.narijsocialnetwork.model.base.Post;
import com.narij.narijsocialnetwork.model.flexible.AudioPostItem;
import com.narij.narijsocialnetwork.model.flexible.PhotoPostItem;
import com.narij.narijsocialnetwork.model.flexible.TextPostItem;
import com.narij.narijsocialnetwork.model.flexible.TimelineHeaderItem;
import com.narij.narijsocialnetwork.model.flexible.VideoPostItem;
import com.narij.narijsocialnetwork.model.retrofit.MemberRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.PostsRetrofitModel;
import com.narij.narijsocialnetwork.model.retrofit.WebServiceMessage;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements FlexibleAdapter.EndlessScrollListener  {

    private long memberId;

    ImageView imgProfile;
    TextView txtName;
    TextView txtNumberOfPosts;
    TextView txtNumberOfFollowings;
    TextView txtNumberOfFollowers;
    Button btnFollow;

    APIInterface apiInterface;

    ViewPager pager;
    FragmentManager fragmentManager;

    protected RecyclerView rcPosts;
    private FlexibleAdapter<AbstractFlexibleItem> mAdapter;

    ArrayList<Post> posts = new ArrayList<>();


    public ProfileFragment(long memberId) {
        this.memberId = memberId;
        // Required empty public constructor
    }

    public ProfileFragment(long memberId, ViewPager pager, FragmentManager fragmentManager) {
        this.memberId = memberId;
        this.pager = pager;
        this.fragmentManager = fragmentManager;

        Globals.stackedFragments.add(this);
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rcPosts = (RecyclerView) getView().findViewById(R.id.rcPosts);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        initializeRecyclerView();

    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private void initializeRecyclerView() {

        Call<PostsRetrofitModel> call = apiInterface.getPosts(Globals.token);
        call.enqueue(new Callback<PostsRetrofitModel>() {
            @Override
            public void onResponse(Call<PostsRetrofitModel> call, Response<PostsRetrofitModel> response) {
                posts = response.body().posts;
                List<AbstractFlexibleItem> mItems = new ArrayList<>();
                for (Post post : posts) {
                    TimelineHeaderItem header = new TimelineHeaderItem("H" + post.getPostId(), post,getContext());
//                    InstagramHeaderItem header= new InstagramHeaderItem("H" + post.getPostId());
                    //Log.d(Globals.LOG_TAG, "H" + post.getPostId());

                    AbstractFlexibleItem absItem = null;
                    if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.TEXT)) {
                        absItem = new TextPostItem(post, header);
                        mItems.add(absItem);
                    } else if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.IMAGE)) {
                        absItem = new PhotoPostItem(post, header);
                        mItems.add(absItem);
                    } else if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.AUDIO)) {
                        absItem = new AudioPostItem(post, header);
                        mItems.add(absItem);
                    } else if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.VIDEO)) {
                        absItem = new VideoPostItem(post, header);
                        mItems.add(absItem);
                    }
                }

                mAdapter = new FlexibleAdapter<>(mItems, getActivity(), true);
                mAdapter.addListener(getActivity())
                        .setAnimationOnScrolling(true)
                        .setAnimationOnReverseScrolling(true);
                rcPosts = (RecyclerView) getView().findViewById(R.id.rcPosts);
                rcPosts.setLayoutManager(new SmoothScrollLinearLayoutManager(getActivity()));
                rcPosts.setAdapter(mAdapter);
                rcPosts.setHasFixedSize(true); //Size of RV will not change
                rcPosts.setItemAnimator(new DefaultItemAnimator());
                rcPosts.addItemDecoration(new FlexibleItemDecoration(getActivity()).withDefaultDivider());

                mAdapter.setDisplayHeadersAtStartUp(true) //Show Headers at startUp!
                        .setStickyHeaders(true) //Make headers sticky
                        .setEndlessScrollListener(ProfileFragment.this, new ProgressItem())
                        .setEndlessScrollThreshold(1); //Default=1

            }

            @Override
            public void onFailure(Call<PostsRetrofitModel> call, Throwable t) {

            }
        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        imgProfile = (ImageView) view.findViewById(R.id.imgProfile);

        String url = Globals.BASE_URL + "uploads/" + Globals.loggedInData.member.getMemberId() + "/Profile.jpg";
        Picasso.with(getContext()).load(url).transform(new CircleTransform()).into(imgProfile);


        txtName = (TextView) view.findViewById(R.id.txtFullName);
        txtName.setTypeface(Globals.typeface, Typeface.NORMAL);
        txtNumberOfFollowers = (TextView) view.findViewById(R.id.txtNumberOfFollowers);
        txtNumberOfFollowers.setTypeface(Globals.typeface, Typeface.NORMAL);
        txtNumberOfFollowings = (TextView) view.findViewById(R.id.txtNumberOfFollowings);
        txtNumberOfFollowings.setTypeface(Globals.typeface, Typeface.NORMAL);
        txtNumberOfPosts = (TextView) view.findViewById(R.id.txtNumberOfPosts);
        txtNumberOfPosts.setTypeface(Globals.typeface, Typeface.NORMAL);
        btnFollow = (Button) view.findViewById(R.id.btnFollow);
        btnFollow.setTypeface(Globals.typeface, Typeface.NORMAL);

        if (memberId == 0)
            btnFollow.setText("Edit Profile");
        else
            btnFollow.setText("Follow");

        apiInterface = APIClient.getClient().create(APIInterface.class);


        if (memberId > 0) {
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
                    txtNumberOfPosts.setText(member.getPosts().size() + "");


                }

                @Override
                public void onFailure(Call<MemberRetrofitModel> call, Throwable t) {

                }
            });
        } else {

            txtName.setText(Globals.loggedInData.member.getFullName());
            txtNumberOfFollowers.setText(Globals.loggedInData.member.getFollowings().size() + "");
            txtNumberOfFollowings.setText(Globals.loggedInData.member.getFollowers().size() + "");
            txtNumberOfPosts.setText(Globals.loggedInData.member.getPosts().size() + "");
        }


        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (memberId == 0) {

                    Intent intent = new Intent(getContext(), ProfileActivity.class);
                    startActivity(intent);

                } else {

                    Call<WebServiceMessage> call = apiInterface.follow(Globals.token, memberId);
                    call.enqueue(new Callback<WebServiceMessage>() {
                        @Override
                        public void onResponse(Call<WebServiceMessage> call, Response<WebServiceMessage> response) {
                            WebServiceMessage message = response.body();
                            if (message.isError())
                                return;

                            if (message.getMessage().equals("followed")) {
                                btnFollow.setText("unFollow");

                            } else if (message.getMessage().equals("unFollowed")) {
                                btnFollow.setText("Follow");
                            }
                        }

                        @Override
                        public void onFailure(Call<WebServiceMessage> call, Throwable t) {

                        }
                    });
                }
            }
        });


        txtNumberOfFollowings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, Fragment> fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("FOLLOWINGS", new FollowingFragment(memberId, pager, fragmentManager));
                pager.setAdapter(new MainFragmentPageAdapter(fragmentManager, getContext(), fragmentHashMap));
                //pager.getAdapter().notifyDataSetChanged();

            }
        });


        txtNumberOfFollowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Fragment> fragmentHashMap = new HashMap<>();
                fragmentHashMap.put("FOLLOWERS", new FollowersFragment(memberId, pager, fragmentManager));
                pager.setAdapter(new MainFragmentPageAdapter(fragmentManager, getContext(), fragmentHashMap));
            }
        });


        return view;
    }

    @Override
    public void noMoreLoad(int newItemsSize) {

    }

    @Override
    public void onLoadMore(int lastPosition, int currentPage) {


//        final List<AbstractFlexibleItem> newItems = new ArrayList<>();
//        Call<PostsRetrofitModel> call = apiInterface.getPosts(Globals.token);
//        call.enqueue(new Callback<PostsRetrofitModel>() {
//            @Override
//            public void onResponse(Call<PostsRetrofitModel> call, Response<PostsRetrofitModel> response) {
//
//                ArrayList<Post> newPosts = new ArrayList<>();
//                newPosts = response.body().posts;
//
//                for (Post post : newPosts) {
//                    TimelineHeaderItem header = new TimelineHeaderItem("H" + post.getPostId(), post);
////                    InstagramHeaderItem header= new InstagramHeaderItem("H" + post.getPostId());
//                    AbstractFlexibleItem absItem = null;
//                    if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.TEXT)) {
//                        absItem = new TextPostItem(post, header);
//                        newItems.add(absItem);
//                    } else if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.IMAGE)) {
//                        absItem = new PhotoPostItem(post, header);
//                        newItems.add(absItem);
//                    } else if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.AUDIO)) {
//                        absItem = new AudioPostItem(post, header);
//                        newItems.add(absItem);
//                    } else if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.VIDEO)) {
//                        absItem = new VideoPostItem(post, header);
//                        newItems.add(absItem);
//                    }
//                }
//
//                mAdapter.onLoadMoreComplete(newItems);
//            }
//
//            @Override
//            public void onFailure(Call<PostsRetrofitModel> call, Throwable t) {
//
//            }
//        });
//

//        int totalItemsOfType = mAdapter.getItemCountOfTypes(R.layout.recycler_instagram_item);
//        for (int i = 1; i <= 3; i++) {
//            newItems.add(DatabaseService.newInstagramItem(totalItemsOfType + i));
//        }
//
//
//        if (getActivity() != null && newItems.size() > 0) {
//            Toast.makeText(getActivity(),
//                    "Fetched " + newItems.size() + " new items",
//                    Toast.LENGTH_SHORT).show();
//        }
    }


}
