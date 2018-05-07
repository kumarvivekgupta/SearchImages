package com.example.vivek.searchimages.Network.GettingImageNetwork;

import com.example.vivek.searchimages.Models.Model.ImagesModel.BaseModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vivek on 5/5/2018.
 */

public interface ImagesApiInterface {

    @GET("/photos/")
    Call<List<BaseModelClass>> imagesInfo();

}
