package com.java.note.daggersubcomponentbuildernew.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.java.note.daggersubcomponentbuildernew.R;
import com.java.note.daggersubcomponentbuildernew.app.App;
import com.java.note.daggersubcomponentbuildernew.first.dagger.FirstActivityComponent;
import com.java.note.daggersubcomponentbuildernew.second.SecondActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    @Inject
    FirstActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ButterKnife.bind(this);
        FirstActivityComponent component = (FirstActivityComponent) App
                        .getApp(this)
                        .getComponentHolder()
                        .getActivityComponent(getClass());
        component.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isFinishing()) {
            App.getApp(this).getComponentHolder().releaseActivityComponent(getClass());
        }
    }

    @OnClick(R.id.goToSecondActivity)
    void onGoToSecondActivityClick() {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
