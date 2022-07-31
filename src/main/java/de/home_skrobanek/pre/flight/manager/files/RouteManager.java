package de.home_skrobanek.pre.flight.manager.files;

import com.google.gson.Gson;
import de.home_skrobanek.pre.flight.manager.route.Route;

import java.io.*;
import java.util.ArrayList;

public class RouteManager {

    private Gson gson;
    private ArrayList<Route> list;
    private static String filename = "user/routes.json";

    public RouteManager(){
        gson = new Gson();
        list = new ArrayList<>();
    }

    public void addNewRoute(Route route){
        list.add(route);
    }

    public String convertToJson(){
        return gson.toJson(list);
    }

    public Route[] convertToList(String json){
        return gson.fromJson(json, Route[].class);
    }

    public void saveInFile(String json){
        try{
            FileWriter fw = new FileWriter(new File(filename));
            BufferedWriter bw = new BufferedWriter(fw);

            fw.write(json);

            bw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public String readFromFile(){
        try{
            FileReader fw = new FileReader(new File(filename));
            BufferedReader bw = new BufferedReader(fw);

            String lines = "", json = "";
            while((lines =bw.readLine()) != null) {
                json += lines;
            }
            bw.close();
            return json;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
