package com.example.osos_assign_ravikumar;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    private  static Retrofit retrofitInstance;
    private   static final String BASEURL="https://jsonplaceholder.typicode.com/";
    public static Retrofit getRetrofitInstance() {
        if(retrofitInstance==null)
        {
            retrofitInstance=new Retrofit.Builder()
                    .baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }

}
