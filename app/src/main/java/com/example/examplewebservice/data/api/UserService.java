package com.example.examplewebservice.data.api;

import com.example.examplewebservice.data.api.model.LoginBody;
import com.example.examplewebservice.data.database.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("login")
    Call<User> loginWithEmail(@Body LoginBody loginBody);

}
