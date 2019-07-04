package com.evn.evncpcmobile.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.base.BaseFragment;

import butterknife.ButterKnife;



/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 22-April-2019
 * Time: 10:30
 * Version: 1.0
 */
public class FragmentHomeViewPage extends BaseFragment {
    private static final String TAG = "FragmentSetup";
    public static FragmentHomeViewPage fragment;

    public static FragmentHomeViewPage getInstance() {
        if (fragment == null) {
            synchronized (FragmentHomeViewPage.class) {
                if (fragment == null)
                    fragment = new FragmentHomeViewPage();
            }
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_viewpager, container, false);
        ButterKnife.bind(this, view);
        Log.e(TAG, "onCreateView: Setup");
        return view;
    }

}
