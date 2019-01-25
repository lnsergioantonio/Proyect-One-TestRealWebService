package com.example.examplewebservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examplewebservice.Components.ProgressDialog;
import com.example.examplewebservice.Presenter.MainContract;
import com.example.examplewebservice.Presenter.LoginPresenter;
import com.example.examplewebservice.View.HomeActivity;
import com.example.examplewebservice.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;
    private MainContract.Presenter loginPresenter;
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
        loginPresenter = new LoginPresenter(this);
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
