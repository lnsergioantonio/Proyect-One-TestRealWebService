package com.example.examplewebservice.data.api;

import com.example.examplewebservice.data.api.model.LoginBody;
import com.example.examplewebservice.data.database.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {
    @POST("login")
    Call<User> loginWithEmail(@Body LoginBody loginBody);

    @GET("users")
    Call<ResponseBody> listUsers(@Query("page") Integer page);
}
