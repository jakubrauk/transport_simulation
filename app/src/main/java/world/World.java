package world;

import point.EmptyPoint.EmptyPoint;
import point.Point;
import point.harvestpoints.CarDealer;
import point.harvestpoints.Refinery;
import point.harvestpoints.Warehouse;
import point.harvestpoints.Woodshed;
import point.sellpoints.SellCarDealer;
import point.sellpoints.SellRefinery;
import point.sellpoints.SellWarehouse;
import point.sellpoints.SellWoodshed;
import userinput.UserInput;
import vehicles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class World {
    int worldSize;
    Point[][] pointsList;
    public World(int worldSize) {
        this.worldSize = worldSize;
        this.pointsList = new Point[this.worldSize][this.worldSize];
    }

    public Point getPoint(int x, int y) { return this.pointsList[x][y]; }

    public void putVehicleOnPoint(int x, int y, Vehicle vehicle) {
        this.pointsList[x][y].putVehicle(vehicle);
    }

    interface VehicleSupplier extends Supplier<Vehicle> {} // Supplier needed for storing list of Vehicle child classes
    public void placeVehicles(VehicleSupplier[] vehicleTypes, int numberOfVehicles) {
        // Randomly generating vehicle coords and putting it inside Points
        Random r = new Random(); // used for randomizing point coords
        for (int i = 0; i < numberOfVehicles; i++) {
            int randXcoords = r.nextInt(this.worldSize);
            int randYcoords = r.nextInt(this.worldSize);

            // Randomly choose vehicle type
            Vehicle randomVehicle = vehicleTypes[r.nextInt(vehicleTypes.length)].get();
            this.putVehicleOnPoint(randXcoords, randYcoords, randomVehicle);
        }
    }

    public List<Point> getAllPoints() {
        List<Point> listOfPoints = new ArrayList<>();
        for (int x = 0; x < this.worldSize; x++) {
            for (int y = 0; y < this.worldSize; y++) {
                if (this.pointsList[x][y] != null) {
                    System.out.println("[" + x + "][" + y + "] " + this.pointsList[x][y].getTypeOfPoint() + " " + this.pointsList[x][y].getType());
                    System.out.println(this.pointsList[x][y].getListOfVehicles().size());
                    listOfPoints.add(this.pointsList[x][y]);
                }
            }
        }
        return listOfPoints;
    }

    public void placeEmptyPoints(){
        for (int x = 0; x < this.worldSize; x++) {
            for (int y = 0; y < this.worldSize; y++) {
                this.pointsList[x][y] = new EmptyPoint();
            }
        }
    }

    interface PointsSupplier extends Supplier<Point> {} // Supplier needed for storing list of Point child classes
    public void placePoints(PointsSupplier[] points, int numberOfPoints) {
        Random r = new Random(); // used for randomizing point coords
        // randomize points location on map
        for (int i = 0; i < numberOfPoints; i++) {
            int randXcoords = r.nextInt(this.worldSize);
            int randYcoords = r.nextInt(this.worldSize);
            while (!this.pointsList[randXcoords][randYcoords].getTypeOfPoint().equals("Empty")) {
                randXcoords = r.nextInt(this.worldSize);
                randYcoords = r.nextInt(this.worldSize);
            }
            // Randomly choose point type
            Point randomPoint = points[r.nextInt(points.length)].get();
            randomPoint.setCoordinates(randXcoords, randYcoords);
            this.pointsList[randXcoords][randYcoords] = randomPoint;
        }
    }

    public void generateWorld(UserInput input) {

        System.out.println("GENERATING WORLD");
        this.pointsList = new Point[this.worldSize][this.worldSize];
        this.placeEmptyPoints();
        PointsSupplier[] listOfHarvestPointsClasses = {CarDealer::new, Refinery::new, Warehouse::new, Woodshed::new};
        PointsSupplier[] listOfSellPointsClasses = {SellCarDealer::new, SellRefinery::new, SellWarehouse::new, SellWoodshed::new};
        VehicleSupplier[] listOfVehicleClasses = {Lorry::new, Tanker::new, TimberTruck::new, TowTruck::new};

        this.placePoints(listOfHarvestPointsClasses, input.getHarvestPointNumber());
        this.placePoints(listOfSellPointsClasses, input.getSellPointNumber());
        this.placeVehicles(listOfVehicleClasses, input.getVehicleNumber());
    }

    public void checkWorldField(int x, int y) { System.out.println(this.pointsList[x][y]); }

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
