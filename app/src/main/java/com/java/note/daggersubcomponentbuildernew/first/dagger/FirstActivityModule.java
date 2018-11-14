package com.java.note.daggersubcomponentbuildernew.first.dagger;

import com.java.note.daggersubcomponentbuildernew.base.ActivityModule;
import com.java.note.daggersubcomponentbuildernew.first.FirstActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FirstActivityModule implements ActivityModule {

    @FirstActivityScope
    @Provides
    FirstActivityPresenter provideFirstActivityPresenter() {
        return new FirstActivityPresenter();
    }
}
