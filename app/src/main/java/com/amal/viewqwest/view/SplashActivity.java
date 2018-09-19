package com.amal.viewqwest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.amal.viewqwest.QwestApp;
import com.amal.viewqwest.R;
import com.amal.viewqwest.model.ApiResponse;
import com.amal.viewqwest.model.Users;
import com.amal.viewqwest.presenter.Navigate;
import com.amal.viewqwest.server.ApiClient;
import com.amal.viewqwest.server.ApiInterface;
import com.amal.viewqwest.utility.Util;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Util.isOnline(this)) {
            callApi(10, 10);
        } else {
            Util.showAlert(SplashActivity.this, "Error", "No internet connection " +
                    "right now.");
        }

    }

    private void callApi(int offset, int limit) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiService.getUserDetails(offset, limit);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                int statusCode = response.code();

                Log.d("JSON", response.body().toString());
                System.out.println(response.body());

                if (statusCode == 200) {

                    boolean STATUS = Boolean.valueOf(response.body().getStatus());
                    String MESSAGE = response.body().getMessage();

                    if (STATUS) {
                        LinkedTreeMap datObj = response.body().getData();
                        QwestApp.USER_LIST = (ArrayList<Users>) datObj.get("users");

                        Navigate.navigateScreen(SplashActivity.this, new MainActivity());
                    } else {
                        Util.showAlert(SplashActivity.this, "No Data", MESSAGE);
                    }
                } else {
                    Util.showAlert(SplashActivity.this, "Error!", "Server Problem." +
                            " Please Try again later..!");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Util.showAlert(SplashActivity.this, "Sorry", t.getMessage());
            }
        });
    }
}
