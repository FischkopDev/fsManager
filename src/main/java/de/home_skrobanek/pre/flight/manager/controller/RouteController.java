package de.home_skrobanek.pre.flight.manager.controller;

import de.home_skrobanek.pre.flight.manager.PreFlightManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RouteController {

    @FXML
    private Button backButton;

    public void initialize(){

    }

    @FXML
    protected void onBack(){
        PreFlightManager.changeState(PreFlightManager.ProgramState.MAIN_MENU);
    }
}
