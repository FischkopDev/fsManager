package de.home_skrobanek.pre.flight.manager.controller;

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
        MenuObject m = new MenuObject("Route-Manager", "Create your own routes\nand share them with other\nPilots.", "", new Runnable() {
            @Override
            public void run() {

            }
        });
        contentPane.getChildren().add(m.initialize());

        MenuObject m2 = new MenuObject("","","", null);
        contentPane.getChildren().add(m2.initialize());

        MenuObject m3 = new MenuObject("","","", null);
        contentPane.getChildren().add(m3.initialize());

        MenuObject.calculatePosition();
    }
}
