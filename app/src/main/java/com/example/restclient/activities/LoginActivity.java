package com.example.restclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restclient.R;
import com.example.restclient.models.LoginResponse;
import com.example.restclient.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextLogin;
    private EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextLogin = findViewById(R.id.editTextViewLogin);
        editTextPassword = findViewById(R.id.editTextViewPassword);

        findViewById(R.id.buttonLogin).setOnClickListener(this);
        findViewById(R.id.textViewRegister).setOnClickListener(this);

    }

    private void userLogin() {
        String login = editTextLogin.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (login.isEmpty()) {
            editTextLogin.setError("Login required");
            editTextLogin.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextPassword.setError("Password should be atleast 6 character long");
            editTextPassword.requestFocus();
            return;
        }

        Call<LoginResponse>call = BeerApi.getmRetrofitClient().getApi().userLogin(login,password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if(!loginResponse.isError()){
                    //Toast.makeText(LoginActivity.this,loginResponse.getMessage(),Toast.LENGTH_LONG).show();
                    SharedPrefManager.getSharedPrefManager(LoginActivity.this).saveUser(loginResponse.getUser());

                }else {
                    Toast.makeText(LoginActivity.this,loginResponse.getMessage(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
               // userLogin();
                startActivity(new Intent(this,MenuViewActivity.class));
                break;
            case R.id.textViewRegister:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }

}
