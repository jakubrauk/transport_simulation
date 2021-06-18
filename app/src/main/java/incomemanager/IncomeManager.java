package incomemanager;

/**
 *Class responsible for handling vehicles money
 */
public class IncomeManager {
    /**
     * Current money amount
     */
    protected int money;
    /**
     * Initial money that is added at the beginning of simulation
     */
    protected int initialMoney;

    public int getMoney() {
        return money;
    }

    public int getInitialMoney() {
        return initialMoney;
    }
    public IncomeManager(int money) {

        this.money = money;
        this.initialMoney = money;
    }
    /**
     * This method ads a certain amount to the variable money when the raw material is shipped
     * @param amount amount that will be added to money
     */
    public void increaseMoney(int amount) {

        this.money += amount;
    }
    /**
     * This method gets a specified amount from the variable money when moving to another field on the map
     * @param amount amount that will decrease current money
     */
    public void decreaseMoney(int amount){

        this.money -= amount;
    }
}
