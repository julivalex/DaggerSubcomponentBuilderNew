package com.java.note.daggersubcomponentbuildernew.second.dagger;

import com.java.note.daggersubcomponentbuildernew.base.ActivityComponent;
import com.java.note.daggersubcomponentbuildernew.base.ActivityComponentBuilder;
import com.java.note.daggersubcomponentbuildernew.second.SecondActivity;

import dagger.Subcomponent;

@SecondActivityScope
@Subcomponent(modules = SecondActivityModule.class)
public interface SecondActivityComponent extends ActivityComponent<SecondActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<SecondActivityComponent, SecondActivityModule> {
    }
}
