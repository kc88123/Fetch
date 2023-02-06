package com.example.fetch;
import retrofit2.http.GET;
import retrofit2.Call;
import java.util.List;

public interface Api {

    String BASE_URL = "https://fetch-hiring.s3.amazonaws.com/";
    @GET("hiring.json")
    Call<List<Results>> getsuperHeroes();
}
