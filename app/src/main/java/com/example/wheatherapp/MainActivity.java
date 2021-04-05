package com.example.wheatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wheatherapp.ViewModel.WheatherViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText searchcityedit;
    ImageView searchimage;
    String  abc;
    WheatherViewModel wheatherViewModel;
    TextView lat,longitude,humidity,deg,temp,speed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        wheatherViewModel= ViewModelProviders.of ( MainActivity.this ).get ( WheatherViewModel.class );
        searchcityedit=findViewById ( R.id.searchcity);
        searchimage=findViewById ( R.id.searchimage );
        lat=findViewById ( R.id.lattitude );
        longitude=findViewById ( R.id.longitude);
        humidity=findViewById ( R.id.humidity );
        deg=findViewById ( R.id.deg );
        temp=findViewById ( R.id.temp );
        speed=findViewById ( R.id.speed );

        



        searchimage.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                abc=searchcityedit.getText ().toString ();
                abc=abc.replace( " ", "");
                wheatherViewModel.getdata ( MainActivity.this,abc,"e3f47a5d86519ad538dc2636310cf1db" ).observe ( MainActivity.this, new Observer<WheatherModel> ( ) {
                    @Override
                    public void onChanged(WheatherModel wheatherModel) {
                        Toast.makeText ( MainActivity.this, "" + wheatherModel.getName ( ), Toast.LENGTH_SHORT ).show ( );
                        lat.setText ( "Lat:" + wheatherModel.getCoord ( ).getLat ( ) );
                        longitude.setText ( "Long:" + wheatherModel.getCoord ( ).getLon ( ) );
                        humidity.setText ( "Humidity:" + wheatherModel.getMain ( ).getHumidity ( ) );
                        deg.setText ( "Degree" + wheatherModel.getWind ( ).getDeg ( ) );
                        speed.setText ( "Speed" + wheatherModel.getWind ( ).getSpeed ( ) );
                        temp.setText ( "Temp" + wheatherModel.getMain ( ).getTemp ( ) );


                    }
                });

            }
        } );
    }
}