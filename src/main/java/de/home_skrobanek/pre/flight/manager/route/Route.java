package de.home_skrobanek.pre.flight.manager.route;

public class Route {

    private String dep, arr,flightrules, cycle, aircraft, lastFlight, description, wayPoints;
    private float rating = 0;
    private static final float ROUTE_VERSION = 1.0f; //for converting to newer versions

    public Route(String dep, String arr, String flightrules, String cycle, String aircraft, String lastFlight,
                 String description, String wayPoints, float rating) {
        this.dep = dep;
        this.arr = arr;
        this.flightrules = flightrules;
        this.cycle = cycle;
        this.aircraft = aircraft;
        this.lastFlight = lastFlight;
        this.description = description;
        this.wayPoints = wayPoints;
        this.rating = rating;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr;
    }

    public String getFlightrules() {
        return flightrules;
    }

    public void setFlightrules(String flightrules) {
        this.flightrules = flightrules;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(String lastFlight) {
        this.lastFlight = lastFlight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(String wayPoints) {
        this.wayPoints = wayPoints;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
