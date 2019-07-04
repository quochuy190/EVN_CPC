package com.evn.evncpcmobile.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.adapter.AdapterViewpager;
import com.evn.evncpcmobile.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 22-April-2019
 * Time: 10:30
 * Version: 1.0
 */
public class FragmentHome extends BaseFragment {
    private static final String TAG = "FragmentSetup";
    public static FragmentHome fragment;
    @BindView(R.id.viewpager_info_home)
    ViewPager viewPager;
    public AdapterViewpager adapterViewpager;
    @BindView(R.id.tab_layout_home)
    public TabLayout tabLayout;

    public static FragmentHome getInstance() {
        if (fragment == null) {
            synchronized (FragmentHome.class) {
                if (fragment == null)
                    fragment = new FragmentHome();
            }
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        setStatusBarGradiant(getActivity());
        initViewpager();
        return view;
    }

    private void initViewpager() {
        adapterViewpager = new AdapterViewpager(getChildFragmentManager());
        adapterViewpager.addFragment(new FragmentHomeViewPage(), "");
        adapterViewpager.addFragment(new FragmentHomeViewPage(), "");
        adapterViewpager.addFragment(new FragmentHomeViewPage(), "");
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapterViewpager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarGradiant(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            Drawable background = activity.getResources().getDrawable(R.drawable.spr_gradient_banner);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }
    }

}
