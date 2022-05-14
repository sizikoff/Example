package com.apps.example.Retrofit;

import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    private static Retrofit ourInstance;

    public static Retrofit getInstance(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if(ourInstance == null)
            builder.addInterceptor(new OkHttpProfilerInterceptor());
        OkHttpClient client = builder.build();
            ourInstance = new Retrofit.Builder()
                    .baseUrl("http://demo7877231.mockable.io/api/v1/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        return ourInstance;
    }

    private RetrofitClient(){

    }
}
