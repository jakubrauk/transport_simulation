package point.harvestpoints;
import java.util.Random;
/**
 * This class store the data of Warehouse point on the map
 */
public class Warehouse extends HarvestPoint {

    public Warehouse(){
        this.amountOfGoods = new Random().nextInt(150);
        this.type = "Warehouse";
    }

}
