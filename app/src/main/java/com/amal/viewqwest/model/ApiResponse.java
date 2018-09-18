package com.amal.viewqwest.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import org.json.JSONObject;

/**
 * Created by AMAL on 2018-09-17.
 */

public class ApiResponse {

    @SerializedName("status")
    private final String status;

    @SerializedName("message")
    private final String message;

    @SerializedName("data")
    private final LinkedTreeMap data;

    public ApiResponse(String server_status, String server_message, LinkedTreeMap dataMap) {
        this.status = server_status;
        this.message = server_message;
        this.data = dataMap;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LinkedTreeMap getData() {
        return data;
    }

    /*public List<Users> getResults() {
        return data;
    }*/
}
