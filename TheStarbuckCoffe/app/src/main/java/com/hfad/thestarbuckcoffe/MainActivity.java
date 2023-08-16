package com.hfad.thestarbuckcoffe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_id);
        toolbar.setLogo(R.drawable.starbuck_logo);
        setSupportActionBar(toolbar);
        ViewPager2 viewPager2 = findViewById(R.id.view_pager_2_id);
        viewPager2.setAdapter(new PageFragmentSelectedAdapter(this));
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom_id);
        setupWithViewPager(viewPager2, bottomNavigationView);
    }

    private void setupWithViewPager(ViewPager2 viewPager2, BottomNavigationView bottomNavigationView) {
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.home_id);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.food_id);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.drink_id);
                        break;
                }
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_id:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.food_id:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.drink_id:
                        viewPager2.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}