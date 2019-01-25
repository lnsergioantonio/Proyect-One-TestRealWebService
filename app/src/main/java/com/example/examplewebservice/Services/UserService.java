package com.example.examplewebservice.Services;

import android.util.Log;
import android.util.Patterns;

import com.example.examplewebservice.Model.LoginBody;
import com.example.examplewebservice.Model.User;
import com.example.examplewebservice.Presenter.MainContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserService implements MainContract.UserInteractor {
    private String LOGTAG = "UserService";

    @Override
    public void login(String email, String password, final onFinishedListener onFinishedListener) {
        if(email.isEmpty())
            onFinishedListener.onFailure("Email está vacio");
        else if ( !Patterns.EMAIL_ADDRESS.matcher(email).matches() )
            onFinishedListener.onFailure("Email no valido");
        else if ( password.length()<6 )
            onFinishedListener.onFailure("Password no valido");
        else{
            IUserService userService = new Api().getClient().create(IUserService.class);
            Call<User> login = userService.loginWithEmail(new LoginBody(email,password));

            login.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    Log.i(LOGTAG,""+response.code());
                    switch (response.code()){
                        case 200:
                            onFinishedListener.onFinished();
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
}
