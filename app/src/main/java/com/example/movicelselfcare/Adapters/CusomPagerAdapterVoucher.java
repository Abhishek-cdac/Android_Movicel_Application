package com.example.movicelselfcare.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.movicelselfcare.Fragments.FragmentRecharge4G;
import com.example.movicelselfcare.Fragments.FragmentRechargeAll;
import com.example.movicelselfcare.Fragments.FragmentRechargePopular;
import com.example.movicelselfcare.Fragments.FragmentRechargeTopup;
import com.example.movicelselfcare.Fragments.FragmentVoucherBuy;
import com.example.movicelselfcare.Fragments.FragmentVoucherHistory;
import com.example.movicelselfcare.Fragments.FragmentVoucherView;

public class CusomPagerAdapterVoucher extends FragmentStatePagerAdapter {

    private int tabCount;

    //Constructor to the class
    public CusomPagerAdapterVoucher(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                Fragment tab1 = new FragmentVoucherView();
                return tab1;

            case 1:
                Fragment tab3 = new FragmentVoucherBuy();
                return tab3;

            case 2:
                Fragment tab2 = new FragmentVoucherHistory();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }


}
