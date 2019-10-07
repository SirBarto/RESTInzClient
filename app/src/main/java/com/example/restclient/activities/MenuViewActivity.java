package com.example.restclient.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.restclient.AdminPanel;
import com.example.restclient.R;
import com.example.restclient.StaticActivity;

public class MenuViewActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);

        findViewById(R.id.textViewPrzegladaj).setOnClickListener(this);
        findViewById(R.id.textViewWyszukaj).setOnClickListener(this);
        findViewById(R.id.textViewMojeUlubione).setOnClickListener(this);

        findViewById(R.id.textViewInfo).setOnClickListener(this);
        findViewById(R.id.textViewAboutApp).setOnClickListener(this);
        findViewById(R.id.textViewStatic).setOnClickListener(this);

        findViewById(R.id.textViewLogout).setOnClickListener(this);
        findViewById(R.id.textViewAdminPanel).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewPrzegladaj:
                startActivity(new Intent(this, FullListViewActivity.class));
                break;
            case R.id.textViewWyszukaj:
                startActivity(new Intent(this, SearchViewActivity.class));
                break;
            case R.id.textViewMojeUlubione:
                startActivity(new Intent(this, MyListViewActivity.class));
                break;
            case R.id.textViewInfo:
                startActivity(new Intent(this, UpdateAccountViewActivity.class));
                break;
            case R.id.textViewAboutApp:
                startActivity(new Intent(this, AboutViewActivity.class));
                break;
            case R.id.textViewStatic:
                startActivity(new Intent(this, StaticActivity.class));
                break;
            case R.id.textViewLogout:
                Toast.makeText(MenuViewActivity.this,"Log out",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.textViewAdminPanel:
                startActivity(new Intent(this, AdminPanel.class));
        }
    }
}
