package com.graduationproject.moham.pharmacy.Screens.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.graduationproject.moham.pharmacy.R;
import com.graduationproject.moham.pharmacy.BackListener.BackPressedListener;
import com.graduationproject.moham.pharmacy.Lib.NoSwipePager;
import com.graduationproject.moham.pharmacy.Screens.Main.adapter.BottomBarAdapter;
import com.graduationproject.moham.pharmacy.Screens.Screens.Home.HomeFragment;
import com.graduationproject.moham.pharmacy.Screens.Screens.More.MoreFragment;
import com.graduationproject.moham.pharmacy.Screens.Screens.Order.OrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {

    @BindView(R.id.viewpager)
    NoSwipePager mviewPager;

    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;

    BottomBarAdapter pagerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);
        initViewPager();

        return view;
    }


    void initViewPager() {
        mviewPager.setPagingEnabled(false);
        mviewPager.setOffscreenPageLimit(4);
        mviewPager.setCurrentItem(3, true);
        bottomNavigation.setCurrentItem(3);


        pagerAdapter = new BottomBarAdapter(getChildFragmentManager());
        pagerAdapter.addFragment(HomeFragment.newInstance());
        pagerAdapter.addFragment(OrderFragment.newInstance());
        pagerAdapter.addFragment(MoreFragment.newInstance());

        mviewPager.setAdapter(pagerAdapter);

        initBottomNavigation();
    }

    void initBottomNavigation() {

        bottomNavigation.setTranslucentNavigationEnabled(true);

        // Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

        // Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);


        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_pills, R.color.colorPrimary);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_store, R.color.colorAccent);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_more, R.color.colorPrimaryDark);

        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

        bottomNavigation.setOnTabSelectedListener((position, wasSelected) -> {
            if (!wasSelected)
                mviewPager.setCurrentItem(position);
            return true;
        });

    }

    public boolean onBackPressed() {
        try {
            BackPressedListener currentFragment = (BackPressedListener) pagerAdapter.getRegisteredFragment(mviewPager.getCurrentItem());

            if (currentFragment != null) {
                // lets see if the currentFragment or any of its childFragment can handle onBackPressed
                return currentFragment.onBackPressed();
            }

            // this Fragment couldn't handle the onBackPressed call
            return false;

        } catch (Exception e) {
            return true;
        }
        // currently visible tab Fragment
    }
}
