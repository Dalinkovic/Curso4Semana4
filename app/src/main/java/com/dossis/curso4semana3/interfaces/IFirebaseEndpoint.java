package com.dossis.curso4semana3.interfaces;

import com.dossis.curso4semana3.pojo.UsuarioResponse;
import com.dossis.curso4semana3.restApi.KeysFirebaseRestAPI;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IFirebaseEndpoint {
    @FormUrlEncoded @POST(KeysFirebaseRestAPI.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("tokenFCM") String token, @Field ("idIG") String idIG);
}
