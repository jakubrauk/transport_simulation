package com.vehicles;

public class Lorry extends Vehicle {

    public Lorry(int maxAmountOfGoods) {
        this.maxAmountOfGoods = maxAmountOfGoods;
        this.transportCost = 15;
        this.type = "Lorry";
    }
}
