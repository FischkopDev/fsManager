package de.home_skrobanek.pre.flight.manager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PreFlightManager extends Application {

    private static Stage stage;
    private static Scene scene, routeScene, routeCreatorScene;
    private static Parent content, contentRoute, routeCreator;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/main.fxml"));
        content = loader.load();

        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("/FXML/routefinder.fxml"));
        contentRoute = loader2.load();

        FXMLLoader loader3 = new FXMLLoader();
        loader3.setLocation(getClass().getResource("/FXML/routecreator.fxml"));
        routeCreator = loader3.load();

        scene = new Scene(content, 900, 500);
        routeScene = new Scene(contentRoute, 900, 500);
        routeCreatorScene = new Scene(routeCreator, 900, 500);

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

    public static void changeState(ProgramState state){
        switch(state){
            case MAIN_MENU:
                stage.setScene(scene);
                break;
            case PILOT_STATS_MENU:
                break;
            case ROUTE_CREATOR_MENU:
                stage.setScene(routeCreatorScene);
                break;
            case ROUTE_MENU:
                stage.setScene(routeScene);
                break;
        }
    }

    public enum ProgramState {
        MAIN_MENU,
        ROUTE_MENU,
        ROUTE_CREATOR_MENU,
        PILOT_STATS_MENU;
    }
}
