package point;
import vehicles.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 * Point of specified type stores list of vehicles, and point coordinates.
 */
public abstract class Point{

    protected String type;
    protected String typeOfPoint;
    protected int prizeOfProduct;
    protected int xCoordinate;
    protected int yCoordinate;
    protected List<Vehicle> listOfVehicles = new ArrayList<>();

    public int getPrizeOfProduct(){
        return this.prizeOfProduct;
    }

    public String getType(){ return type; }
    public String getTypeOfPoint(){ return typeOfPoint; }

    /**
     * Puts vehicle instance in listOfVehicles
     * @param vehicle Vehicle instance
     */
    public void putVehicle(Vehicle vehicle) { this.listOfVehicles.add(vehicle); }

    /**
     * Removes vehicle instance from listOfVehicles
     * @param vehicleInstance Vehicle instance
     */
    public void removeVehicle(Vehicle vehicleInstance) { this.listOfVehicles.remove(vehicleInstance); }

    /**
     * Set initial coordinates of point
     * @param x x coordinate
     * @param y y coordinate
     */
    public void setCoordinates(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public void processVehicle(Vehicle v) {
    }

    public List<Vehicle> getListOfVehicles() {
        return this.listOfVehicles;
    }

    @Override
    public String toString(){ return "Point"; }
}



