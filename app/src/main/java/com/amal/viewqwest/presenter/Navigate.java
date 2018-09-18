package com.amal.viewqwest.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by AMAL on 2018-09-17.
 */

public class Navigate {


    public static void navigateScreen(Activity activity, Activity NavActivity) {
        Intent nextInt = new Intent(activity, NavActivity.getClass());
        activity.startActivity(nextInt);
        activity.finish();
    }
}
