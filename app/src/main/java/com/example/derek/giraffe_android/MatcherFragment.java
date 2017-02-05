package com.example.derek.giraffe_android;


import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import static android.view.MotionEvent.ACTION_UP;

public class MatcherFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.matcher_fragment, container,
                false);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("myLog","entered onResume");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;

        ImageView scrollDownButton = (ImageView)getView().findViewById(R.id.scrollDown);
        final ScrollView s = (ScrollView)getView().findViewById(R.id.mainScroll);
        s.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        scrollDownButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        s.fullScroll(View.FOCUS_DOWN);
                }
                return true;
            }
        });

        ImageView scrollUpButton = (ImageView)getView().findViewById(R.id.scrollUp);
        scrollUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.fullScroll(View.FOCUS_UP);
            }
        });
        ImageView profilePic = (ImageView)getView().findViewById(R.id.profilePicture);
        profilePic.setHorizontalFadingEdgeEnabled(true);
        profilePic.setFadingEdgeLength(displaymetrics.widthPixels);
        //Log.d("myLog","height is "+ mainImage.getLayoutParams().height);
        //mainImage.getLayoutParams().height= 1920;

    }
}
