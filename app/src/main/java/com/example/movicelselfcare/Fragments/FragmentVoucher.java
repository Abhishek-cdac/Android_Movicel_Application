package com.example.movicelselfcare.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.movicelselfcare.Adapters.CusomPagerAdapterRecharge;
import com.example.movicelselfcare.Adapters.CusomPagerAdapterVoucher;
import com.example.movicelselfcare.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentVoucher extends Fragment implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    CusomPagerAdapterVoucher cusomPagerAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_voucher, container, false);

        android.widget.Toolbar myToolbar = (Toolbar) view.findViewById(R.id.my_toolbar);
        getActivity().setActionBar(myToolbar);

        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.grey));
        }

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText(R.string.view));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.buyC));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.history));

        viewPager = (ViewPager)view.findViewById(R.id.notification_pager);

        tabLayout.setOnTabSelectedListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                tabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        cusomPagerAdapter = new CusomPagerAdapterVoucher(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(cusomPagerAdapter);

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("test", "onActivityResult Voucher");

    }
}

/*
* nvhfjhfhjfjfjhfj jhjhf jhfjhf jgjhf jhgkj jkgkjg kjg kjg kjgkjg kjgkjg jkg kjg kjgkjgkj kjg kjg kjgkjg kjgkj  kjgjkgkjg jkgkj gjk gkjg kjgkj gkj gkj gkjg kjgkjg kjgkjg kjgjkgkjg kjg kjgk
* jhfy bfjy hfjyr jgjh jgjhfjhghjh hjhjkg kjgk kjgkgjkg jkgkjg kjg jggkjgkj kjg kjgkj kjgjkgk kjgkjgkj jkgkjg gkj gkjg jkgkj g kjgkj kjgkjgkjg kjgkjgkj kjgkjgkj kjgkjgkg kjgkjg kjgkj
* jhfjhf jkggkjgkj kjjg kjgkjg kjgkjgkj g kjgkjg kjg kjgkjgkj jkgkjgkj kjgkjg jgjg g jkgkjgkjgk jkgkgk kjg kgk kjg kjgkj kjgkjfhj kjghfgh kjgjhfdhgg kjgkjghjfhjk kjghjfhjfj hfjhkg hjfjhdhj jghjfj
* jhfjfh gjhjkhh jhjkgk ggkj kjgkjg gjgkj jkgkjg g hjgj hjgg gjj kjgkjg gkjgk jkgkjg kjgjgkkjgjk gj jkgkjgj jkghjgk kjgjh g gjhfj ghjf  jhfjfgk jhf gk gkg  kgkj kjgkj  jhkjh khkjh khkhkjhk kjhjkh kjhkj kjkjh
* vjhgj jhghjgj hjgjhgjhg hjgjhghj hjgjhgj jghjg jhgjhg jgjhg hjgjh hjghjg jg hjgjh mnb jk jgk kjgkj j kjggjkgj jhkjkj kjkg kjk kjgkj kjgkj jgkj kjgk jgkj kjgk kjghk kgkh jkgkjg kjg kh jgjkgk kjgkg kjgkjg kjgkgk kjgkjg kg kgk g kjgkjg kjggkgj
* nvmn jkjjk hkjhk kjhjkh kkhkjh kjhkjh kjhkj kjhjhk khkjh kjhjh kh kjhk kjhkjhkkjhkjh khk kjhk  kjhkjh kjhjkh kjh kj jkhkj hkjh kjhjkhkh kjhjhk kjhkj kjh kjhkjh kjhhkj kjhkjhk hkjhkjh jkhkjh
* vgjhg g hgjh hgjhg jh jhghjghjg jhghj jgjg jgjghjg hgjg jg hj jhg hjgjhg jgjh gj g jghjghg jhgjhgg jg gjjgjhg jhg jhgj gjhg gjg hj jhgg jhg hjghg jhg jhgjh hjgjhg jhg jhg jg  jhghgj
* cffhhg jhgjhgjhg jghjgjgk gjkgj g kjggkgkj jggjh ghjg jhgjghjg jhghjghj jhggjgjg jhgjhghg jhghgj jg jgj jhgjg jg hjggjh hjghjgj jhghjgh hjg jhg jghgj jgjhg hjgjh g jghjg jhgjhg hjghj
* fhhg hjfjhhjgh hjghjghghjgjghj jhhjfhjf jhghjj jhgjhghjgj jhgjhgjh jgjhghjg jhgjhjh jhgjgj jggjhgjg hjghjgj yut jhghjgyjhv jhghftv hhfgfufuyhhhj hjghjghjgyggh hgjgjuyfffjh jhgjhjhfyu jhjhfugnvgyguy
* jhjhf ggjg hgjhgjh kjjghjh jhgjh jhgjh jhg jh jghjgjh jgjhgj hjgjgj jgjhgjjh jhghj jhghjgjj jhgjh gjghg jhghjg jhg hgjhgj hjghjg jhghjg jhg  jhggj ghjg jg jgjhg jhghj jhghjghj hjg
* vjh hgj gjgjgj jhgjgj hjghjgjhg jhghjghj jhghjgjh jhghjgj hjghjjhg jhghgjg jhgjhg j hg jhghgjhg hjghjgj hjg gjh jhghffytu gfjhghfgh hfhfhg hfhgfhfhg fghfhg ghfhgfh hfghfhg hgghfhg hgfghf
* hjfhfhg fjhfhj hjhjfjhf jhfjhfjhj hjfhjffjh hjfjhfj jhfjhf hghjfj fj hjfhf jh jhfhfh hghfjh jhfhjfjh jhfjhfjhf hfhfj fj jhfjhfj jhfjh fhfj hjf
*  jbjhg jhgh jgjh jhfjh jhfh jhfj jhgjhg  jmj jgkghk kjgkkg k ukuu fkutku kukug kgu gkh  dfilghdfi kglsdg dfhglsd*/