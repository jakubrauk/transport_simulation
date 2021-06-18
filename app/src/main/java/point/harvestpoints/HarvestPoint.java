package point.harvestpoints;
import point.Point;
import vehicles.Vehicle;
import java.util.Random;
/**
 * This class holds information and functions that are specific to each harvest point
 */

public abstract class HarvestPoint extends Point {

    protected int amountOfGoods;

    public HarvestPoint() {
        this.typeOfPoint = "HarvestPoint";
    }

    public int getAmountOfGoods() {
        return this.amountOfGoods;
    }

    /**
     *This function is responsible for loading goods into cars when staying at harvest point
     * @param v Vehicle instance that is loaded
     */
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

    /**
     *This function checks if the type of harvest point is suitable for a itself, if so, raw materials are loaded onto the vehicle
     * @param v Vehicle instance that is moving
     */
    public void processVehicle(Vehicle v) {
        if (this.getType().equals(v.getAcceptedPointType())) {
            if (this.getTypeOfPoint().equals("HarvestPoint")) {
                this.loading(v);
            }
        }
    }

    /**
     * This function adds a random amount to the vehicle budget with each iteration
     */
    public void gatherResources() {
        Random r = new Random();
        this.amountOfGoods += r.nextInt(20 - 10) + 10;
    }
}
