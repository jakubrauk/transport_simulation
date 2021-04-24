package com.point;

import com.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class Point{
    int xCoordinate;
    int yCoordinate;
    protected String type;
    protected String typeOfPoint;
    protected List<Vehicle> listOfVehicles = new ArrayList<>();

    public String getType(){ return type; }
    public String getTypeOfPoint(){ return typeOfPoint; }

    public void randomizeLocation(){
        xCoordinate = 1;
        yCoordinate = 2;
    }

    public void putVehicle(Vehicle newVehicle) { this.listOfVehicles.add(newVehicle); }
    public void removeVehicle(Vehicle vehicleInstance) { this.listOfVehicles.remove(vehicleInstance); }

    public void displayVehicles() {
        for (Vehicle v : this.listOfVehicles) {
            System.out.println(v.getType());
        }
    }

    @Override
    public String toString(){ return "Point"; }
}



