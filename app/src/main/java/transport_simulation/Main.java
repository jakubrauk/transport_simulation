package transport_simulation;

import output.FileOutput;
import userinput.UserInput;
import world.World;

public class Main {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new Main().getGreeting());
        UserInput userInput = new UserInput();
        userInput.getUserInput();
        World world = new World(5);

        world.generateWorld(userInput);
        FileOutput userFileOutput = new FileOutput();

        for (int i = 0; i < userInput.getNumberOfIterarions(); i++) {
            world.moveAllVehicles();
            if (i % userInput.getDataCheckpoint() == 0) {
                userFileOutput.saveOutputFile();
            }
        }
        userFileOutput.saveOutputFile();
    }
}
