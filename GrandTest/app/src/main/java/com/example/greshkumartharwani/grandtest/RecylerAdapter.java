package com.example.greshkumartharwani.grandtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Gresh Kumar Tharwani on 12/16/2017.
 */

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.OfferViewHolder> {
    Context context;
    List<Offer> offerList;
    String Base_Url = "http://www.savrrr.com/";
    public RecylerAdapter (Context context, List<Offer> offerModelList){
        this.context = context;
        offerList = offerModelList;
    }

    @Override
    public OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_recyclerview, parent,false);
        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecylerAdapter.OfferViewHolder holder, int position) {

        holder.tv_title.setText(offerList.get(position).getOfferTitle());
        holder.tv_desc.setText(offerList.get(position).getOfferDescription());
        Picasso.with(holder.iv_image.getContext()).load( Base_Url.concat(offerList.get(position).getThumbnail().getLink())).into(holder.iv_image);
        ;

    }

    @Override
    public int getItemCount() {
        return offerList.size();
    }

    public class OfferViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_image;
        TextView tv_title;
        TextView tv_desc;

        public OfferViewHolder (View view){
            super(view);
            iv_image = (ImageView)view.findViewById(R.id.iv_image);
            tv_title = (TextView)view.findViewById(R.id.tv_Title);
            tv_desc = (TextView)view.findViewById(R.id.tv_Desc);

        }
    }
}
