package com.amal.viewqwest.server;

import com.amal.viewqwest.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by AMAL on 2018-09-17.
 */

public interface ApiInterface {

    @GET("users")
    Call<ApiResponse> getUserDetails(@Query("offset") int offset, @Query("limit") int limit);
}
