package com.userinput;

public class UserInput {
    private int numberOfIterarions;
    private int vehicleNumber;
    private int harvestPlaceNumber;
    private int sellPointNumber;
    private int dataCheckpoint;
    private int worldSize;

//    public UserInput(int vehicle_number, int harvest_place_number, int sell_point_number, int data_checkpoint, int world_size) {
//        this.vehicle_number = vehicle_number;
//        this.harvest_place_number = harvest_place_number;
//        this.sell_point_number = sell_point_number;
//        this.data_checkpoint = data_checkpoint;
//        this.world_size = world_size;
//    }

    public void getUserInput() {
        // Collect data from user
    }

    public int getNumberOfIterarions() { return numberOfIterarions; }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getHarvestPlaceNumber() {
        return harvestPlaceNumber;
    }

    public void setHarvestPlaceNumber(int harvestPlaceNumber) {
        this.harvestPlaceNumber = harvestPlaceNumber;
    }

    public int getSellPointNumber() {
        return sellPointNumber;
    }

    public void setSellPointNumber(int sellPointNumber) {
        this.sellPointNumber = sellPointNumber;
    }

    public int getDataCheckpoint() {
        return dataCheckpoint;
    }

    public void setDataCheckpoint(int dataCheckpoint) {
        this.dataCheckpoint = dataCheckpoint;
    }

    public int getWorldSize() {
        return worldSize;
    }

    public void setWorldSize(int worldSize) {
        this.worldSize = worldSize;
    }
}
