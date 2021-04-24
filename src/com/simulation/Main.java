package com.simulation;

import com.point.Point;
import com.point.harvestpoints.CarDealer;
import com.point.harvestpoints.Refinery;
import com.userinput.UserInput;
import com.vehicles.TimberTruck;
import com.vehicles.TowTruck;
import com.world.World;

public class Main {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        userInput.getUserInput();
        World world = new World(5);
        world.generateWorld();

        TowTruck newTow = new TowTruck(100);
        TimberTruck newTimber = new TimberTruck(50);

        world.printPoints();

        world.getPoint(0, 0).putVehicle(newTow);
        world.getPoint(0, 0).putVehicle(newTimber);
        world.getPoint(0, 0).displayVehicles();

    }
}
