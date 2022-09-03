package de.home_skrobanek.pre.flight.manager.controller;

import de.home_skrobanek.pre.flight.manager.PreFlightManager;
import de.home_skrobanek.pre.flight.manager.route.Route;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class RouteDetailsController {

    @FXML
    private Label arrival, departure, cycle, flightrules;

    @FXML
    private TextArea airways;

    public static Route route;


    public void initialize(){
        if(route != null){

       }
        else
            System.err.println("Error while selecting a route");
    }

    @FXML
    protected void onBack(){
        PreFlightManager.changeState(PreFlightManager.ProgramState.ROUTE_MENU);
    }
}
