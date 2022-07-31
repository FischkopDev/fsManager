package de.home_skrobanek.pre.flight.manager.controller;

import de.home_skrobanek.pre.flight.manager.PreFlightManager;
import javafx.fxml.FXML;

public class RouteCreatorController {

    @FXML
    protected void onBack(){
        PreFlightManager.changeState(PreFlightManager.ProgramState.ROUTE_MENU);
    }
}
