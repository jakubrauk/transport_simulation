package vehicles;
import incomemanager.IncomeManager;
import java.util.Random;

/**
 * Class storing data of vehicles that are moving inside simulations World, every child of Vehicle has its own type.
 * acceptedPointType corresponds to points types that vehicle can cooperate with.
 */
public abstract class Vehicle {
    protected int id;
    protected Random randomMoneyGenerator = new Random();
    protected String type;
    protected String acceptedPointType;
    protected int transportCost;
    protected IncomeManager income = new IncomeManager(randomMoneyGenerator.nextInt(2000) + 1000);
    protected int maxAmountOfGoods;
    protected int currentAmountOfGoods = 0;
    protected int xCoordinate;
    protected int yCoordinate;
    protected boolean isLoaded;
    protected int fieldsMoved = 0;

    /**
     * Increase money of Vehicles IncomeManager
     * @param amount Amount that will be added to Vehicles IncomeManager money
     */
    public void increaseMoney(int amount) {
        this.income.increaseMoney(amount);
    }

    public String getAcceptedPointType() {
        return acceptedPointType;
    }

    public int getMoney() {
        return this.income.getMoney();
    }

    public int getInitialMoney() {
        return this.income.getInitialMoney();
    }

    public int getCurrentAmountOfGoods() {
        return currentAmountOfGoods;
    }

    /**
     * Append current amount of goods
     * @param amount Amount that is added to currentAmountOfGoods.
     */
    public void increaseAmountOfGoods(int amount) {
        this.currentAmountOfGoods += amount;
    }

    /**
     * Sell all goods and remove all current goods that are on vehicle.
     * @return Returns old amount of vehicle goods
     */
    public int sellAllGoods() {
        int old_amount = this.getCurrentAmountOfGoods();
        this.currentAmountOfGoods = 0;
        return old_amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Sets coordinates of Vehicle
     * @param x x coordinate
     * @param y y coordinate
     */
    public void setCoordinates(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getFieldsMoved() {
        return fieldsMoved;
    }

    public void appendFieldsMoved() {
        this.fieldsMoved += 1;
    }

    public int getxCoordinate() {
        return this.xCoordinate;
    }

    public int getyCoordinate() {
        return this.yCoordinate;
    }

    public String getType() {
        return type;
    }

    public int getTransportCost() {
        return transportCost;
    }

    public int getMaxAmountOfGoods() {
        return this.maxAmountOfGoods;
    }

    /**
     * Move vehicle one field in random direction, if random directions are not possible it generates them again
     * until valid direction is generated, after moving the vehicle, it's money is decreased by its transportCost
     * @param worldSize world size of World instance, to prevent generating impossible coordinates
     * @return Returns list of newly generated coordinates {x, y}
     */
    public int[] moveVehicle(int worldSize) {
        Random r = new Random();
        int[] randomCoords;
        randomCoords = new int[]{0, 0};

        int[] newRandomCoords = new int[2];
        newRandomCoords[0] = this.xCoordinate;
        newRandomCoords[1] = this.yCoordinate;
        while (true) {
            while (randomCoords[0] == 0 && randomCoords[1] == 0) {
                randomCoords[0] = r.nextInt(3) - 1;
                randomCoords[1] = r.nextInt(3) - 1;
            }
            if ((newRandomCoords[0] + randomCoords[0] >=0) && (newRandomCoords[0] + randomCoords[0] <= worldSize - 1)){
                if ((newRandomCoords[1] + randomCoords[1] >=0) && (newRandomCoords[1] + randomCoords[1] <= worldSize - 1)){
                    newRandomCoords[0] += randomCoords[0];
                    newRandomCoords[1] += randomCoords[1];
                    this.xCoordinate = newRandomCoords[0];
                    this.yCoordinate = newRandomCoords[1];
                    break;
                } else {
                    randomCoords[0] = 0;
                    randomCoords[1] = 0;
                }
            } else {
                randomCoords[0] = 0;
                randomCoords[1] = 0;
            }
        }
        this.income.decreaseMoney(this.transportCost);
        return newRandomCoords;
    }

}
