package com.evn.evncpcmobile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.callback.OnListenerItemClickObjService;
import com.evn.evncpcmobile.callback.setOnItemClickListener;
import com.evn.evncpcmobile.models.ServiceSub;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterSubService extends RecyclerView.Adapter<AdapterSubService.FlightInfoViewHoder> {
    private List<ServiceSub> mLisServiceSub = new ArrayList<>();
    private Context context;
    private setOnItemClickListener OnIListener;
    private OnListenerItemClickObjService onListenerItemClickObjService;

    public setOnItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(setOnItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public AdapterSubService(Context context, OnListenerItemClickObjService onListenerItemClickObjService) {
        this.context = context;
        this.onListenerItemClickObjService = onListenerItemClickObjService;
    }


    @NonNull
    @Override
    public FlightInfoViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service_sub, parent, false);
        return new FlightInfoViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightInfoViewHoder holder, final int position) {
        ServiceSub objService = mLisServiceSub.get(position);

        if (objService != null && objService.getsName() != null) {
            holder.txt_name.setText(objService.getsName());
        } else {
            holder.txt_name.setText("...");
        }
        if (position != (mLisServiceSub.size() - 1)) {
            holder.view_bottom.setVisibility(View.VISIBLE);
        } else
            holder.view_bottom.setVisibility(View.INVISIBLE);
    }


    @Override
    public int getItemCount() {
        return mLisServiceSub.size();
    }

    public class FlightInfoViewHoder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.txt_name_item_sub_service)
        TextView txt_name;
        @BindView(R.id.view_bottom)
        View view_bottom;

        public FlightInfoViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onListenerItemClickObjService.onClickListener(getLayoutPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            OnIListener.OnLongItemClickListener(getLayoutPosition());
            return false;
        }
    }

    public void setData(List<ServiceSub> data) {
        if (mLisServiceSub != data) {
            mLisServiceSub = data;
            notifyDataSetChanged();
        }
    }
}
