package de.home_skrobanek.pre.flight.manager.menuobject;

import de.home_skrobanek.pre.flight.manager.controller.MenuObjectController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class MenuObject {

    private String title, description, imgSrc;
    private Runnable run;
    private static ArrayList<AnchorPane> list = new ArrayList<>();

    public MenuObject(String title, String description, String imgSrc, Runnable run){
        this.title = title;
        this.description = description;
        this.imgSrc = imgSrc;
        this.run = run;

    }

    public AnchorPane initialize(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            AnchorPane pane = fxmlLoader.load(getClass().getResource("/FXML/menuObject.fxml").openStream());
            MenuObjectController controller = (MenuObjectController) fxmlLoader.getController();

            list.add(pane);
            controller.title.setText(title);
            controller.description.setText(description);
            pane.setOnMouseClicked(event -> {
                run.run();
            });

            return pane;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void calculatePosition(){
        for(int i = 0; i < list.size(); i++){
            if(i == 0){
                list.get(i).setLayoutY(100);
                list.get(i).setLayoutX(15);
            }
            else {
                //calculation of the space between the menu objects
                int formX = (250 * i) + (15 * i)+15;
                list.get(i).setLayoutY(100);
                list.get(i).setLayoutX(formX);

            }
        }
    }
}
