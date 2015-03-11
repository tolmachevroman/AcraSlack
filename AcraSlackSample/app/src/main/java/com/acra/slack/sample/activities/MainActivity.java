package com.acra.slack.sample.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.acra.slack.sample.R;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        (findViewById(R.id.button)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Log.d("CRASH", "" + (5 / 0));

    }
}