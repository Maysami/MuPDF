package com.artifex.utils;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
/**
 * @author mohammadreza meysami
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs = 0;
    String valueID;

    public MyPagerAdapter(FragmentManager fm, int mNumOfTabs,final String valueID) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
        this.valueID = valueID ;
    }



    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 3:
                IndexBookFragment indexBookFragment= new IndexBookFragment();
                return indexBookFragment;
            case 2:
                IndexBookFragment indexBookFragment1= new IndexBookFragment();
                return indexBookFragment1;
            case 1:
                IndexBookFragment indexBookFragment2= new IndexBookFragment();
                return indexBookFragment2;
            case 0:
                IndexBookFragment indexBookFragment3= new IndexBookFragment();
                return indexBookFragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
