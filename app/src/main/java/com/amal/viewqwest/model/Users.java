package com.amal.viewqwest.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.amal.viewqwest.BR;
import com.amal.viewqwest.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AMAL on 2018-09-17.
 */

public class Users extends BaseObservable implements Serializable{
    @Bindable
    private String name;

    @Bindable
    private String image;

    @Bindable
    private List<String> items;

    public Users(String name, String image, List<String> items) {
        this.name = name;
        this.image = image;
        this.items = items;

        notifyPropertyChanged(BR.name);
        notifyPropertyChanged(BR.image);
        notifyPropertyChanged(BR.items);
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public List<String> getImageList() { return items; }

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(view);
    }

    @BindingAdapter("bind:photoImageUrl")
    public static void loadDetailsImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(RequestOptions.centerInsideTransform()
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(view);
    }

    /*
*
* Load failed for  http://loremflickr.com/800/800?random=12 with size [450x450]
                                                           class com.bumptech.glide.load.engine.GlideException: Failed to load resource
                                                           There was 1 cause:
                                                           java.io.FileNotFoundException(No content provider:  http://loremflickr.com/800/800?random=12)
                                                            call GlideException#logRootCauses(String) for more detail
                                                             Cause (1 of 1): class com.bumptech.glide.load.engine.GlideException: Fetching data failed, class android.content.res.AssetFileDescriptor, LOCAL
                                                           There was 1 cause:
                                                           java.io.FileNotFoundException(No content provider:  http://loremflickr.com/800/800?random=12)
                                                            call GlideException#logRootCauses(String) for more detail
                                                               Cause (1 of 1): class java.io.FileNotFoundException: No content provider:  http://loremflickr.com/800/800?random=12
*
* */
}
