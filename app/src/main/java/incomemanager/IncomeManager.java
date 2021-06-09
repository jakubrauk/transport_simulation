package incomemanager;

public class IncomeManager {
    protected int money;

    public int getMoney() {
        return money;
    }

    public IncomeManager(int money) {
        this.money = money;
    }

    public void increaseMoney(int amount) {
        this.money += amount;
    }

    public void decreaseMoney(int amount){
        this.money -= amount;
    }
}
