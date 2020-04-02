package com.example.eventapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   controllerManager ControllerManager;

   Button loginButton;

   TextView loginEmail;
   TextView loginPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ControllerManager = new controllerManager();

        ControllerManager.getSwitchViewController().setmA(this);
        ControllerManager.getSwitchViewController().showLogin();

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        loginEmail = findViewById(R.id.loginEmail);
        loginPsw = findViewById(R.id.loginPsw);
    }

    public void initiateComponents(){
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        loginEmail = findViewById(R.id.loginEmail);
        loginPsw = findViewById(R.id.loginPsw);
    }

    public controllerManager getControllerManager(){
        return ControllerManager;
    }

    public void callRegister(View v){
        ControllerManager.getSwitchViewController().showRegister();
    }

    public void login(){
        //Passwort prüfen

        //Prüfen ob es ein User oder ein Eventmanager ist

        //Korrektes Fenster aufrufen
        ControllerManager.getSwitchViewController().showUserLoggedIn();
    }

    public void onClick(View v){
        if(v.getId()==R.id.loginButton){
            System.out.println("pressed");
            login();
        }

    }

}
