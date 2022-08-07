package de.home_skrobanek.pre.flight.manager.controller;

import de.home_skrobanek.pre.flight.manager.PreFlightManager;
import de.home_skrobanek.pre.flight.manager.menuobject.MenuObject;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainController {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Pane headerPane;

    public void initialize(){
        MenuObject m = new MenuObject("Route-Manager", "Create your own routes\nand share them with other\nPilots.", "icons/world.png", new Runnable() {
            @Override
            public void run() {
                PreFlightManager.changeState(PreFlightManager.ProgramState.ROUTE_MENU);
            }
        });
        contentPane.getChildren().add(m.initialize());

        MenuObject m2 = new MenuObject("Pilot-Stats","Write down your flights\nand find additional\ninformation","", null);
        contentPane.getChildren().add(m2.initialize());

        MenuObject liveryInstaller = new MenuObject("Livery Installer","Installer for\nLiveries with some\nadditional information","", null);
        contentPane.getChildren().add(liveryInstaller.initialize());

        MenuObject.calculatePosition();
    }
}
