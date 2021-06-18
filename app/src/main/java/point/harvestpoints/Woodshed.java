package point.harvestpoints;
import java.util.Random;
/**
 * This class store the data of Woodshed point on the map
 */
public class Woodshed extends HarvestPoint {

    public Woodshed(){
        this.amountOfGoods = new Random().nextInt(150);
        this.type = "Woodshed";
    }

}
