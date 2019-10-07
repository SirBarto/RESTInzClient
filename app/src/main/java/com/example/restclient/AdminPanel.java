package com.example.restclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.restclient.activities.AddBeerActivity;
import com.example.restclient.activities.AddComentViewActivity;
import com.example.restclient.activities.ItemViewActivity;
import com.example.restclient.activities.MenuViewActivity;
import com.example.restclient.activities.UpdateBeerActivity;

public class AdminPanel extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        findViewById(R.id.textViewAddBeer).setOnClickListener(this);
        findViewById(R.id.textViewUpdateBeer).setOnClickListener(this);
        findViewById(R.id.textViewCommentBeer).setOnClickListener(this);
        findViewById(R.id.textViewBackToMenu).setOnClickListener(this);
        findViewById(R.id.textViewItem).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewAddBeer:
                startActivity(new Intent(this, AddBeerActivity.class));
                break;
            case R.id.textViewBackToMenu:
                startActivity(new Intent(this, MenuViewActivity.class));
                break;
            case R.id.textViewUpdateBeer:
                startActivity(new Intent(this, UpdateBeerActivity.class));
                break;
            case R.id.textViewCommentBeer:
                startActivity(new Intent(this, AddComentViewActivity.class));
                break;
            case R.id.textViewItem:
                startActivity(new Intent(this, ItemViewActivity.class));
                break;
        }
    }
}
