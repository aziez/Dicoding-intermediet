package com.example.fragmentwa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context mContext;
    List<ListChat> mData;

    public RecycleViewAdapter(Context mContext, List<ListChat> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_listchat,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_phone.setText(mData.get(position).getPhone());
        holder.img.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_phone;
        private ImageView img;

        public MyViewHolder(View itemView) {

            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.item_listchat);
            tv_phone = (TextView) itemView.findViewById(R.id.item_numberphone);
            img = (ImageView) itemView.findViewById(R.id.img_item_photo);
        }
    }

}
