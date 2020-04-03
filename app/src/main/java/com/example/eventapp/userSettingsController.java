package com.example.eventapp;

import android.view.View;
import android.widget.Button;

public class userSettingsController implements View.OnClickListener {
    private MainActivity mA;

    private Button logoutBtn;

    public void setmA(MainActivity mA){
        this.mA = mA;
    }

    public void prepareComponents(){
        logoutBtn = mA.findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId()==R.id.logoutBtn){
           logout();
        }
    }

    private void logout(){
       mA.getControllerManager().getSwitchViewController().showLogin();
    }
}
