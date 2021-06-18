package vehicles;
/**
 * This class stores data related to the timber truck type of vehicle
 */
public class TimberTruck extends Vehicle {

    public TimberTruck() {
        this.maxAmountOfGoods = 53;
        this.transportCost = 20;
        this.type = "TimberTruck";
        this.acceptedPointType = "Woodshed";
    }
}
