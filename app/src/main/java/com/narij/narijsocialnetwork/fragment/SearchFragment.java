package com.narij.narijsocialnetwork.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.env.Globals;
import com.narij.narijsocialnetwork.flexibleadapter.items.ProgressItem;
import com.narij.narijsocialnetwork.flexibleadapter.services.DatabaseService;
import com.narij.narijsocialnetwork.model.base.Post;
import com.narij.narijsocialnetwork.model.flexible.AudioPostItem;
import com.narij.narijsocialnetwork.model.flexible.PhotoPostItem;
import com.narij.narijsocialnetwork.model.flexible.TextPostItem;
import com.narij.narijsocialnetwork.model.flexible.TimelineHeaderItem;
import com.narij.narijsocialnetwork.model.flexible.VideoPostItem;
import com.narij.narijsocialnetwork.model.retrofit.PostsRetrofitModel;
import com.narij.narijsocialnetwork.retrofit.APIClient;
import com.narij.narijsocialnetwork.retrofit.APIInterface;

import java.util.ArrayList;
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
public class SearchFragment extends Fragment implements FlexibleAdapter.EndlessScrollListener {


    protected RecyclerView rcPosts;
    protected EditText edtSearch;
    private FlexibleAdapter<AbstractFlexibleItem> mAdapter;

    APIInterface apiInterface;

    ArrayList<Post> posts = new ArrayList<>();


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rcPosts = (RecyclerView) getView().findViewById(R.id.rcPosts);
        edtSearch = (EditText) getView().findViewById(R.id.edtSearch);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Call<PostsRetrofitModel> call = apiInterface.searchPosts(Globals.token, s.toString());
                call.enqueue(new Callback<PostsRetrofitModel>() {
                    @Override
                    public void onResponse(Call<PostsRetrofitModel> call, Response<PostsRetrofitModel> response) {
                        posts = response.body().posts;
                        List<AbstractFlexibleItem> mItems = new ArrayList<>();
                        for (Post post : posts) {
                            TimelineHeaderItem header = new TimelineHeaderItem("H" + post.getPostId(), post);
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

                        mAdapter.clear();
                        mAdapter.onLoadMoreComplete(mItems);

                    }

                    @Override
                    public void onFailure(Call<PostsRetrofitModel> call, Throwable t) {

                    }
                });


            }
        });


        initializeRecyclerView();

    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private void initializeRecyclerView() {

        List<AbstractFlexibleItem> mItems = new ArrayList<>();
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
                .setEndlessScrollListener(SearchFragment.this, new ProgressItem())
                .setEndlessScrollThreshold(10); //Default=1

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timeline, container, false);
    }

    @Override
    public void noMoreLoad(int newItemsSize) {

    }

    @Override
    public void onLoadMore(int lastPosition, int currentPage) {


        final List<AbstractFlexibleItem> newItems = new ArrayList<>();


        Call<PostsRetrofitModel> call = apiInterface.getPosts(Globals.token);
        call.enqueue(new Callback<PostsRetrofitModel>() {
            @Override
            public void onResponse(Call<PostsRetrofitModel> call, Response<PostsRetrofitModel> response) {

                ArrayList<Post> newPosts = new ArrayList<>();
                newPosts = response.body().posts;

                for (Post post : newPosts) {
                    TimelineHeaderItem header = new TimelineHeaderItem("H" + post.getPostId(), post);
                    AbstractFlexibleItem absItem = null;
                    if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.TEXT)) {
                        absItem = new TextPostItem(post, header);
                        newItems.add(absItem);
                    } else if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.IMAGE)) {
                        absItem = new PhotoPostItem(post, header);
                        newItems.add(absItem);
                    } else if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.AUDIO)) {
                        absItem = new AudioPostItem(post, header);
                        newItems.add(absItem);
                    } else if (post.getMediaType().equals(com.narij.narijsocialnetwork.env.MediaType.VIDEO)) {
                        absItem = new VideoPostItem(post, header);
                        newItems.add(absItem);
                    }
                }

                mAdapter.onLoadMoreComplete(newItems);
            }

            @Override
            public void onFailure(Call<PostsRetrofitModel> call, Throwable t) {

            }
        });


        int totalItemsOfType = mAdapter.getItemCountOfTypes(R.layout.recycler_instagram_item);
        for (int i = 1; i <= 3; i++) {
            newItems.add(DatabaseService.newInstagramItem(totalItemsOfType + i));
        }


        if (getActivity() != null && newItems.size() > 0) {
            Toast.makeText(getActivity(),
                    "Fetched " + newItems.size() + " new items",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
