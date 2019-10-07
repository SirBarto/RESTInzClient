package com.example.restclient.api;

import com.example.restclient.models.Beer;
import com.example.restclient.models.BeerResponse;
import com.example.restclient.models.DefaultResponse;
import com.example.restclient.models.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("user/add")
    Call<DefaultResponse> createUser(
            @Field("email") String email,
            @Field("login") String login,
            @Field("password") String password,
            @Field("name") String name,
            @Field("lastname") String lastName
    );

    @FormUrlEncoded
    @POST("user/login")
    Call<LoginResponse>userLogin(
            @Field("login") String login,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("beer/add")
    Call<DefaultResponse>addBeer(
            @Field("name") String name,
            @Field("factory") String factory,
            @Field("ibu") String ibu,
            @Field("abv") double abv,
            @Field("calorie") double calorie,
            @Field("style") String style,
            @Field("price") double price,
            @Field("details") String details
    );

    @FormUrlEncoded
    @PATCH("beer/update/{id}")
    Call<DefaultResponse>updateBeer(
            @Field("id") Long id,
            @Field("name") String name,
            @Field("factory") String factory,
            @Field("ibu") String ibu,
            @Field("abv") double abv,
            @Field("calorie") double calorie,
            @Field("style") String style,
            @Field("price") double price,
            @Field("details") String details
    );

    @GET("beer/all")
    Call<List<Beer>>getBeers();
}
