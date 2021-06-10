package incomemanager;

public class IncomeManager {
    protected int money;
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

    public void increaseMoney(int amount) {
        this.money += amount;
    }

    public void decreaseMoney(int amount){
        this.money -= amount;
    }
}
