package com.example.wheatherapp.Api;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseUrl {
    private  static Retrofit retrofit;
    private static  String url="http://api.openweathermap.org/data/2.5/";


    public  static Retrofit getRetrofit(){
        Gson gson=new Gson ();

        retrofit=new Retrofit.Builder ().baseUrl ( url ).addConverterFactory ( GsonConverterFactory.create (gson) ).build ();

        return retrofit;
    }
}
