package com.example.vivek.searchimages.Network.GettingImageNetwork;

import android.util.Log;

import com.example.vivek.searchimages.Activities.ImagesActivity;
import com.example.vivek.searchimages.BuildConfig;
import com.example.vivek.searchimages.Models.Model.ImagesModel.BaseModelClass;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vivek on 5/5/2018.
 */

public class ImagesApiClient {
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private ImagesResponse images;

    public ImagesApiClient(ImagesResponse images) {
        this.images = images;
    }

    public void images() {
        OkHttpClient.Builder okhttpbuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okhttpbuilder.addInterceptor(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpbuilder.build())
                .build();
        final Gson gson = new Gson();
        ImagesApiInterface imagesApiInterface = retrofit.create(ImagesApiInterface.class);
        Call<List<BaseModelClass>> call = imagesApiInterface.imagesInfo();
        call.enqueue(new Callback<List<BaseModelClass>>() {
            @Override
            public void onResponse(Call<List<BaseModelClass>> call, Response<List<BaseModelClass>> response) {
                Log.i("Response", gson.toJson(response.body()));
                if (response != null) {
                    images.onResponse(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<BaseModelClass>> call, Throwable t) {
            }
        });
    }

    public interface ImagesResponse {
        void onResponse(List<BaseModelClass> mBaseModelClass);
    }

}

