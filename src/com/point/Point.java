package com.point;

import com.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class Point{

    protected String type;
    protected String typeOfPoint;
    protected int xCoordinate;
    protected int yCoordinate;
    protected List<Vehicle> listOfVehicles = new ArrayList<>();

    public String getType(){ return type; }
    public String getTypeOfPoint(){ return typeOfPoint; }

    public void putVehicle(Vehicle newVehicle) { this.listOfVehicles.add(newVehicle); }
    public void removeVehicle(Vehicle vehicleInstance) { this.listOfVehicles.remove(vehicleInstance); }

    public void displayVehicles() {
        for (Vehicle v : this.listOfVehicles) {
            System.out.println(v.getType());
        }
    }

    public void setCoordinates(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }
    public void getListOfRandomizedPoints(int worldSize){
        // returns 2 dimensional list of Points including HarvestPoints and
    }

    public List<Vehicle> getListOfVehicles() {
        return this.listOfVehicles;
    }

    @Override
    public String toString(){ return "Point"; }
}



