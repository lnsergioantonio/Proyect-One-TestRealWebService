package com.example.examplewebservice.Services;

import com.example.examplewebservice.Model.LoginBody;
import com.example.examplewebservice.Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUserService {
    @POST("login")
    Call<User> loginWithEmail(@Body LoginBody loginBody);

}
