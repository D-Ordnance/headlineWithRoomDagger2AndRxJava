package com.deeosoft.headlinewithrxjavaanddagger2.headline.di;

import com.deeosoft.headlinewithrxjavaanddagger2.HeadLineApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {AndroidInjectionModule.class, AppModule.class, HeadLineActivityModule.class})
public interface HeadLineComponent {

    void inject(HeadLineApplication HeadLineApplication);
}
