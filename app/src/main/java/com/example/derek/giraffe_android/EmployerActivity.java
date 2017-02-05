package com.example.derek.giraffe_android;

import android.app.Activity;
import android.graphics.Color;
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
    LandingDefaultFragment landingDefaultFragment;
    MatcherFragment matcherFragment;
    MatchesFragment matchesFragment;
    ProfileEditFragment profileEditFragment;
    Fragment settingFragment;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_home);
        fm  = this.getSupportFragmentManager();
        matcherFragment = new MatcherFragment();
        matchesFragment = new MatchesFragment();
        profileEditFragment = new ProfileEditFragment();
        landingDefaultFragment = new LandingDefaultFragment();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (matcherFragment == null) {
            Log.d("Crash","matcherFragment is null");
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_holder, landingDefaultFragment).commit();
        final Button b1 = (Button)findViewById(R.id.finder);
        final Button b2 = (Button)findViewById(R.id.matches);
        final Button b3 = (Button)findViewById(R.id.profileSettings);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(Color.parseColor("#999999"));
                b2.setBackgroundColor(Color.parseColor("#444444"));
                b3.setBackgroundColor(Color.parseColor("#444444"));
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
                ft.replace(R.id.fragment_holder, matcherFragment);
                ft.commit();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setBackgroundColor(Color.parseColor("#999999"));
                b1.setBackgroundColor(Color.parseColor("#444444"));
                b3.setBackgroundColor(Color.parseColor("#444444"));
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                ft.replace(R.id.fragment_holder, matchesFragment);
                ft.commit();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3.setBackgroundColor(Color.parseColor("#999999"));
                b1.setBackgroundColor(Color.parseColor("#444444"));
                b2.setBackgroundColor(Color.parseColor("#444444"));
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                ft.replace(R.id.fragment_holder, profileEditFragment);
                ft.commit();
            }
        });
    }
}