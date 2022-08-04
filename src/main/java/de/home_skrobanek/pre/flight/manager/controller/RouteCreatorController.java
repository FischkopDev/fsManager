package de.home_skrobanek.pre.flight.manager.controller;

import de.home_skrobanek.pre.flight.manager.PreFlightManager;
import de.home_skrobanek.pre.flight.manager.files.RouteManager;
import de.home_skrobanek.pre.flight.manager.route.Route;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.event.MouseEvent;

public class RouteCreatorController {

    private RouteManager manager;

    @FXML
    private TextField departure, arrival, cycle, aircraft;

    @FXML
    private TextArea description, waypoints;

    @FXML
    private ComboBox flightrules;

    public void initialize(){
        manager = new RouteManager();

        flightrules.getItems().add("IFR");
        flightrules.getItems().add("VFR");

        flightrules.getSelectionModel().select(0);
    }

    @FXML
    protected void saveRoute(){
        manager.updateFile(new Route(departure.getText(), arrival.getText(),"",cycle.getText(),aircraft.getText(),
                "",description.getText(),waypoints.getText(),1.0f));

        PreFlightManager.changeState(PreFlightManager.ProgramState.ROUTE_MENU);
    }

    @FXML
    protected void onBack(){
        PreFlightManager.changeState(PreFlightManager.ProgramState.ROUTE_MENU);
    }
}
