package com.login.gustavo.myapplication.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.login.gustavo.myapplication.Configuracao;
import com.login.gustavo.myapplication.model.MensagemRetorno;
import com.login.gustavo.myapplication.retrofit.UsuarioRetrofit;
import com.login.gustavo.myapplication.view.LogadoActivity;
import com.login.gustavo.myapplication.view.MainActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AutenticacaoPresenter {

    private Context context;

    public AutenticacaoPresenter(Context context) {
        this.context = context;
    }

    public void cadastrar(final String usuario, final String senha) {

        UsuarioRetrofit retrofit = Configuracao.createService();

        Call<ResponseBody> call = retrofit.cadastrarUsuario(usuario, senha);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                MensagemRetorno mensagemRetorno = null;
                try {
                    mensagemRetorno = Configuracao.gson.fromJson(response.body().string(), MensagemRetorno.class);

                    if(!mensagemRetorno.isSucesso()){
                        Toast.makeText(context, mensagemRetorno.getMensagemErro(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.e("Upload error:", t.getStackTrace().toString());
            }
        });

    }

    public void autenticar(final String usuario, final String senha){

        UsuarioRetrofit retrofit = Configuracao.createService();

        Call<ResponseBody> call = retrofit.autenticar(usuario, senha);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    MensagemRetorno mensagemRetorno = Configuracao.gson.fromJson(response.body().string(), MensagemRetorno.class);
                    if(!mensagemRetorno.isSucesso()){
                        Toast.makeText(context, mensagemRetorno.getMensagemErro(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context.getApplicationContext(), "Autenticação realizada com sucesso!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, LogadoActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.e("Upload error:", t.getStackTrace().toString());
            }
        });
    }



}
