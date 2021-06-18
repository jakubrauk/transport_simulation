package vehicles;
/**
 * This class stores data related to the lorry type of vehicle
 */
public class Lorry extends Vehicle {

    public Lorry() {
        this.maxAmountOfGoods = 100;
        this.transportCost = 15;
        this.type = "Lorry";
        this.acceptedPointType = "Warehouse";
    }
}
