package com.vehicles;

import com.incomemanager.IncomeManager;

public abstract class Vehicle {
    protected String type;
    protected int transportCost;
    protected IncomeManager income = new IncomeManager(0);
    protected int maxAmountOfGoods;

    public String getType() {
        return type;
    }

    public int getMaxAmountOfGoods() {
        return this.maxAmountOfGoods;
    }


}
