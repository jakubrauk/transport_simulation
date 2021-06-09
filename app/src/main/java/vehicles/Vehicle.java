package vehicles;

import incomemanager.IncomeManager;

import java.util.Random;

public abstract class Vehicle {
    protected String type;
    protected int transportCost;
    protected IncomeManager income = new IncomeManager(0);
    protected int maxAmountOfGoods;
    protected int xCoordinate;
    protected int yCoordinate;
    protected boolean isLoaded;

    public void randomizeStartLocation() {
        // randomly generate x and y coords
    }

    public String getType() {
        return type;
    }

    public int getMaxAmountOfGoods() {
        return this.maxAmountOfGoods;
    }

    public boolean isVehicleLoaded() {
        return this.isLoaded;
    }

    public int[] moveVehicle() {
        // Trzeba ten pojazd usunac ze starego punktu i przypisac do nowego.
        // Moves vehicle in random direction (always 1 point), causing decrease of money
        // x+1 or y+1 or x-1..
        Random r = new Random();
        int[] randomCoords = new int[2];
        randomCoords = new int[]{0, 0};

        while (randomCoords[0] == 0 && randomCoords[1] == 0) {
            randomCoords[0] = r.nextInt(3) - 1;
            randomCoords[1] = r.nextInt(3) - 1;
        }
        int randX = this.xCoordinate + randomCoords[0];
        int randY = this.yCoordinate + randomCoords[1];

        int[] newRandomCoords = new int[2];
        newRandomCoords[0] = randX;
        newRandomCoords[1] = randY;
        this.income.decreaseMoney(this.transportCost);
        return newRandomCoords;
    }

}
