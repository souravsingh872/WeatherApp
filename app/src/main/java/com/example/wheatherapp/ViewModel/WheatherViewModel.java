package com.example.wheatherapp.ViewModel;

import android.app.Activity;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wheatherapp.Api.BaseUrl;
import com.example.wheatherapp.WheatherInterface;
import com.example.wheatherapp.WheatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WheatherViewModel extends ViewModel {
    WheatherInterface wheatherInterface= BaseUrl.getRetrofit ().create ( WheatherInterface.class );
    private  MutableLiveData<WheatherModel> getwheather;


    public  LiveData<WheatherModel> getdata(Activity activity,String searchcity,String appid ){
         getwheather=new MutableLiveData<> (  );
         wheatherInterface.data (searchcity,appid  ).enqueue ( new Callback<WheatherModel> ( ) {
             @Override
             public void onResponse(Call<WheatherModel> call, Response<WheatherModel> response) {
                 if (response.body ()!=null) {
                     getwheather.postValue ( response.body ( ) );
                 }
                 else {
                     Toast.makeText ( activity, "Body  null", Toast.LENGTH_SHORT ).show ( );
                 }
             }

             @Override
             public void onFailure(Call<WheatherModel> call, Throwable t) {
                 Toast.makeText ( activity,t.getMessage (),Toast.LENGTH_SHORT ).show ();
             }
         } );





        return getwheather;
    }

}
