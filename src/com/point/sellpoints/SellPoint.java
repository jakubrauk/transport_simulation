package com.point.sellpoints;

import com.point.Point;

public abstract class SellPoint extends Point {

    protected int PrizeOfProduct;
    public SellPoint(){
        this.typeOfPoint = "SellPoint";
    }

    public int getPrizeOfProduct(){
        return this.PrizeOfProduct;
    }
}
