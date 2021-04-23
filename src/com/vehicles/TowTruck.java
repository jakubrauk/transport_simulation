package com.vehicles;

public class TowTruck extends Vehicle {

    public TowTruck(int maxAmountOfGoods) {
        this.maxAmountOfGoods = maxAmountOfGoods;
        this.transportCost = 10;
        this.type = "TowTruck";
    }
}
