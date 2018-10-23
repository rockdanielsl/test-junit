package com.example.demoJUnit.util;

import com.google.gson.GsonBuilder;

public class FunctionUtil {

    private static final String DATE_FORMAT = "YYYY-MM-dd HH:mm:ss";

    public static String getJson(Object object) {
        return new GsonBuilder().setDateFormat(DATE_FORMAT).serializeNulls().create().toJson(object);
    }

}
