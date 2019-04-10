package com.login.gustavo.myapplication.presenter;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.login.gustavo.myapplication.BuildConfig;
import com.login.gustavo.myapplication.service.UsuarioService;

import java.util.HashMap;
import java.util.Map;

public class AutenticacaoPresenter {

    private UsuarioService usuarioService;
    private Context context;

    public AutenticacaoPresenter(Context context) {
        usuarioService = UsuarioService.getInstance();
        context = context;
    }

    public Boolean autenticar(final String usuario, final String senha){

        return true;
    }



}
