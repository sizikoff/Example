package com.apps.example.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("payload")
    @Expose
    private Object payload;

    public String getType() {
        return type;
    }

    public Object getPayload() {
        return payload;
    }

}
