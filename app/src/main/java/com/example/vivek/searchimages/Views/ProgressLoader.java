package com.example.vivek.searchimages.Views;

import android.content.Context;

import com.kaopiz.kprogresshud.KProgressHUD;

/**
 * Created by Vivek on 5/6/2018.
 */

public class ProgressLoader {
    private Context activity;
    KProgressHUD kProgressHUD;

    public ProgressLoader(Context activity) {
        this.activity = activity;
    }


    public void showLoader() {
        kProgressHUD = KProgressHUD.create(activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
    }

    public void dismissLoader() {
        kProgressHUD.dismiss();
    }

}
