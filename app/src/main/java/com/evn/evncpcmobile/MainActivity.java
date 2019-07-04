package com.evn.evncpcmobile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.base.BaseActivity;
import com.evn.evncpcmobile.fragment.FragmentHome;
import com.evn.evncpcmobile.fragment.FragmentNotify;
import com.evn.evncpcmobile.fragment.FragmentSearch;
import com.evn.evncpcmobile.fragment.FragmentService;
import com.evn.evncpcmobile.fragment.FragmentSetup;

import butterknife.BindView;


/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 18-June-2019
 * Time: 17:42
 * Version: 1.0
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.nav_bottom_bar)
    BottomNavigationView bottom_bar;
    FragmentHome fragmentHome;
    FragmentNotify fragmentNotify;
    FragmentSearch fragmentSearch;
    FragmentService fragmentService;
    FragmentSetup fragmentSetup;

    @Override
    public int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBottomBar();
        loadFragmentHome();
    }

    private void initBottomBar() {
        bottom_bar.setItemIconTintList(null);
        bottom_bar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.tab_home:
                    loadFragmentHome();
                    return true;
                case R.id.tab_notify:
                    loadFragmentNotify();
                    return true;
                case R.id.tab_search:
                    loadFragmentSearch();
                    return true;
                case R.id.tab_service:
                    loadFragmentService();
                    return true;
                case R.id.tab_setup:
                    loadFragmentSetup();
                    return true;
            }
            return false;
        }
    };

    private void loadFragmentHome() {
        //   objLogin = SharedPrefs.getInstance().get(Constants.KEY_SAVE_USER_LOGIN, ObjLogin.class);

        fragmentHome = (FragmentHome) getSupportFragmentManager().findFragmentByTag(FragmentHome.class.getName());

        if (fragmentHome == null) {
            fragmentHome = FragmentHome.getInstance();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragmentHome.isAdded()) {
            transaction.add(R.id.frame_home_fragment, fragmentHome, FragmentHome.class.getName());
        } else {
            //  transaction.hide(fragmentCurrent);
            if (fragmentNotify != null && fragmentNotify.isAdded()) {
                transaction.hide(fragmentNotify);
            }
            if (fragmentSearch != null && fragmentSearch.isAdded()) {
                transaction.hide(fragmentSearch);
            }
            if (fragmentService != null && fragmentService.isAdded()) {
                transaction.hide(fragmentService);
            }
            if (fragmentSetup != null && fragmentSetup.isAdded()) {
                transaction.hide(fragmentSetup);
            }
            transaction.show(fragmentHome);
        }
        //   fragmentCurrent = fragmentHome;
        transaction.commit();
    }

    private void loadFragmentNotify() {
        //   objLogin = SharedPrefs.getInstance().get(Constants.KEY_SAVE_USER_LOGIN, ObjLogin.class);

        fragmentNotify = (FragmentNotify) getSupportFragmentManager().findFragmentByTag(FragmentNotify.class.getName());

        if (fragmentNotify == null) {
            fragmentNotify = FragmentNotify.getInstance();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragmentNotify.isAdded()) {
            transaction.add(R.id.frame_home_fragment, fragmentNotify, FragmentNotify.class.getName());
        } else {
            //  transaction.hide(fragmentCurrent);
            if (fragmentHome != null && fragmentHome.isAdded()) {
                transaction.hide(fragmentHome);
            }
            if (fragmentSearch != null && fragmentSearch.isAdded()) {
                transaction.hide(fragmentSearch);
            }
            if (fragmentService != null && fragmentService.isAdded()) {
                transaction.hide(fragmentService);
            }
            if (fragmentSetup != null && fragmentSetup.isAdded()) {
                transaction.hide(fragmentSetup);
            }
            transaction.show(fragmentNotify);
        }
        //   fragmentCurrent = fragmentHome;
        transaction.commit();
    }

    private void loadFragmentSearch() {
        //   objLogin = SharedPrefs.getInstance().get(Constants.KEY_SAVE_USER_LOGIN, ObjLogin.class);

        fragmentSearch = (FragmentSearch) getSupportFragmentManager().findFragmentByTag(FragmentSearch.class.getName());

        if (fragmentSearch == null) {
            fragmentSearch = FragmentSearch.getInstance();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragmentSearch.isAdded()) {
            transaction.add(R.id.frame_home_fragment, fragmentSearch, FragmentSearch.class.getName());
        } else {
            //  transaction.hide(fragmentCurrent);
            if (fragmentHome != null && fragmentHome.isAdded()) {
                transaction.hide(fragmentHome);
            }
            if (fragmentNotify != null && fragmentNotify.isAdded()) {
                transaction.hide(fragmentNotify);
            }
            if (fragmentService != null && fragmentService.isAdded()) {
                transaction.hide(fragmentService);
            }
            if (fragmentSetup != null && fragmentSetup.isAdded()) {
                transaction.hide(fragmentSetup);
            }
            transaction.show(fragmentSearch);
        }
        //   fragmentCurrent = fragmentHome;
        transaction.commit();
    }

    private void loadFragmentService() {
        //   objLogin = SharedPrefs.getInstance().get(Constants.KEY_SAVE_USER_LOGIN, ObjLogin.class);

        fragmentService = (FragmentService) getSupportFragmentManager().findFragmentByTag(FragmentService.class.getName());

        if (fragmentService == null) {
            fragmentService = FragmentService.getInstance();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragmentService.isAdded()) {
            transaction.add(R.id.frame_home_fragment, fragmentService, FragmentService.class.getName());
        } else {
            //  transaction.hide(fragmentCurrent);
            if (fragmentHome != null && fragmentHome.isAdded()) {
                transaction.hide(fragmentHome);
            }
            if (fragmentNotify != null && fragmentNotify.isAdded()) {
                transaction.hide(fragmentNotify);
            }
            if (fragmentSearch != null && fragmentSearch.isAdded()) {
                transaction.hide(fragmentSearch);
            }
            if (fragmentSetup != null && fragmentSetup.isAdded()) {
                transaction.hide(fragmentSetup);
            }
            transaction.show(fragmentService);
        }
        //   fragmentCurrent = fragmentHome;
        transaction.commit();
    }

    private void loadFragmentSetup() {
        //   objLogin = SharedPrefs.getInstance().get(Constants.KEY_SAVE_USER_LOGIN, ObjLogin.class);

        fragmentSetup = (FragmentSetup) getSupportFragmentManager().findFragmentByTag(FragmentSetup.class.getName());

        if (fragmentSetup == null) {
            fragmentSetup = FragmentSetup.getInstance();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragmentSetup.isAdded()) {
            transaction.add(R.id.frame_home_fragment, fragmentSetup, FragmentSetup.class.getName());
        } else {
            //  transaction.hide(fragmentCurrent);
            if (fragmentHome != null && fragmentHome.isAdded()) {
                transaction.hide(fragmentHome);
            }
            if (fragmentNotify != null && fragmentNotify.isAdded()) {
                transaction.hide(fragmentNotify);
            }
            if (fragmentSearch != null && fragmentSearch.isAdded()) {
                transaction.hide(fragmentSearch);
            }
            if (fragmentService != null && fragmentService.isAdded()) {
                transaction.hide(fragmentService);
            }
            transaction.show(fragmentSetup);
        }
        //   fragmentCurrent = fragmentHome;
        transaction.commit();
    }
}
