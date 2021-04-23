package com.simulation;

import com.userinput.UserInput;
import com.world.World;

public class Main {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        userInput.getUserInput();
        World world = new World(userInput.getWorldSize());
        world.generateWorld();
    }
}
