package point.sellpoints;

import point.Point;

public abstract class SellPoint extends Point {

    protected int PrizeOfProduct;
    public SellPoint(){
        this.typeOfPoint = "SellPoint";
    }

    public void setPrizeOfProduct(int newPrize){
        this.PrizeOfProduct = newPrize;
    }

    public int getPrizeOfProduct(){
        return this.PrizeOfProduct;
    }
}
