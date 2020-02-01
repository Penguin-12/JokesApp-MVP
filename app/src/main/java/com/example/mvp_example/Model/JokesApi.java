package com.example.mvp_example.Model;


import retrofit2.Call;
import retrofit2.http.GET;

public interface JokesApi {

    String BASE_URl = "http://api.icndb.com/jokes/";

    @GET("random/30")
    Call<Joke> getJoke();

}
