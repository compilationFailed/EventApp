package com.example.eventapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class userController implements View.OnClickListener {
    private MainActivity mA;

    private Button settingsButton;
    private Button partysButton;
    private Button reservationButton;

    private LinearLayout showviewLayout;

    public void setmA(MainActivity mA){
        this.mA = mA;
    }

    public void prepareComponents(){
        settingsButton = mA.findViewById(R.id.settingsButton);
        partysButton = mA.findViewById(R.id.partysButton);
        reservationButton = mA.findViewById(R.id.reservationButton);

        settingsButton.setOnClickListener(this);
        partysButton.setOnClickListener(this);
        reservationButton.setOnClickListener(this);

        showviewLayout = mA.findViewById(R.id.showviewLayout);
    }


    public void showSettings(){
        //Change Buttons
        focusSettings();
        //Add xml to Layout
        showviewLayout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(mA);
        View userRegisterLayout =  inflater.inflate(R.layout.user_settings, null);
        showviewLayout.addView(userRegisterLayout);
        //Settings View Controller vorbereiten
        mA.getControllerManager().getUserSettingsController().setmA(mA);
        mA.getControllerManager().getUserSettingsController().prepareComponents();
    }

    public void showPartys(){
        focusPartys();
        //Add xml to Layout
        showviewLayout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(mA);
        View userRegisterLayout =  inflater.inflate(R.layout.user_partys, null);
        showviewLayout.addView(userRegisterLayout);
        //Partys View Controller vorbereiten
        mA.getControllerManager().getUserPartysController().setmA(mA);
        mA.getControllerManager().getUserPartysController().prepareComponents();
    }

    public void showReservations(){
        focusReservations();
        //Add xml to Layout
        showviewLayout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(mA);
        View userRegisterLayout =  inflater.inflate(R.layout.user_reservations, null);
        showviewLayout.addView(userRegisterLayout);
    }

    public void focusSettings(){
        settingsButton.setBackgroundResource(R.drawable.buttonbar_button_active);
        partysButton.setBackgroundResource(R.drawable.buttonbar_button_passive);
        reservationButton.setBackgroundResource(R.drawable.buttonbar_button_passive);

        settingsButton.setTextColor(Color.WHITE);
        partysButton.setTextColor(Color.BLACK);
        reservationButton.setTextColor(Color.BLACK);
    }

    public void focusPartys(){
        partysButton.setBackgroundResource(R.drawable.buttonbar_button_active);
        settingsButton.setBackgroundResource(R.drawable.buttonbar_button_passive);
        reservationButton.setBackgroundResource(R.drawable.buttonbar_button_passive);

        partysButton.setTextColor(Color.WHITE);
        settingsButton.setTextColor(Color.BLACK);
        reservationButton.setTextColor(Color.BLACK);
    }

    public void focusReservations(){
        reservationButton.setBackgroundResource(R.drawable.buttonbar_button_active);
        partysButton.setBackgroundResource(R.drawable.buttonbar_button_passive);
        settingsButton.setBackgroundResource(R.drawable.buttonbar_button_passive);

        reservationButton.setTextColor(Color.WHITE);
        partysButton.setTextColor(Color.BLACK);
        settingsButton.setTextColor(Color.BLACK);
    }

    public void onClick(View v){
        if(v.getId()==R.id.settingsButton){
            showSettings();
        }
        if((v.getId() == R.id.partysButton)){
            showPartys();
        }
        if((v.getId() == R.id.reservationButton)){
            showReservations();
        }
    }
}
