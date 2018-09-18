package com.amal.viewqwest.utility;

/**
 * Created by AMAL on 2018-09-17.
 */

public class Constant {

    static {
        System.loadLibrary("native-lib");
    }

    public static native String baseUrl();

    public final static String BASE_URL = baseUrl();

}
