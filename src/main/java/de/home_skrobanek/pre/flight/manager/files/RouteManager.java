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

        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewRoute(Route route){
        list.add(route);
    }

    public String convertToJson(){
        return gson.toJson(list);
    }

    public String convertToJson(ArrayList<Route> liste){
        return gson.toJson(liste);
    }

    public Route[] convertToList(String json){
        return gson.fromJson(json, Route[].class);
    }

    private void saveInFile(String json){
        try{
            FileWriter fw = new FileWriter(new File(filename));
            BufferedWriter bw = new BufferedWriter(fw);

            fw.write(json);

            bw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void saveInFile(ArrayList<Route> list){
        try{
            FileWriter fw = new FileWriter(new File(filename));
            BufferedWriter bw = new BufferedWriter(fw);

            fw.write(convertToJson(list));

            bw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public Route[] readFromFile(){
        try{
            FileReader fw = new FileReader(new File(filename));
            BufferedReader bw = new BufferedReader(fw);

            String lines = "", json = "";
            while((lines =bw.readLine()) != null) {
                json += lines;
            }
            bw.close();
            return convertToList(json);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void updateFile(Route route){
        ArrayList<Route> tmp = new ArrayList<>();
        Route[] arr = readFromFile();
        if(arr != null) {
            for (int i = 0; i < arr.length; i++) {
                tmp.add(arr[i]);
            }
            tmp.add(route);
        }
        else
            tmp.add(route);
        saveInFile(tmp);
    }
}
