package com.java.note.daggersubcomponentbuildernew.second.dagger;

import android.os.Bundle;

import com.java.note.daggersubcomponentbuildernew.base.ActivityModule;
import com.java.note.daggersubcomponentbuildernew.second.SecondActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondActivityModule implements ActivityModule {

    private final Bundle args;

    public SecondActivityModule(Bundle args) {
        this.args = args;
    }

    @SecondActivityScope
    @Provides
    SecondActivityPresenter provideSecondActivityPresenter() {
        return new SecondActivityPresenter(args);
    }
}
