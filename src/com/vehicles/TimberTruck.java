package com.vehicles;

public class TimberTruck extends Vehicle {

    public TimberTruck(int maxAmountOfGoods) {
        this.maxAmountOfGoods = maxAmountOfGoods;
        this.transportCost = 20;
        this.type = "TimberTruck";
    }
}
