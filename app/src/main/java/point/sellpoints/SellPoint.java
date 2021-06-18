package point.sellpoints;
import point.Point;
import vehicles.Vehicle;
import java.util.Random;
/**
 * This class holds information and functions that are specific to each sell point
 */
public abstract class SellPoint extends Point {

    protected Random r = new Random();

    public SellPoint() {
        this.typeOfPoint = "SellPoint";
        this.prizeOfProduct = r.nextInt(10 - 1) + 1;
    }

    /**
     * This function is for selling goods from the vehicle
     * @param v Vehicle that sells the resources
     */
    public void sell(Vehicle v) {
        if (v.getCurrentAmountOfGoods() > 0) {
            int sold_amount = v.sellAllGoods();
            v.increaseMoney(sold_amount * this.getPrizeOfProduct());
            System.out.println("SOLD AMOUNT: " + sold_amount);
        }
    }

    /**
     * This function checks that the vehicle is at a suitable sell point for itself, if so, it sells goods
     * @param v The vehicle for which the conformity is being checked
     */
    public void processVehicle(Vehicle v) {
        if (this.getType().equals(v.getAcceptedPointType())) {
            if (this.getTypeOfPoint().equals("SellPoint")) {
//                System.out.println("THIS IS A SELL POINT");
                v.increaseMoney(this.getPrizeOfProduct());
                this.sell(v);
            }
        }
    }
}
