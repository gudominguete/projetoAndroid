package com.login.gustavo.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.login.gustavo.myapplication.retrofit.UsuarioRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Configuracao {

    public static Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();

    public static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create());


    public static Retrofit retrofit = builder.build();

    public static UsuarioRetrofit createService() {

        retrofit = builder.build();

        return retrofit.create(UsuarioRetrofit.class);
    }

}
