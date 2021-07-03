package com.dossis.curso4semana4.interfaces;

import com.dossis.curso4semana4.restApi.Keys;
import com.dossis.curso4semana4.restApi.IGMediaResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface IIGApi {
    /*@GET("posts")
    Call<List<Post>> getPosts();*/
    @GET(Keys.URL_USER_MEDIA)
    Call<IGMediaResponse> getRecentMedia();
}
