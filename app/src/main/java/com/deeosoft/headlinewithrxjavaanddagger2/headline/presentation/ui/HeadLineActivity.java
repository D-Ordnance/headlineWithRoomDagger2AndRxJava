package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.deeosoft.headlinewithrxjavaanddagger2.BuildConfig;
import com.deeosoft.headlinewithrxjavaanddagger2.R;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.base.BaseActivity;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.viewModel.HeadLineViewModel;

public class HeadLineActivity extends BaseActivity<HeadLineViewModel> {

    private static final String TAG = "HeadLineActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headlines);
        swipeToRefresh();
        initObserver();
    }

    @Override
    public HeadLineViewModel getViewModel() {
        return new ViewModelProvider(this, getViewModelFactory()).get(HeadLineViewModel.class);
    }

    void swipeToRefresh(){
        getViewModel().getRemoteSource("NG", BuildConfig.API_KEY);
    }

    void initObserver(){
        getViewModel().getSource().observe(this, resource -> {
            if(resource != null){
                switch(resource.networkState){
                    case LOADING:
                        Log.d(TAG, "initObserver: it is loading");
                        break;
                    case SUCCESS:
                        Log.d(TAG, "initObserver: it is successful with data");
                        Log.d(TAG, "initObserver: " + resource.data);
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
}
