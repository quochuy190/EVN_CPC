package com.evn.evncpcmobile.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.adapter.AdapterListNotifyMain;
import com.evn.evncpcmobile.base.BaseFragment;
import com.evn.evncpcmobile.callback.ItemClickListener;
import com.evn.evncpcmobile.models.ObjNotifyMain;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 22-April-2019
 * Time: 10:30
 * Version: 1.0
 */
public class FragmentNotify extends BaseFragment {
    private static final String TAG = "FragmentSetup";
    public static FragmentNotify fragment;
    private List<ObjNotifyMain> mList;
    private AdapterListNotifyMain adapter;
    @BindView(R.id.rcv_notify_main)
    RecyclerView recycle_view;
    RecyclerView.LayoutManager mLayoutManager;

    public static FragmentNotify getInstance() {
        if (fragment == null) {
            synchronized (FragmentNotify.class) {
                if (fragment == null)
                    fragment = new FragmentNotify();
            }
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notify, container, false);
        ButterKnife.bind(this, view);
        Log.e(TAG, "onCreateView: Setup");
        init();
        initData();
        return view;
    }

    private void initData() {
        mList.add(new ObjNotifyMain("Thông báo tiền điện", "3", R.drawable.ic_notify_1));
        mList.add(new ObjNotifyMain("Thông báo tạm ngừng cung cấp điện", "", R.drawable.ic_notify_2));
        mList.add(new ObjNotifyMain("Thông báo khác", "", R.drawable.ic_notify_3));

        adapter.notifyDataSetChanged();
    }

    private void init() {
        mList = new ArrayList<>();
        adapter = new AdapterListNotifyMain(mList, getContext());
        mLayoutManager = new GridLayoutManager(getContext(), 1);
        recycle_view.setNestedScrollingEnabled(false);
        recycle_view.setHasFixedSize(true);
        recycle_view.setLayoutManager(mLayoutManager);
        recycle_view.setItemAnimator(new DefaultItemAnimator());
        recycle_view.setAdapter(adapter);

        adapter.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {

            }
        });
    }

}
