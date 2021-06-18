package point.harvestpoints;
import java.util.Random;
/**
 * This class store the data of Refinery point on the map
 */
public class Refinery extends HarvestPoint {

    public Refinery(){
        this.amountOfGoods = new Random().nextInt(150);
        this.type = "Refinery";
    }


}
