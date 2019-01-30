package com.example.examplewebservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examplewebservice.components.ProgressDialog;
import com.example.examplewebservice.data.AppDataManager;
import com.example.examplewebservice.data.DataManager;
import com.example.examplewebservice.data.preferences.AuthPreferencesImpl;
import com.example.examplewebservice.view.base.SessionContract;
import com.example.examplewebservice.view.login.LoginPresenter;
import com.example.examplewebservice.data.api.UserServiceImpl;
import com.example.examplewebservice.view.home.HomeActivity;
import com.example.examplewebservice.view.login.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {
    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;
    private SessionContract.PresenterLogin loginPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(inputEmail.getText().toString(), inputPassword.getText().toString());
            }
        });
    }
    public void init(){
        btnLogin = findViewById(R.id.buttonLogin);
        inputEmail= findViewById(R.id.inputEmail);
        inputPassword= findViewById(R.id.inputPassword);

        AuthPreferencesImpl preferences = AuthPreferencesImpl.getSharedPreference(this,"MyAppMVP");
        DataManager dataManager = new AppDataManager(new UserServiceImpl(), preferences);

        loginPresenter = new LoginPresenter(this,dataManager);
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
