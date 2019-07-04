package com.evn.evncpcmobile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.Group;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.evn.evncpcmobile.R;
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
public class FragmentSetup extends BaseFragment {
    private static final String TAG = "FragmentSetup";
    public static FragmentSetup fragment;
    @BindView(R.id.ic_setup_guild)
    ImageView ic_setup_guild;
    @BindView(R.id.txt_setup_guild)
    TextView txt_setup_guild;

    @BindView(R.id.ic_setup_logout)
    ImageView ic_setup_logout;
    @BindView(R.id.txt_setup_logout)
    TextView txt_setup_logout;
    public static FragmentSetup getInstance() {
        if (fragment == null) {
            synchronized (FragmentSetup.class) {
                if (fragment == null)
                    fragment = new FragmentSetup();
            }
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setup, container, false);
        ButterKnife.bind(this, view);
        Log.e(TAG, "onCreateView: Setup");
        initEvent();
        return view;
    }

    private void initEvent() {
        txt_setup_guild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Guild", Toast.LENGTH_SHORT).show();
            }
        });
        ic_setup_guild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Guild", Toast.LENGTH_SHORT).show();
            }
        });
        ic_setup_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* startActivity(new Intent(getContext(), LoginUserActivity.class));
                getActivity().finish();*/
            }
        });
        txt_setup_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* startActivity(new Intent(getContext(), LoginUserActivity.class));
                getActivity().finish();*/
            }
        });
    }

}
