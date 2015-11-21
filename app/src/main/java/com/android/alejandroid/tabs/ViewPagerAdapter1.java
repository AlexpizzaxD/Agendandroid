package com.android.alejandroid.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter1 extends FragmentPagerAdapter {
    String[]tabTitleArray = {"Contactos", "Asignaturas", "Eventos"};

    public ViewPagerAdapter1 (FragmentManager manager){
        super(manager);
    }


    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0: return new Fragment1();
            case 1: return new Fragment2();
            case 2: return new Fragment3();
        }
        return null;
    }

    @Override
    public int getCount(){
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitleArray[position];
    }
}
