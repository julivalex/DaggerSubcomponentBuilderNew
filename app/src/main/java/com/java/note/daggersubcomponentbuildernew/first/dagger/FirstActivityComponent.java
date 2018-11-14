package com.java.note.daggersubcomponentbuildernew.first.dagger;

import com.java.note.daggersubcomponentbuildernew.first.FirstActivity;
import com.java.note.daggersubcomponentbuildernew.base.ActivityComponent;
import com.java.note.daggersubcomponentbuildernew.base.ActivityComponentBuilder;

import dagger.Subcomponent;

@FirstActivityScope
@Subcomponent(modules = FirstActivityModule.class)
public interface FirstActivityComponent extends ActivityComponent<FirstActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<FirstActivityComponent, FirstActivityModule> {
    }
}
