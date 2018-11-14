package com.java.note.daggersubcomponentbuildernew.base;

public interface ActivityComponentBuilder<C extends ActivityComponent, M extends ActivityModule> {
    C build();
    ActivityComponentBuilder<C, M> module(M module);
}
