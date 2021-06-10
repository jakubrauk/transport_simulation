package vehicles;

public class Lorry extends Vehicle {

    public Lorry() {
        this.maxAmountOfGoods = 100;
        this.transportCost = 15;
        this.type = "Lorry";
        this.acceptedPointType = "Warehouse";
    }
}
