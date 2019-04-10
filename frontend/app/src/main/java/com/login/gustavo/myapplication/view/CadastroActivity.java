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
import com.login.gustavo.myapplication.presenter.AutenticacaoPresenter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CadastroActivity extends AppCompatActivity {

    @BindView(R.id.et_usuario_cadastro)
    EditText etUsuarioCadastro;

    @BindView(R.id.et_senha_cadastro)
    EditText etSenhaCadastro;

    private AutenticacaoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        this.presenter = new AutenticacaoPresenter(this.getApplicationContext());

        ButterKnife.bind(this);
    }

    public void cadastrar(View view){

        String usuario = etUsuarioCadastro.getText().toString();
        String senha = etSenhaCadastro.getText().toString();
        presenter.cadastrar(usuario,senha);

    }
}
