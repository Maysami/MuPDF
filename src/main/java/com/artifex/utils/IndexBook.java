package com.artifex.utils;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artifex.mupdfdemo.R;


public class IndexBook extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_book);

        initViewPagerAndTabs();


    }


    private void initViewPagerAndTabs() {

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout_index);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.str_header_search_index));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.str_header_last_read));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.str_header_best_index));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.str_header_initial_index));



        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/sans_light.ttf");
        ViewGroup vg = (ViewGroup) (tabLayout.getChildAt(0));
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(tf);
                }
            }
        }

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_index);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), null);
        viewPager.setAdapter(myPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(3);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

}
