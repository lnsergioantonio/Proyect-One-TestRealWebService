package com.example.examplewebservice.Services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private Retrofit retrofit = null;
    private static final String API_URL_BASE = "https://reqres.in/api/";

    public Retrofit getClient(){

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
