package com.example.eventapp;

public class controllerManager {
    private SwitchViewController switchViewController;
    private registerController RegisterController;
    private userController UserController;
    private userSettingsController UserSettingsController;

    public controllerManager(){
        switchViewController = new SwitchViewController();
        RegisterController = new registerController();
        UserController = new userController();
        UserSettingsController = new userSettingsController();
    }

    public SwitchViewController getSwitchViewController(){
        return switchViewController;
    }

    public registerController getRegisterController(){
        return RegisterController;
    }

    public userController getUserController() {
        return UserController;
    }

    public userSettingsController getUserSettingsController(){
        return UserSettingsController;
    }
}
