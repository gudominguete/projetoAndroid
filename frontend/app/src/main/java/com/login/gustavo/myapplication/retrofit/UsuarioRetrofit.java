package com.login.gustavo.myapplication.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UsuarioRetrofit {

    @FormUrlEncoded
    @POST("/usuario/autenticar")
    Call<ResponseBody> autenticar(@Field("usuario") String usuario, @Field("senha") String senha);


    @FormUrlEncoded
    @POST("/usuario/cadastro")
    Call<ResponseBody> cadastrarUsuario(@Field("usuario") String usuario, @Field("senha") String senha);

}
