package com.evn.evncpcmobile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.callback.ItemClickListener;
import com.evn.evncpcmobile.models.ObjNotifyMain;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by QQ on 7/7/2017.
 */

public class AdapterListNotifyMain extends RecyclerView.Adapter<AdapterListNotifyMain.TopicViewHoder> {
    private List<ObjNotifyMain> mList;
    private Context context;
    private ItemClickListener OnIListener;


    public ItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(ItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public AdapterListNotifyMain(List<ObjNotifyMain> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public TopicViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notify_main, parent, false);
        return new TopicViewHoder(view);
    }

    @Override
    public void onBindViewHolder(TopicViewHoder holder, int position) {
        ObjNotifyMain obj = mList.get(position);
        if (obj != null && obj.getsName().length() > 0) {
            holder.txt_name.setText(obj.getsName());
        }

        if (obj != null && obj.getsNumber().length() > 0) {
            holder.txt_number.setVisibility(View.VISIBLE);
            holder.txt_number.setText(obj.getsNumber());
        } else
            holder.txt_number.setVisibility(View.INVISIBLE);

        if (obj != null && obj.getsImage() > 0)
            Glide.with(context).load(obj.getsImage()).into(holder.ic_notify);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class TopicViewHoder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.txt_notify_name)
        TextView txt_name;
        @BindView(R.id.txt_number_notify)
        TextView txt_number;
        @BindView(R.id.ic_notify)
        ImageView ic_notify;

        public TopicViewHoder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            OnIListener.onClickItem(getLayoutPosition(), mList.get(getLayoutPosition()));
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

    public void updateList(List<ObjNotifyMain> list) {
        mList = list;
        notifyDataSetChanged();
    }
}
