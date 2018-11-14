package com.java.note.daggersubcomponentbuildernew.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.java.note.daggersubcomponentbuildernew.R;
import com.java.note.daggersubcomponentbuildernew.app.App;
import com.java.note.daggersubcomponentbuildernew.second.dagger.SecondActivityComponent;
import com.java.note.daggersubcomponentbuildernew.second.dagger.SecondActivityModule;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_ARGS = "args";

    @Inject
    SecondActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle args = getIntent().getBundleExtra(EXTRA_ARGS);
        SecondActivityComponent component = (SecondActivityComponent) App
                .getApp(this)
                .getComponentHolder()
                .getActivityComponent(getClass(), new SecondActivityModule(args));
        component.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing()) {
            App.getApp(this).getComponentHolder().releaseActivityComponent(getClass());
        }
    }
}