package com.simulation;

import com.output.FileOutput;
import com.point.Point;
import com.point.harvestpoints.*;
import com.userinput.UserInput;
import com.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        userInput.getUserInput();
        World world = new World(5);

        world.generateWorld(userInput);
        FileOutput userFileOutput = new FileOutput();

        for (int i=0; i<userInput.getNumberOfIterarions(); i++) {
            world.moveAllVehicles();
            if (i % userInput.getDataCheckpoint() == 0) { userFileOutput.saveOutputFile(); }
        }
        userFileOutput.saveOutputFile();
    }
}
