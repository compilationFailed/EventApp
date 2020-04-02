package com.example.eventapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class registerController implements View.OnClickListener {
    private MainActivity mA;

    private Button userButton;
    private Button emButton;                //EM = Event Manager
    private Button registerBtn;

    private LinearLayout registerLayout;

    private Spinner genderSpinner;
    private Spinner ageSpinner;
    private Spinner partycitySpinner;

    private Spinner priceclassSpinner;

    public registerController(){
    // Wird beim Starten der Anwendung aufgerufen --> kann keine Elemente registrieren
    }

    public void prepareComponents(){
        userButton = mA.findViewById(R.id.userButton);
        emButton = mA.findViewById(R.id.emButton);
        registerBtn = mA.findViewById(R.id.registerBtn);

        registerLayout = (LinearLayout) mA.findViewById(R.id.registerLayout);
        userButton.setOnClickListener(this);
        emButton.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        //Zeig die Registriermaske für User an
        showUserRegister();
    }


    public void setmA(MainActivity mA){
        this.mA = mA;
    }

    public void showUserRegister(){
        //Change Buttonbackground
        userButton.setBackgroundResource(R.drawable.register_button_active_left);
        userButton.setTextColor(Color.WHITE);
        emButton.setBackgroundResource(R.drawable.register_button_passive_right);
        emButton.setTextColor(Color.BLACK);

        //Set LayoutXml
        registerLayout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(mA);
        View userRegisterLayout =  inflater.inflate(R.layout.user_register, null);
        registerLayout.addView(userRegisterLayout);
        fillUserRegisterDropdowns();

    }

    public void showEmRegister(){
        //Change Buttonbackground
        emButton.setBackgroundResource(R.drawable.register_button_active_right);
        emButton.setTextColor(Color.WHITE);
        userButton.setBackgroundResource(R.drawable.register_button_passive_left);
        userButton.setTextColor(Color.BLACK);

        //Set LayoutXml
        registerLayout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(mA);
        View emRegisterLayout =  inflater.inflate(R.layout.em_register, null);
        registerLayout.addView(emRegisterLayout);
        fillEmRegisterDropdowns();
    }


    private void fillUserRegisterDropdowns(){
        genderSpinner = mA.findViewById(R.id.genderDropdown);
        ageSpinner = mA.findViewById(R.id.ageDropdown);
        partycitySpinner = mA.findViewById(R.id.partycityDropdown);

        //Gender
        List<String> genderArray =  new ArrayList<String>();
        genderArray.add("Geschlecht wählen");
        genderArray.add("Mann");
        genderArray.add("Frau");

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(
                mA, android.R.layout.simple_spinner_item, genderArray);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        //Age
        List<String> ageArray =  new ArrayList<String>();
        ageArray.add("Alter wählen");
        ageArray.add("jünger als 16");
        ageArray.add("16 oder älter");
        ageArray.add("18 oder älter");

        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(
                mA, android.R.layout.simple_spinner_item, ageArray);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);


        //Partycity
        List<String> partycityArray =  new ArrayList<String>();
        partycityArray.add("Bevorzugte Partystadt wählen");
        partycityArray.add("Basel");
        partycityArray.add("Luzern");

        ArrayAdapter<String> partycityAdapter = new ArrayAdapter<String>(
                mA, android.R.layout.simple_spinner_item, partycityArray);
        partycityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        partycitySpinner.setAdapter(partycityAdapter);
    }

    private void fillEmRegisterDropdowns(){
        priceclassSpinner = mA.findViewById(R.id.priceclassDropdown);

        List<String> priceclassArray = new ArrayList<String>();
        priceclassArray.add("Preisklasse wählen");
        priceclassArray.add("$");
        priceclassArray.add("$$");
        priceclassArray.add("$$$");

        ArrayAdapter<String> priceclassAdapter = new ArrayAdapter<String>(
                mA, android.R.layout.simple_spinner_item, priceclassArray);
        priceclassAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        priceclassSpinner.setAdapter(priceclassAdapter);


    }

    public void onClick(View v){
        if(v.getId()==R.id.userButton){
            showUserRegister();
        }
        if(v.getId()==R.id.emButton){
            showEmRegister();
        }
        if(v.getId()==R.id.registerBtn){
            //Register and show login view
            mA.getControllerManager().getSwitchViewController().showLogin();
        }
    }

}
