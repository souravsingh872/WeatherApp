package com.example.wheatherapp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WheatherInterface {

    @POST("weather")
    Call<WheatherModel> data(@Query ("q" )String searchcity,
                             @Query ( "appid" ) String key);
}
