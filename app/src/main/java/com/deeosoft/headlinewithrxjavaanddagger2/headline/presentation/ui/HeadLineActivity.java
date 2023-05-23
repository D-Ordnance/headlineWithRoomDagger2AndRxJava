package com.deeosoft.headlinewithrxjavaanddagger2.headline.presentation.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.deeosoft.headlinewithrxjavaanddagger2.R;

public class HeadLineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headlines);
    }
}
