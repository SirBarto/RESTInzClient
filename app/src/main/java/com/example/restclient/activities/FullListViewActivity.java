package com.example.restclient.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.restclient.ListItem;
import com.example.restclient.R;
import com.example.restclient.api.Api;
import com.example.restclient.models.Beer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FullListViewActivity extends AppCompatActivity implements View.OnClickListener{

    private String url = "http://10.0.2.2:8080/demo/beer/all";

    private Retrofit retrofit;
    private ListView list;

    List<Beer> beerList = new ArrayList<>();
    private ArrayAdapter<Beer> beerArrayAdapter;

    private long id;
    private String name, factory, ibu, abv, calorie, style, price, details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_list_view);

        findViewById(R.id.textViewBackToMenu).setOnClickListener(this);

        list = findViewById(R.id.valuesList);
        beerArrayAdapter = new ArrayAdapter<Beer>(this,R.layout.listdefine,beerList);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewBackToMenu:
                startActivity(new Intent(this, MenuViewActivity.class));
                loadRecyclerViewData();
                break;
        }
    }

    private void loadRecyclerViewData() {
        String baseUrl = "http://10.0.2.2:8080/demo/";
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final Api api = retrofit.create(Api.class);
        Call<List<Beer>> call = api.getBeers();

        call.enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                List<Beer> beers = response.body();

                for(Beer beer : beers){
                    id = beer.getId();
                    name = beer.getName();
                    factory = beer.getFactory();
                    ibu = beer.getIbu();
                    abv = beer.getAbv();
                    calorie = beer.getCalorie();
                    style = beer.getStyle();
                    price = beer.getPrice();
                    details = beer.getDetails();

                    list.setAdapter(beerArrayAdapter);
                    beerList.add(new Beer(id,name,factory,ibu,abv,calorie,style,price,details));
                }
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {

            }
        });
    }
}
