package com.point.harvestpoints;

import com.point.Point;

public abstract class HarvestPoint extends Point {
    protected int amountOfGoods;
    public HarvestPoint(){
        this.typeOfPoint = "HarvestPoint";
    }
    public int getAmountOfGoods() {
        return this.amountOfGoods;
    }
    public void loading(int amount){
        this.amountOfGoods -= amount;
    }
}
