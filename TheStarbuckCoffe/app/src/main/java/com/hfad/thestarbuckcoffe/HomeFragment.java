package com.hfad.thestarbuckcoffe;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator3;


public class HomeFragment extends Fragment {
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem((viewPager2.getCurrentItem()+1)%4);
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager2 = view.findViewById(R.id.view_pager_2_id);
        viewPager2.setAdapter(new ImageSilderAdapter(getPhotos()));
        circleIndicator3 = view.findViewById(R.id.circle_indicator3_id);
        circleIndicator3.setViewPager(viewPager2);
//        circleIndicator3.createIndicators(5,0);
//        circleIndicator3.animatePageSelected(2);


        handler.postDelayed(runnable, 3000);
        viewPager2.setUserInputEnabled(false);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }
        });
        return view;
    }
    public Photo[] getPhotos()
    {
        Photo[] photos = new Photo[4];
        photos[0] = new Photo(R.drawable.bg1);
        photos[1] = new Photo(R.drawable.bg2);
        photos[2] = new Photo(R.drawable.bg3);
        photos[3] = new Photo(R.drawable.bg4);
        return photos;
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 3000);
    }
}