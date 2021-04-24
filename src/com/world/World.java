package com.world;

import com.point.Point;
import com.point.harvestpoints.CarDealer;
import com.point.harvestpoints.Refinery;
import com.point.harvestpoints.Warehouse;
import com.point.harvestpoints.Woodshed;
import com.point.sellpoints.SellCarDealer;
import com.point.sellpoints.SellRefinery;
import com.point.sellpoints.SellWarehouse;
import com.point.sellpoints.SellWoodshed;
import com.userinput.UserInput;
import com.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class World {
    int worldSize;
    Point[][] pointsList;
    public World(int worldSize) {
        this.worldSize = worldSize;
        this.pointsList = new Point[this.worldSize][this.worldSize];
    }

    public Point getPoint(int x, int y) { return this.pointsList[x][y]; }

    public void placeVehicles() {
        // Randomly generating vehicle coords and putting it inside Points

    }


    public void generateWorld(UserInput input) {

        System.out.println("GENERATING WORLD");
        this.pointsList = new Point[this.worldSize][this.worldSize];
        this.pointsList[0][0] = new CarDealer(100);
        this.pointsList[0][1] = new Refinery(150);
        this.pointsList[0][2] = new Warehouse(150);
        this.pointsList[0][3] = new Woodshed(150);

        this.pointsList[1][0] = new SellCarDealer(150);
        this.pointsList[1][1] = new SellRefinery(150);
        this.pointsList[1][2] = new SellWarehouse(150);
        this.pointsList[1][3] = new SellWoodshed(150);

        this.placeVehicles();
    }

    public void checkWorldField(int x, int y) { System.out.println(this.pointsList[x][y]); }

    public List<Point> getAllPoints() {
        List<Point> listOfPoints = new ArrayList<>();
        for (int x = 0; x < this.worldSize; x++) {
            for (int y = 0; y < this.worldSize; y++) {
                if (this.pointsList[x][y] != null) {
//                    System.out.println("[" + x + "][" + y + "] " + this.pointsList[x][y]);
                    listOfPoints.add(this.pointsList[x][y]);
                }
            }
        }
        return listOfPoints;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> listOfVehicles = new ArrayList<>();
        for (Point p : this.getAllPoints()) {
            listOfVehicles.addAll(p.getListOfVehicles());
        }
        return listOfVehicles;
    }

    public void moveAllVehicles() {
        for (Vehicle v : this.getAllVehicles()) {
            v.moveVehicle();
        }
    }




}
