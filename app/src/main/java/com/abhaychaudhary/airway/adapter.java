package com.abhaychaudhary.airway;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class adapter extends FragmentStateAdapter {

    public adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new chatFragment();
            case 1:
                return new statusFragment();
            case 2:
                return new callFragment();
            default:
                return new chatFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
