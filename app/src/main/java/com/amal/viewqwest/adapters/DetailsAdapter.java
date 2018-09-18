package com.amal.viewqwest.adapters;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.amal.viewqwest.R;
import com.amal.viewqwest.databinding.PhotoRowItemBinding;
import com.amal.viewqwest.model.Users;

import java.util.List;

/**
 * Created by AMAL on 2018-09-17.
 */

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    private final int widthMetrics;
    private List<String> imageList;
    private Activity context;

    public DetailsAdapter(Activity ctx, List<String> imagesList) {
        this.context = ctx;
        this.imageList = imagesList;

        DisplayMetrics metrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        widthMetrics = metrics.widthPixels/2;
    }

    @Override
    public DetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PhotoRowItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.photo_row_item, parent, false);

        ViewHolder itemView = new ViewHolder(binding);
        /*itemView.itemView.getLayoutParams().width = widthMetrics;
        itemView.itemView.getLayoutParams().height = widthMetrics;*/
        return itemView;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String imageUrl = this.imageList.get(position);
        holder.photoRowItemBinding.setUser(new Users(null, imageUrl, null));
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        PhotoRowItemBinding photoRowItemBinding;

        ViewHolder(PhotoRowItemBinding binding) {
            super(binding.getRoot());
            photoRowItemBinding = binding;
        }
    }

}
