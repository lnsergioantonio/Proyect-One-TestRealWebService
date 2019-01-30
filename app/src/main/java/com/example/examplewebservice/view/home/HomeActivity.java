package com.example.examplewebservice.view.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.examplewebservice.MainActivity;
import com.example.examplewebservice.R;
import com.example.examplewebservice.components.ProgressDialog;
import com.example.examplewebservice.data.AppDataManager;
import com.example.examplewebservice.data.DataManager;
import com.example.examplewebservice.data.api.UserServiceImpl;
import com.example.examplewebservice.data.preferences.AuthPreferencesImpl;
import com.example.examplewebservice.view.base.SessionContract;

public class HomeActivity extends AppCompatActivity implements HomeView {
    private Toolbar toolbar;
    private SessionContract.PresenterLogout presenter;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    }

    private void init(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressDialog = new ProgressDialog(this);

        AuthPreferencesImpl preferences = AuthPreferencesImpl.getSharedPreference(this,"MyAppMVP");
        DataManager dataManager = new AppDataManager(new UserServiceImpl(), preferences);
        presenter = new HomePresenter(this,dataManager);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.logOut){
            logOut();
        }
        return true;
    }

    @Override
    public void logOut() {
        presenter.LogOut();
    }

    @Override
    public void goToLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onResponse(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }
}
