package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

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

public class HeadLineActivity extends BaseActivity<HeadLineViewModel> implements HeadLineAdapter.OnHeadLineCardClickListener, View.OnClickListener {

    private static final String TAG = "HeadLineActivity";

    public static final String URL = "url";
    public static final String TITLE = "title";

    private LinearLayout loadingLayout, emptyLayout;
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
        if(!getNetworkConnection()) {
            Toast.makeText(this, "No network connection", Toast.LENGTH_LONG).show();
            swipeRefreshLayout.setVisibility(View.GONE);
            emptyLayout.setVisibility(View.VISIBLE);
            return;
        }
        hideEmptyLayout();
        getViewModel().getRemoteSource("US", BuildConfig.API_KEY);
    }

    private void initObserver(){
        getViewModel().getSource().observe(this, resource -> {
            if(resource != null){
                switch(resource.networkState){
                    case LOADING:
                        swipeRefreshLayout.setRefreshing(true);
                        showLoadingLayout();
                        break;
                    case SUCCESS:
                        swipeRefreshLayout.setRefreshing(false);
                        if(resource.data != null) {
                            if (resource.data.isEmpty()) {
                                showEmptyLayout();
                            } else {
                                hideEmptyLayout();
                                if (adapter != null) {
                                    adapter.addHeadLineList(resource.data);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }
                        break;
                    case ERROR:
                        swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(HeadLineActivity.this, resource.message, Toast.LENGTH_LONG).show();
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
        ProgressBar progressBar = findViewById(R.id.progressIndicator);
        emptyLayout = findViewById(R.id.emptyLayout);
        swipeRefreshLayout = findViewById(R.id.swipeToRefresh);

        recyclerView = findViewById(R.id.headLineList);

        mToolbar.setTitle("NewsFeed");

        swipeRefreshLayout.setOnRefreshListener(this::swipeToRefresh);

        emptyLayout.setOnClickListener(this);
    }

    @Override
    public void onHeadLineCardClick(String url, String title) {
        startActivity(new Intent(this, HeadLineWebView.class)
                .putExtra(URL, url));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.emptyLayout) {
            swipeToRefresh();
        }
    }

    private void showEmptyLayout(){
        emptyLayout.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setVisibility(View.GONE);
        loadingLayout.setVisibility(View.GONE);
    }

    private void hideEmptyLayout(){
        emptyLayout.setVisibility(View.GONE);
        swipeRefreshLayout.setVisibility(View.VISIBLE);
        loadingLayout.setVisibility(View.GONE);
    }

    private void showLoadingLayout(){
        emptyLayout.setVisibility(View.GONE);
        swipeRefreshLayout.setVisibility(View.VISIBLE);
        loadingLayout.setVisibility(View.VISIBLE);
    }
}
