package vehicles;

public class Tanker extends Vehicle{

    public Tanker(int maxAmountOfGoods) {
        this.maxAmountOfGoods = maxAmountOfGoods;
        this.transportCost = 15;
        this.type = "Tanker";
    }
}
