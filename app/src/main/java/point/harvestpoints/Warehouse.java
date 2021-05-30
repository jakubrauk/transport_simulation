package point.harvestpoints;

import java.util.Random;

public class Warehouse extends HarvestPoint {

    public Warehouse(){
        this.amountOfGoods = new Random().nextInt(150);
        this.type = "Warehouse";
    }

}
