package com.example.vivek.searchimages.Models.Model.ImagesModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivek on 5/5/2018.
 */

public class BaseModelClass {


    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("url")
    @Expose
    private String imageUrl;

    @SerializedName("thumbnailUrl")
    @Expose
    private String imagesThumbnailUrl;

    public String getTitle() {return title;}

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImagesThumbnailUrl() {
        return imagesThumbnailUrl;
    }


}
