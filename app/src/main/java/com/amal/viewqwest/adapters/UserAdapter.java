package com.amal.viewqwest.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.amal.viewqwest.R;
import com.amal.viewqwest.databinding.UserRowItemBinding;
import com.amal.viewqwest.model.Users;
import com.amal.viewqwest.presenter.UserClickHandler;
import com.google.gson.internal.LinkedTreeMap;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AMAL on 2018-09-17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<Users> usersList;
    private Context context;

    public UserAdapter(Context ctx, ArrayList<Users> dataList) {
        this.context = ctx;
        this.usersList = dataList;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        UserRowItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.user_row_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Object getrow = this.usersList.get(position);
        LinkedTreeMap ltMap = (LinkedTreeMap) getrow;

        String image = ltMap.get("image").toString();
        String name = ltMap.get("name").toString();
        String dataSet[] = ltMap.get("items").toString().replace("[","")
                .replace("]","").split(",");
        List<String> imageList = Arrays.asList(dataSet);

        Users users = new Users(name, image, imageList);
        holder.userItemBinding.setUser(users);
        holder.userItemBinding.setHandler(new UserClickHandler(context));
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        UserRowItemBinding userItemBinding;

        ViewHolder(UserRowItemBinding userItemBindingData) {
            super(userItemBindingData.getRoot());
            userItemBinding = userItemBindingData;
        }
    }
}
