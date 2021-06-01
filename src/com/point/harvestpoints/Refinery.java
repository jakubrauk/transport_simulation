package com.point.harvestpoints;

import java.util.Random;

public class Refinery extends HarvestPoint {

    public Refinery(){
        this.amountOfGoods = new Random().nextInt(150);
        this.type = "Refinery";
    }


}
