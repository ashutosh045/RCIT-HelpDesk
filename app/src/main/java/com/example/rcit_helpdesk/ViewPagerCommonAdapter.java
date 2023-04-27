package com.example.rcit_helpdesk;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerCommonAdapter extends FragmentPagerAdapter implements View.OnClickListener{

    public ViewPagerCommonAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {


            if (position == 0) {
                return new StudentCseFragment();
            } else {
                return new FacultyCseFragment();
            }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Student";
        }else
            return "Faculty";
    }

    @Override
    public void onClick(View view) {

    }

}
