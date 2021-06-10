package point;

import point.harvestpoints.HarvestPoint;
import point.sellpoints.SellPoint;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

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

    public void putVehicle(Vehicle vehicle) { this.listOfVehicles.add(vehicle); }
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

    public void loadGoods(Vehicle v) {
        if (this instanceof HarvestPoint) {
            ((HarvestPoint) this).loading(v);
        }
    }

    public void sellGoods(Vehicle v) {
        if (this instanceof SellPoint) {
            ((SellPoint) this).sell(v);
        }
    }

    public void processVehicle(Vehicle v) {
        if (!(this.getTypeOfPoint().equals("Empty"))) {
            if (this.getType().equals(v.getAcceptedPointType())) {
                if (this.getTypeOfPoint().equals("HarvestPoint")) {
                    // for harvest point
//                    System.out.println("THIS IS A HARVEST POINT");
                    this.loadGoods(v);
                } else {
                    // for sell point
                    //10
//                    System.out.println("THIS IS A SELL POINT");
                    v.increaseMoney(this.getPrizeOfProduct());
                    this.sellGoods(v);
                }
            }
        }
    }

    public List<Vehicle> getListOfVehicles() {
        return this.listOfVehicles;
    }

    @Override
    public String toString(){ return "Point"; }
}



