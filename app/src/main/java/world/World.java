package world;
import point.EmptyPoint.EmptyPoint;
import point.Point;
import point.harvestpoints.*;
import point.sellpoints.SellCarDealer;
import point.sellpoints.SellRefinery;
import point.sellpoints.SellWarehouse;
import point.sellpoints.SellWoodshed;
import userinput.UserInput;
import vehicles.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Class responsible for storing all Points and Vehicles. It generates the map with specified size (from UserInput)
 * Randomly places Vehicles and Points when world is generated.
 */
public class World {
    int worldSize;
    Point[][] pointsList;
    public World(int worldSize) {
        this.worldSize = worldSize;
        this.pointsList = new Point[this.worldSize][this.worldSize];
    }

    /**
     * Returns point on specified coordinates
     * @param x x coordinate of point
     * @param y y coordinate of point
     * @return Returns Point that is on this coordinates in Worlds pointslist
     */
    public Point getPoint(int x, int y) { return this.pointsList[x][y]; }

    /**
     * Append Points listOfVehicles with passed Vehicle instance
     * @param x point x coordinate
     * @param y point y coordinate
     * @param vehicle Vehicle instance that will be put on Point
     */
    public void putVehicleOnPoint(int x, int y, Vehicle vehicle) {
        this.pointsList[x][y].putVehicle(vehicle);
    }

    interface VehicleSupplier extends Supplier<Vehicle> {} // Supplier needed for storing list of Vehicle child classes
    /**
     * Randomly place All vehicles in Worlds pointsList
     * @param vehicleTypes VehicleSupplier - list of all Vehicle child classes
     * @param numberOfVehicles Number of vehicles, to be created
     */
    public void placeVehicles(VehicleSupplier[] vehicleTypes, int numberOfVehicles) {
        Random r = new Random(); // used for randomizing point coords
        for (int i = 0; i < numberOfVehicles; i++) {
            int randXcoords = r.nextInt(this.worldSize);
            int randYcoords = r.nextInt(this.worldSize);

            // Randomly choose vehicle type
            Vehicle randomVehicle = vehicleTypes[r.nextInt(vehicleTypes.length)].get();
            randomVehicle.setCoordinates(randXcoords, randYcoords);
            randomVehicle.setId(i+1);
            this.putVehicleOnPoint(randXcoords, randYcoords, randomVehicle);
        }
    }

    /**
     * Return all points in Worlds pointsList
     * @return Returns list of Points
     */
    public List<Point> getAllPoints() {
        List<Point> listOfPoints = new ArrayList<>();
        for (int x = 0; x < this.worldSize; x++) {
            for (int y = 0; y < this.worldSize; y++) {
                if (this.pointsList[x][y] != null) {
                    listOfPoints.add(this.pointsList[x][y]);
                }
            }
        }
        return listOfPoints;
    }

    /**
     * Places empty points in pointsList to fill empty gaps
     */
    public void placeEmptyPoints(){
        for (int x = 0; x < this.worldSize; x++) {
            for (int y = 0; y < this.worldSize; y++) {
                this.pointsList[x][y] = new EmptyPoint();
            }
        }
    }

    interface PointsSupplier extends Supplier<Point> {} // Supplier needed for storing list of Point child classes
    /**
     * Randomly places points on Worlds pointsList
     * @param points PointsSupplier[] - list of points class childs, either SellPoints or HarvestPoints
     * @param numberOfPoints Number of points to generate
     */
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

    /**
     * Generates world, randomly places Points and Vehicles
     * @param input UserInput instance
     */
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

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> listOfVehicles = new ArrayList<>();
        for (Point p : this.getAllPoints()) {
            listOfVehicles.addAll(p.getListOfVehicles());
        }
        return listOfVehicles;
    }

    /**
     * @return Returns sorted list of Vehicles in World instance.
     */
    public List<Vehicle> getSortedListOfVehicles() {
        List<Vehicle> listOfVehicles = this.getAllVehicles();
        listOfVehicles.sort(Comparator.comparing(Vehicle::getId));
        return listOfVehicles;
    }

    /**
     * Move all vehicles one point in random direction, if vehicle doesn't have enough money to move, it stays in the
     * same place.
     */
    public void moveAllVehicles() {
        for (Vehicle v : this.getAllVehicles()) {
            if (v.getMoney() >= v.getTransportCost()) {
                int x = v.getxCoordinate();
                int y = v.getyCoordinate();
                Point oldPoint = this.getPoint(x, y);
                int[] newCoords = v.moveVehicle(this.worldSize);
                oldPoint.removeVehicle(v);
                this.putVehicleOnPoint(newCoords[0], newCoords[1], v);
                v.appendFieldsMoved();
                Point newPoint = this.getPoint(newCoords[0], newCoords[1]);

                if (!(newPoint instanceof EmptyPoint)) {
                    newPoint.processVehicle(v);
                }
            }
        }
    }

    /**
     * Renew resources in all HarvestPoints in pointsList
     */
    public void gatherResourcesHarvestPoints() {
        for (Point p : this.getAllPoints()) {
            if (p instanceof HarvestPoint) {
                ((HarvestPoint) p).gatherResources();
            }
        }
    }
}
