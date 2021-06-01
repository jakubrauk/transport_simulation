package com.point.harvestpoints;

import java.util.Random;

public class Woodshed extends HarvestPoint {

    public Woodshed(){
        this.amountOfGoods = new Random().nextInt(150);
        this.type = "Woodshed";
    }

}
