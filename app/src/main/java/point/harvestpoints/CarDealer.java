package point.harvestpoints;
import java.util.Random;
/**
 * This class store the data of car dealer point on the map
 */
public class CarDealer extends HarvestPoint {

    public CarDealer(){
        this.amountOfGoods = new Random().nextInt(150);
        this.type = "CarDealer";
    }
}
