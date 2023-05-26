package com.deeosoft.headlinewithrxjavaanddagger2.headline.base.rx;


import io.reactivex.rxjava3.core.Scheduler;

public interface SchedulerProvider {
    Scheduler io();

    Scheduler computation();

    Scheduler ui();
}
