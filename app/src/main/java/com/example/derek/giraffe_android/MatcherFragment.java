package com.example.derek.giraffe_android;


import android.graphics.Color;
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
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

public class MatcherFragment extends Fragment {

    int [] mainPictures;
    int [] profilePictures;
    String [] names;
    String [] location;
    String [] rate;
    String [] percent;
    int counter;
    TextView name1;
    TextView name2;
    TextView rateText;
    TextView locationText;
    TextView ratingText;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView profilePicture;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        counter = 0;
        names = new String[5];
        location = new String[5];
        rate = new String[5];
        percent = new String[5];
        mainPictures = new int[20];
        profilePictures = new int[5];
        names[0] = "Maureen Gil";
        names[1] = "Evan Shang";
        names[2] = "Sandy Qin";
        names[3] = "Derek Jedral";
        names[4] = "Edward Kim";
        location[0] = "Toronto";
        location[1] = "Toronto";
        location[2] = "Waterloo";
        location[3] = "Toronto";
        location[4] = "Montreal";
        rate[0] = "$45";
        rate[1] = "$25";
        rate[2] = "$55";
        rate[3] = "$50";
        rate[4] = "$47";
        percent[0] = "98%";
        percent[1] = "42%";
        percent[2] = "81%";
        percent[3] = "73%";
        percent[4] = "100%";
        mainPictures[0]=R.drawable.image1;
        mainPictures[1]=R.drawable.image2;
        mainPictures[2]=R.drawable.image3;
        mainPictures[3]=R.drawable.image4;
        mainPictures[4]=R.drawable.image5;
        mainPictures[5]=R.drawable.image6;
        mainPictures[6]=R.drawable.image7;
        mainPictures[7]=R.drawable.image8;
        mainPictures[8]=R.drawable.image9;
        mainPictures[9]=R.drawable.image10;
        mainPictures[10]=R.drawable.image11;
        mainPictures[11]=R.drawable.image12;
        mainPictures[12]=R.drawable.image13;
        mainPictures[13]=R.drawable.image14;
        mainPictures[14]=R.drawable.image15;
        mainPictures[15]=R.drawable.image16;
        mainPictures[16]=R.drawable.image17;
        mainPictures[17]=R.drawable.image18;
        mainPictures[18]=R.drawable.image19;
        mainPictures[19]=R.drawable.image20;
        profilePictures[0]=R.drawable.white_girl1;
        profilePictures[1]=R.drawable.asian_male1;
        profilePictures[2]=R.drawable.asian_female2;
        profilePictures[3]=R.drawable.white_male1;
        profilePictures[4]=R.drawable.asian_male2;

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

        ImageView scrollDownButton = (ImageView)getView().findViewById(R.id.scrollDown);
        final ScrollView s = (ScrollView)getView().findViewById(R.id.mainScroll);
        final HorizontalScrollView s2 = (HorizontalScrollView)getView().findViewById(R.id.imageScroll);
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



        profilePicture = (ImageView)getView().findViewById(R.id.profilePicture);
        profilePicture.setImageResource(profilePictures[counter]);
        name1 = (TextView)getView().findViewById(R.id.name);
        name2 = (TextView)getView().findViewById(R.id.nameAgain);
        rateText = (TextView)getView().findViewById(R.id.rate);
        ratingText = (TextView)getView().findViewById(R.id.rating);
        locationText = (TextView)getView().findViewById(R.id.location);
        image1 = (ImageView)getView().findViewById(R.id.image1);
        image2 = (ImageView)getView().findViewById(R.id.image2);
        image3 = (ImageView)getView().findViewById(R.id.image3);
        image4 = (ImageView)getView().findViewById(R.id.image4);
        final ImageView checkMark = (ImageView)getView().findViewById(R.id.swipeRight);
        final ImageView exMark = (ImageView)getView().findViewById(R.id.swipeLeft);
        final ImageView questionMark = (ImageView)getView().findViewById(R.id.swipeMiddle);
        View.OnTouchListener tch = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case ACTION_UP:

                        ((ImageView)v).setColorFilter(Color.BLACK);
                        counter++;
                        if (counter == 5) counter = 0;
                        s.fullScroll(View.FOCUS_UP);
                        name1.setText(names[counter]);
                        name2.setText(names[counter]);
                        rateText.setText(rate[counter]);
                        ratingText.setText(percent[counter]);
                        locationText.setText(location[counter]);
                        profilePicture.setImageResource(profilePictures[counter]);
                        image1.setImageResource(mainPictures[counter * 4]);
                        image2.setImageResource(mainPictures[counter * 4 + 1]);
                        image3.setImageResource(mainPictures[counter * 4 + 2]);
                        image4.setImageResource(mainPictures[counter * 4 + 3]);
                        s2.fullScroll(View.FOCUS_LEFT);
                        break;

                    case ACTION_DOWN:
                        ((ImageView)v).setColorFilter(Color.WHITE);
                }

                return true;
            }
        };
        checkMark.setOnTouchListener(tch);
        exMark.setOnTouchListener(tch);
        questionMark.setOnTouchListener(tch);
        //Log.d("myLog","height is "+ mainImage.getLayoutParams().height);
        //mainImage.getLayoutParams().height= 1920;

    }
}
