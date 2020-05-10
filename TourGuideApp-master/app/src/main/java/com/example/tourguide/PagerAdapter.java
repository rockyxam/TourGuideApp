package com.example.tourguide;


import android.annotation.SuppressLint;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

@SuppressWarnings("deprecation")
public class PagerAdapter extends FragmentStatePagerAdapter {
    private Context mContext;
    public PagerAdapter(Context context, FragmentManager fm){

    super(fm);
    mContext=context;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AboutCity();
        }  else if (position == 1) {
            return new PlacesToSee();
        } else {
            return new Hotels();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
    @SuppressLint("StringFormatInvalid")
    @Override
    public CharSequence getPageTitle(int position){
        if(position==0){
            return mContext.getString(R.string.categoty_city );
        }else if (position==1){
            return mContext.getString(R.string.category_places);
        }else {
            return mContext.getString(R.string.category_hotels);
        }
    }
}
