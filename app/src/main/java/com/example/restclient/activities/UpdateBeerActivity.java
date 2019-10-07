package com.example.restclient.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restclient.R;
import com.example.restclient.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateBeerActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextIdBeer,editTextBeerName, editTextFactory, editTextIbu, editTextAbv, editTextCalorie, editTextDetails, editTextStyle, editTextPrice;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_beer);

        editTextIdBeer = findViewById(R.id.editTextViewIdBeer);
        editTextBeerName = findViewById(R.id.editTextViewNameBeer);
        editTextFactory = findViewById(R.id.editTextViewFactory);
        editTextIbu = findViewById(R.id.editTextViewIbu);
        editTextAbv = findViewById(R.id.editTextViewAbv);
        editTextCalorie = findViewById(R.id.editTextViewColories);
        editTextStyle = findViewById(R.id.editTextViewStyle);
        editTextDetails = findViewById(R.id.editTextViewDetails);
        editTextPrice = findViewById(R.id.editTextViewPrice);

        findViewById(R.id.buttonUpdate).setOnClickListener(this);
        findViewById(R.id.textViewBackToMenu).setOnClickListener(this);
    }

    private void beerUpdate() {
        Long id = Long.valueOf(editTextIdBeer.getText().toString().trim());
        String beerName = editTextBeerName.getText().toString().trim();
        String factory = editTextFactory.getText().toString().trim();
        String ibu = editTextIbu.getText().toString().trim();
        double abv = Double.parseDouble(editTextAbv.getText().toString().trim());
        double calorie = Double.parseDouble(editTextCalorie.getText().toString().trim());
        String style = editTextStyle.getText().toString().trim();
        double price = Double.parseDouble(editTextPrice.getText().toString().trim());
        String details = editTextDetails.getText().toString().trim();
        Call<DefaultResponse> call = BeerApi
                .getmRetrofitClient()
                .getApi()
                .updateBeer(id, beerName, factory, ibu, abv, calorie, style, price, details);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 201) {
                    DefaultResponse dr = response.body();
                    Toast.makeText(UpdateBeerActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                } else if (response.code() == 422) {
                    Toast.makeText(UpdateBeerActivity.this, "Beer already exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonUpdate: {
                beerUpdate();
                Toast.makeText(UpdateBeerActivity.this, "Update Beer sucessfull", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, ItemViewActivity.class));
                break;
            }
            case R.id.textViewBackToMenu: {
                startActivity(new Intent(this, MenuViewActivity.class));
                break;
            }
        }
    }
}
