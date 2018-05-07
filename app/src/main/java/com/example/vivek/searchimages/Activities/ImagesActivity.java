package com.example.vivek.searchimages.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.vivek.searchimages.Models.Model.ImagesModel.BaseModelClass;
import com.example.vivek.searchimages.Network.GettingImageNetwork.ImagesApiClient;
import com.example.vivek.searchimages.R;
import com.example.vivek.searchimages.Utils.ImagesAdapter;
import com.example.vivek.searchimages.Views.ProgressLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Vivek on 5/5/2018.
 */

public class ImagesActivity extends AppCompatActivity implements ImagesAdapter.Clicklistener, ImagesApiClient.ImagesResponse {
    //  private ProgressLoader loader;
    private ImagesAdapter adapter;
    //  private BaseModelClass mBaseModelClass;
    public static List<BaseModelClass> mBaseModelClass;
    private ArrayList<BaseModelClass> mImagesRecyclerModel = new ArrayList<>();
    private ProgressLoader loader = new ProgressLoader(this);

    @BindView(R.id.recyclerView)
    RecyclerView imagesRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // loader = new ProgressLoader(this);
        //   Log.i("recycler111",imagesRecyclerView+"");
        loader.showLoader();
        ImagesApiClient imagesApiClient = new ImagesApiClient(ImagesActivity.this);
        imagesApiClient.images();


    }


    @Override
    public void itemclicked(int position) {

        loader.dismissLoader();

        Intent i = new Intent(ImagesActivity.this, SingleBigImage.class);


        i.putExtra("Url", mBaseModelClass.get(position).getImageUrl());
        startActivity(i);

    }

    public ArrayList<BaseModelClass> getdata1() {
        return mImagesRecyclerModel;
    }


    @Override
    public void onResponse(List<BaseModelClass> imagesBaseModelClass) {
      
        mBaseModelClass = imagesBaseModelClass;

        for (int j = 0; j < mBaseModelClass.size(); j++) {
            mImagesRecyclerModel.add(mBaseModelClass.get(j));
        }

        adapter = new ImagesAdapter(this, getdata1());
        imagesRecyclerView.setAdapter(adapter);

        imagesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter.setClicklistener(this);

    }
}
