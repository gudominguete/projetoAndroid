package com.login.gustavo.myapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.login.gustavo.myapplication.BuildConfig;
import com.login.gustavo.myapplication.Configuracao;
import com.login.gustavo.myapplication.R;
import com.login.gustavo.myapplication.model.MensagemRetorno;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroActivity extends AppCompatActivity {

    @BindView(R.id.et_usuario_cadastro)
    EditText etUsuarioCadastro;

    @BindView(R.id.et_senha_cadastro)
    EditText etSenhaCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ButterKnife.bind(this);
    }

    public void cadastrar(View view){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url =  BuildConfig.SERVER_URL + "/usuario/cadastro";
        StringRequest getRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);

                        MensagemRetorno mensagemRetorno = Configuracao.gson.fromJson(response, MensagemRetorno.class);

                        if(!mensagemRetorno.isSucesso()){
                            Toast.makeText(getApplicationContext(), mensagemRetorno.getMensagemErro(), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getBaseContext(), MainActivity.class);
                            startActivity(intent);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("Response error", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("usuario", etUsuarioCadastro.getText().toString());
                params.put("senha",  etSenhaCadastro.getText().toString());

                return params;
            }
        };


        queue.add(getRequest);

    }
}
