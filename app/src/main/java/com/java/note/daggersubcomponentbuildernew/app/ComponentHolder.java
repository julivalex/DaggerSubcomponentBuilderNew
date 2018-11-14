package com.java.note.daggersubcomponentbuildernew.app;

import android.content.Context;

import com.java.note.daggersubcomponentbuildernew.app.dagger.AppComponent;
import com.java.note.daggersubcomponentbuildernew.app.dagger.AppModule;
import com.java.note.daggersubcomponentbuildernew.app.dagger.DaggerAppComponent;
import com.java.note.daggersubcomponentbuildernew.base.ActivityComponent;
import com.java.note.daggersubcomponentbuildernew.base.ActivityComponentBuilder;
import com.java.note.daggersubcomponentbuildernew.base.ActivityModule;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class ComponentHolder {

    private final Context context;

    private Map<Class<?>, ActivityComponent> components;
    private AppComponent appComponent;

    @Inject
    Map<Class<?>, Provider<ActivityComponentBuilder>> builders;

    public ComponentHolder(Context context) {
        this.context = context;
    }

    void init() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(context)).build();
        appComponent.injectComponentHolder(this);
        components = new HashMap<>();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public ActivityComponent getActivityComponent(Class<?> cls) {
        return getActivityComponent(cls, null);
    }

    public ActivityComponent getActivityComponent(Class<?> cls, ActivityModule module) {
        ActivityComponent component = components.get(cls);
        if(component == null) {
            ActivityComponentBuilder builder = builders.get(cls).get();
            if(module != null) {
                builder.module(module);
            }
            component = builder.build();
            components.put(cls, component);
        }
        return component;
    }

    public void releaseActivityComponent(Class<?> cls) {
        components.put(cls, null);
    }
}
