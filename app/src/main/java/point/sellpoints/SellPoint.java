package point.sellpoints;

import point.Point;
import vehicles.Vehicle;

import java.util.Random;

public abstract class SellPoint extends Point {

    protected Random r = new Random();
    public SellPoint(){
        this.typeOfPoint = "SellPoint";
        this.prizeOfProduct = r.nextInt(10 - 1) + 1;
    }

    public void sell(Vehicle v) {
        if (v.getCurrentAmountOfGoods() > 0) {
            int sold_amount = v.sellAllGoods();
            v.increaseMoney(sold_amount*this.getPrizeOfProduct());
            System.out.println("SOLD AMOUNT: " + sold_amount);
        }
    }
}
