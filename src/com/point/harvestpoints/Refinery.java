package com.point.harvestpoints;

public class Refinery extends HarvestPoint {

    public Refinery(int amountOfGoods){
        this.amountOfGoods = amountOfGoods;
        this.type = "Refinery";
    }

    @Override
    public String toString() { return this.type; }

}
