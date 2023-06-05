package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.ui;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.deeosoft.headlinewithrxjavaanddagger2.R;

public class HeadLineWebView extends AppCompatActivity {

    private String url;
    private String title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView = findViewById(R.id.webView);
        LinearLayout progressIndicatorLayout = findViewById(R.id.progressIndicatorLayout);

        if(getIntent() != null){
            url = getIntent().getStringExtra(HeadLineActivity.URL);
            title = getIntent().getStringExtra(HeadLineActivity.TITLE);
        }

        Toolbar toolBar = findViewById(R.id.toolBar);

        toolBar.setTitle(title);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress == 100){
                    progressIndicatorLayout.setVisibility(View.GONE);
                }
            }
        });
        webView.loadUrl(url);
    }

}
