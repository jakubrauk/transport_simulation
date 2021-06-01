package com.vehicles;

import com.incomemanager.IncomeManager;

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
        // Moves vehicle in random direction (always 1 point), causing decrease of money
        // x+1 or y+1 or x-1..
        int randX = this.xCoordinate + 1;
        int randY = this.yCoordinate - 1;

        int[] newRandomCoords = new int[2];
        newRandomCoords[0] = randX;
        newRandomCoords[1] = randY;
        this.income.decreaseMoney(this.transportCost);

        return newRandomCoords;
    }

}
