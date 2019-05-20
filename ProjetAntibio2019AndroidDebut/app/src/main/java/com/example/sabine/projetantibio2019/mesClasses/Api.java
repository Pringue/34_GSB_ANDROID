package com.example.sabine.projetantibio2019.mesClasses;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Api {
    private static Retrofit retrofit = null;
    public static ApiInterface getAPI() {
        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jpringue.000webhostapp.com/gsb/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        ApiInterface api = retrofit.create(ApiInterface.class);
        return api; // return the APIInterface object
    }
}