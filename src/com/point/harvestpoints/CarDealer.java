package com.point.harvestpoints;

import java.util.Random;

public class CarDealer extends HarvestPoint {

    public CarDealer(){
        this.amountOfGoods = new Random().nextInt(150);
        this.type = "CarDealer";
    }
}
