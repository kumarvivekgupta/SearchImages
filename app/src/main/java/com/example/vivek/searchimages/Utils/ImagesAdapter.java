package com.example.vivek.searchimages.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vivek.searchimages.Models.Model.ImagesModel.BaseModelClass;
import com.example.vivek.searchimages.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 5/5/2018.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.MyViewHolder> {


    private ImagesAdapter.Clicklistener mClickListener;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<BaseModelClass> mListItems;
    //   private Uri uri;

    public ImagesAdapter(Context context, ArrayList<BaseModelClass> data) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.mListItems = new ArrayList<>();
        this.mListItems = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.single_image_layout, parent, false);
        ImagesAdapter.MyViewHolder holder = new ImagesAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Picasso.with(mContext).
                load(mListItems.get(position).getImagesThumbnailUrl())
                .into(holder.singleImage);
        holder.singleImageTitle.setText(mListItems.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.imageView)
        ImageView singleImage;

        @BindView(R.id.imageTitle)
        TextView singleImageTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                mClickListener.itemclicked(getAdapterPosition());

            }
        }
    }

    public interface Clicklistener {
        void itemclicked(int position);
    }

    public void setClicklistener(ImagesAdapter.Clicklistener clicklistener) {
        this.mClickListener = clicklistener;
    }


}
