package com.example.examplewebservice.data.api;

import android.os.Handler;
import android.util.Log;
import android.util.Patterns;

import com.example.examplewebservice.data.api.model.LoginBody;
import com.example.examplewebservice.data.database.model.User;
import com.example.examplewebservice.view.base.SessionContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserServiceImpl implements SessionContract.UserInteractor{
    private String LOGTAG = "UserServiceImpl";

    @Override
    public void login(String email, String password, final onFinishedListener onFinishedListener) {
        if(email.isEmpty())
            onFinishedListener.onFailure("Email está vacio");
        else if ( !Patterns.EMAIL_ADDRESS.matcher(email).matches() )
            onFinishedListener.onFailure("Email no valido");
        else if ( password.length()<6 )
            onFinishedListener.onFailure("Password no valido");
        else{
            UserService userService = new Api().getClient().create(UserService.class);
            Call<User> login = userService.loginWithEmail(new LoginBody(email,password));

            login.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Log.i(LOGTAG,""+response.code());
                    switch (response.code()){
                        case 200:
                            onFinishedListener.onFinished(response.body().getToken());
                            break;
                        default:
                            onFinishedListener.onFailure(String.valueOf(response.code()));
                            break;
                    }
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Log.i(LOGTAG,"Failure" + t.getMessage());
                    onFinishedListener.onFailure("Failure" + t.getMessage());
                }
            });
        }
    }


    @Override
    public void logout(final onFinishedListenerLogout onFinishedListenerLogout) {
        //fake api logout
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onFinishedListenerLogout.onFinished();
            }
        },2500);

    }
}
