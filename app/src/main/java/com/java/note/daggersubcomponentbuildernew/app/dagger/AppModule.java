package com.java.note.daggersubcomponentbuildernew.app.dagger;

import android.content.Context;

import com.java.note.daggersubcomponentbuildernew.base.ActivityComponentBuilder;
import com.java.note.daggersubcomponentbuildernew.first.FirstActivity;
import com.java.note.daggersubcomponentbuildernew.first.dagger.FirstActivityComponent;
import com.java.note.daggersubcomponentbuildernew.second.SecondActivity;
import com.java.note.daggersubcomponentbuildernew.second.dagger.SecondActivityComponent;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {FirstActivityComponent.class, SecondActivityComponent.class})
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @AppScope
    @Provides
    Context provideContext() {
        return context;
    }

    @IntoMap
    @ClassKey(FirstActivity.class)
    @Provides
    ActivityComponentBuilder provideFirstActivityBuilder(FirstActivityComponent.Builder builder) {
        return builder;
    }

    @IntoMap
    @ClassKey(SecondActivity.class)
    @Provides
    ActivityComponentBuilder provideSecondActivityBuilder(SecondActivityComponent.Builder builder) {
        return builder;
    }
}
