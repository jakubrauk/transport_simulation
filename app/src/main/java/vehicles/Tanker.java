package vehicles;

public class Tanker extends Vehicle{

    public Tanker() {
        this.maxAmountOfGoods = 199;
        this.transportCost = 15;
        this.type = "Tanker";
        this.acceptedPointType = "Refinery";
    }
}
