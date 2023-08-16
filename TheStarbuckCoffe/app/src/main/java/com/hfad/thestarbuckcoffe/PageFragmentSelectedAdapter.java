package com.hfad.thestarbuckcoffe;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PageFragmentSelectedAdapter extends FragmentStateAdapter {
    public PageFragmentSelectedAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new FoodFragment();
            case 2:
                return new DrinkFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
