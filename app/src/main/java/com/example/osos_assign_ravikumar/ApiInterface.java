package com.example.osos_assign_ravikumar;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("users")
    Call<List<ModelCard>> getposts();

}
