package com.login.gustavo.myapplication.service;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.login.gustavo.myapplication.BuildConfig;
import com.login.gustavo.myapplication.model.Usuario;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioService {

    private static UsuarioService instance;

    public static UsuarioService getInstance() {
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }


    public boolean autenticar(String usuario, String senha){

        return true;
    }

}
