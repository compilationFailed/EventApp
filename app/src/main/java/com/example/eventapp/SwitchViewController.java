package com.example.eventapp;

public class SwitchViewController {
    private MainActivity mA;

    public void setmA(MainActivity mA){
        this.mA = mA;
    }



    public void showLogin(){
        mA.setContentView(R.layout.login_view);
        mA.initiateComponents();
    }

    public void showRegister(){
        mA.getControllerManager().getRegisterController().setmA(mA);
        mA.setContentView(R.layout.register_view);
        mA.getControllerManager().getRegisterController().prepareComponents();
    }

    public void showUserLoggedIn(){
        mA.getControllerManager().getUserController().setmA(mA);
        mA.setContentView(R.layout.user_ui_root);
        mA.getControllerManager().getUserController().prepareComponents();
        mA.getControllerManager().getUserController().showPartys();
    }


}
