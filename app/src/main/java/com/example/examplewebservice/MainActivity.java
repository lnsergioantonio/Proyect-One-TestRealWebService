package com.example.examplewebservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examplewebservice.components.ProgressDialog;
import com.example.examplewebservice.data.preferences.AuthPreferencesImpl;
import com.example.examplewebservice.presenter.LoginContract;
import com.example.examplewebservice.presenter.LoginPresenter;
import com.example.examplewebservice.data.api.UserServiceImpl;
import com.example.examplewebservice.view.HomeActivity;
import com.example.examplewebservice.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {
    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;
    private LoginContract.Presenter loginPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(inputEmail.getText().toString(), inputPassword.getText().toString());
            }
        });
    }
    public void bind(){
        btnLogin = findViewById(R.id.buttonLogin);
        inputEmail= findViewById(R.id.inputEmail);
        inputPassword= findViewById(R.id.inputPassword);
        AuthPreferencesImpl preferences = AuthPreferencesImpl.getSharedPreference(this,"MyAppMVP");
        loginPresenter = new LoginPresenter(this, new UserServiceImpl(), preferences);
        progressDialog = new ProgressDialog(this);
    }
    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
