package com.example.eventapp;

public class controllerManager {
    private SwitchViewController switchViewController;
    private registerController RegisterController;
    private userController UserController;
    private userSettingsController UserSettingsController;
    private userPartysController UserPartysController;

    public controllerManager(){
        switchViewController = new SwitchViewController();
        RegisterController = new registerController();
        UserController = new userController();
        UserSettingsController = new userSettingsController();
        UserPartysController = new userPartysController();
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

    public userPartysController getUserPartysController(){ return UserPartysController; }
}
