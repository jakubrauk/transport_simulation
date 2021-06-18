package vehicles;
/**
 * This class stores data related to the tow truck type of vehicle
 */
public class TowTruck extends Vehicle {

    public TowTruck() {
        this.maxAmountOfGoods = 44;
        this.transportCost = 10;
        this.type = "TowTruck";
        this.acceptedPointType = "CarDealer";
    }
}
