package com.simulation;

import com.userinput.UserInput;
import com.world.World;

public class Main {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        userInput.getUserInput();
        World world = new World(5);
        world.generateWorld(userInput);

        for (int i=0; i<100; i++) {
            world.moveAllVehicles();
        }

    }
}
