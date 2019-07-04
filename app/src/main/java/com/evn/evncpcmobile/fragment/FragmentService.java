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
import com.evn.evncpcmobile.adapter.AdapterServiceMain;
import com.evn.evncpcmobile.base.BaseFragment;
import com.evn.evncpcmobile.callback.ItemClickListener;
import com.evn.evncpcmobile.callback.OnListenerItemClickObjService;
import com.evn.evncpcmobile.models.ObjService;
import com.evn.evncpcmobile.models.ServiceSub;

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
public class FragmentService extends BaseFragment {
    private static final String TAG = "FragmentSetup";
    public static FragmentService fragment;
    RecyclerView.LayoutManager mLayoutManager;
    List<ObjService> mList;
    List<ServiceSub> mListSubService;
    @BindView(R.id.rcv_service_main)
    RecyclerView rcv_service_main;
    AdapterServiceMain adapter;

    public static FragmentService getInstance() {
        if (fragment == null) {
            synchronized (FragmentService.class) {
                if (fragment == null)
                    fragment = new FragmentService();
            }
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        ButterKnife.bind(this, view);
        Log.e(TAG, "onCreateView: Setup");
        init();
        initData();
        return view;
    }

    private void initData() {
        List<ServiceSub> mLisSub_1 = new ArrayList<>();
        List<ServiceSub> mLisSub_2 = new ArrayList<>();
        List<ServiceSub> mLisSub_3 = new ArrayList<>();

        mLisSub_1.add(new ServiceSub("0", getString(R.string.txt_service_sub_1_0)));
        mLisSub_1.add(new ServiceSub("1", getString(R.string.txt_service_sub_1_1)));


        mLisSub_2.add(new ServiceSub("0", getString(R.string.txt_service_sub_2_0)));
        mLisSub_2.add(new ServiceSub("1", getString(R.string.txt_service_sub_2_1)));
        mLisSub_2.add(new ServiceSub("2", getString(R.string.txt_service_sub_2_2)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_3)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_4)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_5)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_6)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_7)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_8)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_9)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_10)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_11)));
        mLisSub_2.add(new ServiceSub("3", getString(R.string.txt_service_sub_2_12)));

        mLisSub_3.add(new ServiceSub("0", getString(R.string.txt_service_sub_3_0)));
        mLisSub_3.add(new ServiceSub("1",  getString(R.string.txt_service_sub_3_1)));
        mLisSub_3.add(new ServiceSub("2",  getString(R.string.txt_service_sub_3_2)));
        mLisSub_3.add(new ServiceSub("3", getString(R.string.txt_service_sub_3_3)));

        mList.add(new ObjService("0", "dịch vụ cung cấp điện mới", R.drawable.ic_service_1, mLisSub_1, false));
        mList.add(new ObjService("1", "dịch vụ trong quá trình hợp đồng mua bán điện", R.drawable.ic_service_2, mLisSub_2, false));
        mList.add(new ObjService("2", "các dịch vụ hỗ trợ", R.drawable.ic_service_3, mLisSub_3, false));

        adapter.notifyDataSetChanged();
    }

    private void init() {
        mList = new ArrayList<>();
        adapter = new AdapterServiceMain(getContext(), mList, new OnListenerItemClickObjService() {
            @Override
            public void onClickListener(Object objService) {

            }

            @Override
            public void onItemXemthemClick(Object objService) {

            }
        });
        mLayoutManager = new GridLayoutManager(getContext(), 1);
        rcv_service_main.setHasFixedSize(true);
        rcv_service_main.setLayoutManager(mLayoutManager);
        rcv_service_main.setItemAnimator(new DefaultItemAnimator());
        rcv_service_main.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnIListener(new ItemClickListener() {
            @Override
            public void onClickItem(int position, Object item) {
                ObjService obj = (ObjService) item;
                for (ObjService objSer : mList) {
                    if (!obj.isShowSub()) {
                        if (obj.getsId().equals(objSer.getsId())) {
                            objSer.setShowSub(true);
                        } else
                            objSer.setShowSub(false);
                    } else {
                        objSer.setShowSub(false);
                    }

                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
