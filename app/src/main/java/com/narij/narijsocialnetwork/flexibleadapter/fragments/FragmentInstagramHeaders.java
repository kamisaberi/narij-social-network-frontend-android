package com.narij.narijsocialnetwork.flexibleadapter.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.narij.narijsocialnetwork.R;
import com.narij.narijsocialnetwork.flexibleadapter.items.ProgressItem;
import com.narij.narijsocialnetwork.flexibleadapter.services.DatabaseService;

import java.util.ArrayList;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.Payload;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flipview.FlipView;


public class FragmentInstagramHeaders extends Fragment
        implements FlexibleAdapter.EndlessScrollListener {

    public static final String TAG = FragmentInstagramHeaders.class.getSimpleName();

//    protected OnFragmentInteractionListener mListener;
    //    protected int mColumnCount = 2;
    protected RecyclerView mRecyclerView;

    /**
     * Custom implementation of FlexibleAdapter
     */
    private FlexibleAdapter<AbstractFlexibleItem> mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getArguments() != null) {
//            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
//        }

        //Contribution for specific action buttons in the Toolbar
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        if (activity instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) activity;
//        } else {
//            throw new RuntimeException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }


    public static FragmentInstagramHeaders newInstance() {
        return new FragmentInstagramHeaders();
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentInstagramHeaders() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Settings for FlipView
        FlipView.resetLayoutAnimationDelay(true, 1000L);

        // Create New Database and Initialize RecyclerView
        if (savedInstanceState == null) {
            DatabaseService.getInstance().createInstagramHeadersDatabase(15);
        }
        initializeRecyclerView();

        // Settings for FlipView
        FlipView.stopLayoutAnimation();
    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private void initializeRecyclerView() {
        // Initialize Adapter and RecyclerView
        // true = it makes use of stableIds, I strongly suggest to implement 'item.hashCode()'
        mAdapter = new FlexibleAdapter<>(DatabaseService.getInstance().getDatabaseList(), getActivity(), true);
        mAdapter.addListener(getActivity())
                // Experimenting NEW features (v5.0.0)
                .setAnimationOnScrolling(true)
                .setAnimationOnReverseScrolling(true);
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true); //Size of RV will not change
        // NOTE: Use default item animator 'canReuseUpdatedViewHolder()' will return true if
        // a Payload is provided. FlexibleAdapter is actually sending Payloads onItemChange.
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // Custom divider item decorator with 24dpi as empty space between sections
        mRecyclerView.addItemDecoration(new FlexibleItemDecoration(getActivity()).withDefaultDivider());

        mAdapter.setDisplayHeadersAtStartUp(true) //Show Headers at startUp!
                .setStickyHeaders(true) //Make headers sticky
                // Endless scroll with 1 item threshold
                .setEndlessScrollListener(this, new ProgressItem())
                .setEndlessScrollThreshold(1); //Default=1

//        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeRefreshLayout);
//        swipeRefreshLayout.setEnabled(true);
        //mListener.onFragmentChange(swipeRefreshLayout, mRecyclerView, Mode.IDLE);
    }

    /**
     * No more data to load.
     * <p>This method is called if any limit is reached (<b>targetCount</b> or <b>pageSize</b>
     * must be set) AND if new data is <u>temporary</u> unavailable (ex. no connection or no
     * new updates remotely). If no new data, a {@link FlexibleAdapter#notifyItemChanged(int, Object)}
     * with a payload {@link Payload#NO_MORE_LOAD} is triggered on the <i>progressItem</i>.</p>
     *
     * @param newItemsSize the last size of the new items loaded
     * @see FlexibleAdapter#setEndlessTargetCount(int)
     * @see FlexibleAdapter#setEndlessPageSize(int)
     * @since 5.0.0-rc1
     */
    @Override
    public void noMoreLoad(int newItemsSize) {
        // This method will never be called if No limits are set and loading more will always
        // produce new items (as this example does)
    }

    /**
     * Loads more data.
     * <p>Use {@code lastPosition} and {@code currentPage} to know what to load next.</p>
     * {@code lastPosition} is the count of the main items without Scrollable Headers.
     *
     * @param lastPosition the position of the last main item in the adapter
     * @param currentPage  the current page
     * @since 5.0.0-b6
     * <br>5.0.0-rc1 added {@code lastPosition} and {@code currentPage} as parameters
     */
    @Override
    public void onLoadMore(int lastPosition, int currentPage) {
        Log.i(TAG, "onLoadMore invoked!");
        // Simulating asynchronous call
        new Handler().postDelayed(new Runnable() {
            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                final List<AbstractFlexibleItem> newItems = new ArrayList<>(3);

                // Simulating success/failure
                int totalItemsOfType = mAdapter.getItemCountOfTypes(R.layout.recycler_instagram_item);
                for (int i = 1; i <= 3; i++) {
                    newItems.add(DatabaseService.newInstagramItem(totalItemsOfType + i));
                }

                // Callback the Adapter to notify the change
                // Items will be added to the end of the main list
                mAdapter.onLoadMoreComplete(newItems);
                Log.d(TAG, "newItemsSize=" + newItems.size());
                Log.d(TAG, "EndlessCurrentPage=" + mAdapter.getEndlessCurrentPage());
                Log.d(TAG, "EndlessPageSize=" + mAdapter.getEndlessPageSize());
                Log.d(TAG, "EndlessTargetCount=" + mAdapter.getEndlessTargetCount());

                // Notify user
                if (getActivity() != null && newItems.size() > 0) {
                    Toast.makeText(getActivity(),
                            "Fetched " + newItems.size() + " new items",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }, 3000);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.action_list_type)
//            mAdapter.setAnimationOnScrolling(true);
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    protected GridLayoutManager createNewGridLayoutManager() {
//        return null;
//    }


//    protected LinearLayoutManager createNewLinearLayoutManager() {
//        return new SmoothScrollLinearLayoutManager(getActivity());
//    }

}