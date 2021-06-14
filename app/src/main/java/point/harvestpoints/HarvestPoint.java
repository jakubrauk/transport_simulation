package point.harvestpoints;

import point.Point;
import vehicles.Vehicle;

import java.util.Random;

public abstract class HarvestPoint extends Point {

    protected int amountOfGoods;

    public HarvestPoint() {
        this.typeOfPoint = "HarvestPoint";
    }

    public int getAmountOfGoods() {
        return this.amountOfGoods;
    }

    public void loading(Vehicle v) {
        if (this.getAmountOfGoods() > 0) {
            if (v.getCurrentAmountOfGoods() != v.getMaxAmountOfGoods()) {
                if (this.getAmountOfGoods() + v.getCurrentAmountOfGoods() <= v.getMaxAmountOfGoods()) {
                    v.increaseAmountOfGoods(this.getAmountOfGoods());
                    System.out.println("LOADED " + this.getAmountOfGoods());
                    this.amountOfGoods = 0;
                } else {
                    int amount = v.getMaxAmountOfGoods() - v.getCurrentAmountOfGoods();
                    v.increaseAmountOfGoods(amount);
                    System.out.println("LOADED " + amount);
                    this.amountOfGoods -= amount;
                }
            }
        }
    }

    public void processVehicle(Vehicle v) {
        if (this.getType().equals(v.getAcceptedPointType())) {
            if (this.getTypeOfPoint().equals("HarvestPoint")) {
//                System.out.println("THIS IS A HARVEST POINT");
                this.loading(v);
            }
        }
    }

    public void gatherResources() {
        Random r = new Random();
        this.amountOfGoods += r.nextInt(20 - 10) + 10;
    }
}
