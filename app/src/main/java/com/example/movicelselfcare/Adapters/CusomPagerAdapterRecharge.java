package com.example.movicelselfcare.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.movicelselfcare.Fragments.FragmentRecharge4G;
import com.example.movicelselfcare.Fragments.FragmentRechargeAll;
import com.example.movicelselfcare.Fragments.FragmentRechargePopular;
import com.example.movicelselfcare.Fragments.FragmentRechargeTopup;

public class CusomPagerAdapterRecharge extends FragmentStatePagerAdapter {

    private int tabCount;

    //Constructor to the class
    public CusomPagerAdapterRecharge(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                Fragment tab1 = new FragmentRechargeAll();
                return tab1;

            case 1:
                Fragment tab3 = new FragmentRechargePopular();
                return tab3;

            case 2:
                Fragment tab2 = new FragmentRechargeTopup();
                return tab2;

            case 3:
                Fragment tab4 = new FragmentRecharge4G();
                return tab4;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }


}
