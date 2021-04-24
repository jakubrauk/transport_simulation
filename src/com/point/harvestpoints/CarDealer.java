package com.point.harvestpoints;

public class CarDealer extends HarvestPoint {

    public CarDealer(int amountOfGoods){
        this.amountOfGoods = amountOfGoods;
        this.type = "CarDealer";
    }

    @Override
    public String toString() { return this.type; }

}
