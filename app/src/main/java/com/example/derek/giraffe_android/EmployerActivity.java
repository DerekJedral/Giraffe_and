package com.example.derek.giraffe_android;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class EmployerActivity extends FragmentActivity {
    MatcherFragment matcherFragment;
    MatchesFragment matchesFragment;
    Fragment settingFragment;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_home);
        fm  = this.getSupportFragmentManager();
        matcherFragment = new MatcherFragment();
        matchesFragment = new MatchesFragment();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (matcherFragment == null) {
            Log.d("Crash","matcherFragment is null");
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_holder, matcherFragment).commit();
        Button b1 = (Button)findViewById(R.id.finder);
        Button b2 = (Button)findViewById(R.id.matches);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_holder, matcherFragment);
                ft.commit();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_holder, matchesFragment);
                ft.commit();
            }
        });
    }
}