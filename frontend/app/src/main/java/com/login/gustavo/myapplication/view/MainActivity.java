package com.login.gustavo.myapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
import com.login.gustavo.myapplication.BuildConfig;
import com.login.gustavo.myapplication.Configuracao;
import com.login.gustavo.myapplication.R;
import com.login.gustavo.myapplication.model.MensagemRetorno;
import com.login.gustavo.myapplication.presenter.AutenticacaoPresenter;
import com.login.gustavo.myapplication.retrofit.UsuarioRetrofit;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_usuario)
    EditText etUsuario;

    @BindView(R.id.et_senha)
    EditText etSenha;

    private AutenticacaoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        this.presenter = new AutenticacaoPresenter(this.getApplicationContext());

    }

    public void login(View view){
        String usuario = etUsuario.getText().toString();
        String senha = etSenha.getText().toString();
        presenter.autenticar(usuario,senha);

    }

    public void cadsastroUsuario(View view) {
        Intent intent = new Intent(getBaseContext(), CadastroActivity.class);
        startActivity(intent);
    }
}
