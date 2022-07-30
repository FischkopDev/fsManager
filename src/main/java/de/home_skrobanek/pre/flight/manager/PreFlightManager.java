package de.home_skrobanek.pre.flight.manager;

import de.home_skrobanek.pre.flight.manager.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PreFlightManager extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/main.fxml"));
        Parent content = loader.load();

        Scene scene = new Scene(content, 900, 500);


        //stage properties
        stage.setWidth(900);
        stage.setHeight(800);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("Pre Flight Manager");
        stage.show();
    }

    public static void main(String[]args){
        launch(args);
    }
}
