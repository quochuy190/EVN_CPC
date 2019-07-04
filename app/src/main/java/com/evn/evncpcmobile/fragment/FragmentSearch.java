package com.evn.evncpcmobile.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.adapter.AdapterSearchMain;
import com.evn.evncpcmobile.base.BaseFragment;
import com.evn.evncpcmobile.callback.ItemClickListener;
import com.evn.evncpcmobile.models.ObjSearchMain;

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
public class FragmentSearch extends BaseFragment implements View.OnClickListener {

    public static FragmentSearch fragment;
    private List<ObjSearchMain> mList;
    private AdapterSearchMain adapter;
    @BindView(R.id.rcv_list_search_main)
    RecyclerView recycle_view;
    RecyclerView.LayoutManager mLayoutManager;

    public static FragmentSearch getInstance() {
        if (fragment == null) {
            synchronized (FragmentSearch.class) {
                if (fragment == null)
                    fragment = new FragmentSearch();
            }
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_main, container, false);
        ButterKnife.bind(this, view);
        init();
        initData();
        initEvent();

        return view;
    }

    private void initEvent() {
    }

    private void init() {
        mList = new ArrayList<>();
        adapter = new AdapterSearchMain(mList, getContext());
        mLayoutManager = new GridLayoutManager(getContext(), 2);
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

    private void initData() {
        mList.add(new ObjSearchMain(getString(R.string.txt_search_1), "0", R.drawable.ic_search_1));
        mList.add(new ObjSearchMain(getString(R.string.txt_search_2), "1", R.drawable.img_search_2));
        mList.add(new ObjSearchMain(getString(R.string.txt_search_3), "2", R.drawable.img_search_3));
        mList.add(new ObjSearchMain(getString(R.string.txt_search_4), "3", R.drawable.img_search_4));
        mList.add(new ObjSearchMain(getString(R.string.txt_search_5), "4", R.drawable.ic_search_5));
        mList.add(new ObjSearchMain(getString(R.string.txt_search_6), "5", R.drawable.img_search_6));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (getId()) {
            case R.id.txt_title_tracuu:

                break;

        }
    }
}
