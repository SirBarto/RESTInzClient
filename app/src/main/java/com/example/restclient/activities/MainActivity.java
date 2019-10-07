package com.example.restclient.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restclient.R;
import com.example.restclient.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail, editTextLogin, editTextPassword, editTextPassword2, editTextName, editTextLastName;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextViewEmail);
        editTextLogin = findViewById(R.id.editTextViewLogin);
        editTextPassword = findViewById(R.id.editTextViewPassword);
        editTextPassword2 = findViewById(R.id.editTextViewPassword2);
        editTextName = findViewById(R.id.editTextViewName);
        editTextLastName = findViewById(R.id.editTextViewLastName);

        findViewById(R.id.buttonSubmit).setOnClickListener(this);
        findViewById(R.id.textViewLogin).setOnClickListener(this);

    }

    private void userSignUp() {
        String email = editTextEmail.getText().toString().trim();
        String login = editTextLogin.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String password2 = editTextPassword2.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if (login.isEmpty()) {
            editTextLogin.setError("Login required");
            editTextLogin.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }else if (password.length() < 6) {
            editTextPassword.setError("Password should be atleast 6 character long");
            editTextPassword.requestFocus();
            return;
        }else if(!password.equals(password2))
        {
            editTextPassword2.setError("Password should be this same");
            editTextPassword2.requestFocus();
            return;
        }

        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return;
        }
        if (lastName.isEmpty()) {
            editTextLastName.setError("Lastname required");
            editTextLastName.requestFocus();
            return;
        }



        Call<DefaultResponse> call = BeerApi
                .getmRetrofitClient()
                .getApi()
                .createUser(email, login, password, name, lastName);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 201) {
                    DefaultResponse dr = response.body();
                    Toast.makeText(MainActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                } else if(response.code() == 422) {
                    Toast.makeText(MainActivity.this, "User already exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
/*
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                String s = null;

                try {
                    if (response.code() == 201) {

                        s = response.body().string();
                    } else {
                        s = response.errorBody().string();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (s != null) {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        Toast.makeText(MainActivity.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
*/
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSubmit:
                userSignUp();
                Toast.makeText(MainActivity.this, "Register sucessfull", Toast.LENGTH_LONG).show();
                //startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.textViewLogin:
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }
    }
}
