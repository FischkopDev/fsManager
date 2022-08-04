package de.home_skrobanek.pre.flight.manager.controller;

import de.home_skrobanek.pre.flight.manager.PreFlightManager;
import de.home_skrobanek.pre.flight.manager.files.RouteManager;
import de.home_skrobanek.pre.flight.manager.route.Route;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class RouteController {

    @FXML
    private Button backButton;

    @FXML
    private TableView routes;

    private RouteManager manager;

    public void initialize(){
        manager = new RouteManager();

        initList();

        Route[] routes = manager.readFromFile();
        if(routes != null) {
            for (Route route : routes) {
                addItemToList(route);
            }
        }
    }

    @FXML
    protected void onCreateRoute(){
        PreFlightManager.changeState(PreFlightManager.ProgramState.ROUTE_CREATOR_MENU);
    }

    @FXML
    protected void onBack(){
        PreFlightManager.changeState(PreFlightManager.ProgramState.MAIN_MENU);
    }

    @FXML
    protected void onSearchRoute(){
        Route[] routes = manager.readFromFile();
        if(routes != null) {
            for (Route route : routes) {
                addItemToList(route);
            }
        }
    }

    public static Route route;

    @FXML
    protected void onRouteSelected(MouseEvent event){
        if(event.getClickCount() == 2) {
            route = (Route)routes.getSelectionModel().getSelectedCells().get(0);
            PreFlightManager.changeState(PreFlightManager.ProgramState.ROUTE_DETAILS);
        }
    }

    TableColumn<Route, String> column1, column2, column3, column4,column5, column6, column7,column8, column9;
    private void initList(){
        column1 = new TableColumn<>("Departure");
        column2 = new TableColumn<>("Arrival");
        column3 = new TableColumn<>("Flightrules");
        column4 = new TableColumn<>("Cycle");
        column5 = new TableColumn<>("Aircraft");
        column6 = new TableColumn<>("last Flight ");
        column7 = new TableColumn<>("Description");
        column8 = new TableColumn<>("Waypoints / Airways");
        column9 = new TableColumn<>("Rating");

        column1.setCellValueFactory(new PropertyValueFactory<>("dep"));
        column2.setCellValueFactory(new PropertyValueFactory<>("arr"));
        column3.setCellValueFactory(new PropertyValueFactory<>("flightrules"));
        column4.setCellValueFactory(new PropertyValueFactory<>("cycle"));
        column5.setCellValueFactory(new PropertyValueFactory<>("aircraft"));
        column6.setCellValueFactory(new PropertyValueFactory<>("lastFlight"));
        column7.setCellValueFactory(new PropertyValueFactory<>("description"));
        column8.setCellValueFactory(new PropertyValueFactory<>("wayPoints"));
        column9.setCellValueFactory(new PropertyValueFactory<>("rating"));
        //column1.setPrefWidth(ClientApplication.layout.readDoubleProperty("productionCustomer"));

        routes.getColumns().add(column1);
        routes.getColumns().add(column2);
        routes.getColumns().add(column3);
        routes.getColumns().add(column4);
        routes.getColumns().add(column5);
        routes.getColumns().add(column6);
        routes.getColumns().add(column7);
        routes.getColumns().add(column8);
        routes.getColumns().add(column9);
    }
    private void addItemToList(Route item){
        routes.getItems().add(item);
    }
}
