package com.example.movicelselfcare;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.movicelselfcare.Adapters.ImagePager;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private ImagePager myPager;
    private DrawerLayout mDrawerLayout;
    public NavigationView mNavigationView;
    private CustomSharedPreferences sharedPreferences;
    private ImageView mImageViewUser;
    private TextView mTextViewUserName, mTextViewSelfCheckIn;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_dashboard, container, false);
        myPager = new ImagePager(getActivity());
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(myPager);

        sharedPreferences = new CustomSharedPreferences(getActivity());
        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.red));
        }

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        init(view);

        mNavigationView.getMenu().getItem(0).setChecked(true);

        return view;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        mDrawerLayout.closeDrawers();
        switch (item.getItemId()) {

            case R.id.navigation_view_item_home:
                break;

            case R.id.navigation_view_item_recharge:
                break;

            case R.id.navigation_view_item_my_vouchers:
                break;

            case R.id.navigation_view_item_my_plan:
                break;

            case R.id.navigation_view_item_coupons:
                break;

            case R.id.navigation_view_item_my_statements:
                break;

            case R.id.navigation_view_item_movicel_care:
                break;

                case R.id.navigation_view_item_locate_us:
                break;

            case R.id.navigation_view_item_our_network:
                break;

            case R.id.navigation_view_item_Settings:
                break;

            case R.id.navigation_view_item_logout:
                getActivity().finish();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void bindResources(final View view) {

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_dashboard_notification);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
//        getActivity().setActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) view.findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.setItemIconTintList(null);
        Menu m = mNavigationView.getMenu();
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);
//            applyFontToMenuItem(mi);
        }

        if (sharedPreferences.isGuestLogin()) {
            Menu menuNav = mNavigationView.getMenu();
            MenuItem nav_item2 = menuNav.findItem(R.id.navigation_view_item_logout);
            nav_item2.setVisible(false);
        }

        View header = mNavigationView.getHeaderView(0);

        mTextViewUserName = (TextView) header.findViewById(R.id.userName);
        mImageViewUser = (ImageView) header.findViewById(R.id.imageView_User);
        mTextViewSelfCheckIn = (TextView) header.findViewById(R.id.selfCheckIn);

        mImageViewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_dashboard_notification, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init(View view) {
        bindResources(view);
    }
}