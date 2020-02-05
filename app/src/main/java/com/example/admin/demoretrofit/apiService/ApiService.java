package com.example.admin.demoretrofit.apiService;

import com.example.admin.demoretrofit.ListActivity;
import com.example.admin.demoretrofit.Model.Response;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;


public interface ApiService  {
    @GET("users")
    Call<List<Response>> userData();
}
