package com.java.note.daggersubcomponentbuildernew.app.dagger;

import com.java.note.daggersubcomponentbuildernew.app.ComponentHolder;
import dagger.Component;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    void injectComponentHolder(ComponentHolder componentHolder);
}
