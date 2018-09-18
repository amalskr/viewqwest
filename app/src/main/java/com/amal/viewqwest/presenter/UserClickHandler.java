package com.amal.viewqwest.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.amal.viewqwest.model.Users;
import com.amal.viewqwest.view.DetailsActivity;

/**
 * Created by AMAL on 2018-09-17.
 */

public class UserClickHandler {

    private final Context context;

    public UserClickHandler(Context context) {
        this.context = context;
    }

    public void onViewClick(View view, Users user) {
        Intent nextInt = new Intent(view.getContext(), DetailsActivity.class);
        nextInt.putExtra("SELECTED_USER",user);
        context.startActivity(nextInt);
    }
}
