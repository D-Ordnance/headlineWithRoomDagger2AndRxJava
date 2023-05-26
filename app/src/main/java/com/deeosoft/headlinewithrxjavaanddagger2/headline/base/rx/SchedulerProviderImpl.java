package com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx;


import androidx.annotation.NonNull;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SchedulerProviderImpl implements SchedulerProvider{

    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
