package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.deeosoft.headlinewithrxjavaanddagger2.BuildConfig;
import com.deeosoft.headlinewithrxjavaanddagger2.R;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.BaseActivity;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.adapter.HeadLineAdapter;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.viewModel.HeadLineViewModel;

public class HeadLineActivity extends BaseActivity<HeadLineViewModel> implements HeadLineAdapter.OnHeadLineCardClickListener {

    private static final String TAG = "HeadLineActivity";

    private LinearLayout loadingLayout, emptyLayout;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerView recyclerView;
    private HeadLineAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headlines);
        initViews();
        swipeToRefresh();
        initObserver();
        initRecycler();
    }

    @Override
    public HeadLineViewModel getViewModel() {
        return new ViewModelProvider(this, getViewModelFactory()).get(HeadLineViewModel.class);
    }

    private void swipeToRefresh(){
        getViewModel().getRemoteSource("US", BuildConfig.API_KEY);
    }

    private void initObserver(){
        getViewModel().getSource().observe(this, resource -> {
            if(resource != null){
                switch(resource.networkState){
                    case LOADING:
                        Log.d(TAG, "initObserver: it is loading");
                        break;
                    case SUCCESS:
                        Log.d(TAG, "initObserver: it is successful with data");
                        Log.d(TAG, "initObserver: " + resource.data);
                        swipeRefreshLayout.setRefreshing(false);
                        if(adapter != null){
                            adapter.addHeadLineList(resource.data);
                            adapter.notifyDataSetChanged();
                        }
                        break;
                    case ERROR:
                        Log.d(TAG, "initObserver: it failed with message");
                        Log.d(TAG, "initObserver: " + resource.message);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initRecycler(){
        adapter = new HeadLineAdapter(this, this );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initViews(){
        Toolbar mToolbar = findViewById(R.id.headLineToolBar);
        loadingLayout = findViewById(R.id.loadingIndicatorLayout);
        progressBar = findViewById(R.id.progressIndicator);
        emptyLayout = findViewById(R.id.emptyLayout);
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);

        recyclerView = findViewById(R.id.headLineList);

        mToolbar.setTitle("NewsFeed");

        swipeRefreshLayout.setOnRefreshListener(this::swipeToRefresh);
    }

    @Override
    public void onHeadLineCardClick(String url) {
        Log.d(TAG, "onHeadLineCardClick: URL" + url);
    }
}
