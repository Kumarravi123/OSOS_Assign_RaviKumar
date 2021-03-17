package com.example.osos_assign_ravikumar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    SupportMapFragment mapFragment;
    FrameLayout frame_map;
    RecyclerView recyclerView;
    AdapaterCard adapaterCard;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frame_map = findViewById(R.id.frame_map);
        recyclerView=findViewById(R.id.recycle_1);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(MainActivity.this);
        apiInterface=RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        apiInterface.getposts().enqueue(new Callback<List<ModelCard>>() {
            @Override
            public void onResponse(Call<List<ModelCard>> call, Response<List<ModelCard>> response) {
                if(response.body().size()>0)
                {
                    List<ModelCard>modelCardList=response.body();
                    adapaterCard=new AdapaterCard(MainActivity.this,modelCardList);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapaterCard);
                }
            }

            @Override
            public void onFailure(Call<List<ModelCard>> call, Throwable t) {

            }
        });




    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng hyderbad = new LatLng(27.2046 ,77.4977);
        googleMap.addMarker(new MarkerOptions()
                .position(hyderbad)
                );

        if (googleMap != null) {
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(hyderbad).zoom(18f).tilt(50).build();
            googleMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));
        }

    }
    }
