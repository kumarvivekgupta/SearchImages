package com.example.vivek.searchimages.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.vivek.searchimages.Models.Model.ImagesModel.BaseModelClass;
import com.example.vivek.searchimages.Network.GettingImageNetwork.ImagesApiClient;
import com.example.vivek.searchimages.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vivek on 5/7/2018.
 */

public class SingleBigImage extends AppCompatActivity {
    private String p;
    private int n;

    @BindView(R.id.bigImage)
    ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_image_layout);
        ButterKnife.bind(SingleBigImage.this);
//        ImagesApiClient imagesApiClient = new ImagesApiClient(SingleBigImage.this);
//        imagesApiClient.images();
//        Intent i = new Intent();
        p = getIntent().getExtras().getString("Url");

       imagesBig();
    }

    public void imagesBig() {

//        n = Integer.parseInt(p);
        Picasso.with(this).
                load(p).
                into(mImageView);
    }



}
