package com.evn.evncpcmobile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.callback.ItemClickListener;
import com.evn.evncpcmobile.callback.OnListenerItemClickObjService;
import com.evn.evncpcmobile.models.ObjService;

import java.util.List;



public class AdapterServiceMain extends RecyclerView.Adapter<AdapterServiceMain.CategoryServiceViewHolder> {
    public static Context mContext;
    private List<ObjService> mList;

    public static OnListenerItemClickObjService onListenerItemClickObjService;
    private ItemClickListener OnIListener;
    private ItemClickListener OnIListener_Title;

    public AdapterServiceMain(Context context, List<ObjService> mList,
                              OnListenerItemClickObjService onListenerItemClickObjService) {
        this.onListenerItemClickObjService = onListenerItemClickObjService;
        mContext = context;
        this.mList = mList;
    }

    public ItemClickListener getOnIListener() {
        return OnIListener;
    }

    public void setOnIListener(ItemClickListener onIListener) {
        OnIListener = onIListener;
    }

    public ItemClickListener getOnIListener_Title() {
        return OnIListener_Title;
    }

    public void setOnIListener_Title(ItemClickListener onIListener_Title) {
        OnIListener_Title = onIListener_Title;
    }

    @NonNull
    @Override
    public CategoryServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item_service_main, parent, false);
        return new CategoryServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryServiceViewHolder holder, final int position) {
        ObjService obj = mList.get(position);
        if (obj.getmListSub() != null && obj.getmListSub().size() > 0) {
            holder.horizontalAdapter.setData(obj.getmListSub());
        }
        if (obj != null && obj.getsName() != null) {
            holder.title.setText(obj.getsName());
        }
        if (obj.getsImage() > 0) {
            Glide.with(mContext).load(obj.getsImage()).into(holder.ic_service);
        }
        if (obj.isShowSub()) {
            holder.img_right.setImageResource(R.drawable.ic_up);
            holder.horizontalList.setVisibility(View.VISIBLE);
        } else {
            holder.img_right.setImageResource(R.drawable.ic_down);
            holder.horizontalList.setVisibility(View.GONE);
        }
        holder.img_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnIListener.onClickItem(position, mList.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class CategoryServiceViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;
        public ImageView ic_service;
        private AdapterSubService horizontalAdapter;
        private RecyclerView horizontalList;
        private ImageView img_right;

        public CategoryServiceViewHolder(View view) {
            super(view);
            Context context = itemView.getContext();
            title = (TextView) view.findViewById(R.id.txt_service_name);
            ic_service = view.findViewById(R.id.ic_service);
            img_right = (ImageView) view.findViewById(R.id.img_right);
            horizontalList = (RecyclerView) itemView.findViewById(R.id.rcv_sub_service);
            horizontalList.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL,
                    false));
            horizontalAdapter = new AdapterSubService(mContext, onListenerItemClickObjService);
            horizontalList.setAdapter(horizontalAdapter);
        }
    }

    public void update_list(List<ObjService> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

}
