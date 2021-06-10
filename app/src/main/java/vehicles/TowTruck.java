package vehicles;

public class TowTruck extends Vehicle {

    public TowTruck() {
        this.maxAmountOfGoods = 44;
        this.transportCost = 10;
        this.type = "TowTruck";
        this.acceptedPointType = "CarDealer";
    }
}
