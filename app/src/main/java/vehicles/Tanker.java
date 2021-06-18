package vehicles;
/**
 * This class stores data related to the tanker type of vehicle
 */
public class Tanker extends Vehicle{

    public Tanker() {
        this.maxAmountOfGoods = 199;
        this.transportCost = 15;
        this.type = "Tanker";
        this.acceptedPointType = "Refinery";
    }
}
