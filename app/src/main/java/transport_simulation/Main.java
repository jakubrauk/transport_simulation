package transport_simulation;
import output.FileOutput;
import userinput.UserInput;
import world.World;

/**
 * This class is responsible for the entire process of the program's operation.
 * Gathering userInput, generating World, generating output files
 */
public class Main {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new Main().getGreeting());
        UserInput userInput = new UserInput();
        userInput.getUserInput();
        System.out.println("provided number of iterations: " + userInput.getNumberOfIterations());
        System.out.println("provided number of vehicles: " + userInput.getVehicleNumber());
        System.out.println("provided number of harvest points: " + userInput.getHarvestPointNumber());
        System.out.println("provided number of sell points: " + userInput.getSellPointNumber());
        System.out.println("provided number of data checkpoints: " + userInput.getDataCheckpoint());
        System.out.println("provided number of world size: " + userInput.getWorldSize());

        World world = new World(userInput.getWorldSize());

        world.generateWorld(userInput);
        world.getAllPoints();
        FileOutput userFileOutput = new FileOutput();

        userFileOutput.saveOutputFile("Before_start", world);

        for (int i = 0; i < userInput.getNumberOfIterations(); i++) {

            System.out.println("====================ITERATION NUMBER " + i);
            world.moveAllVehicles();
            world.gatherResourcesHarvestPoints();

            if (i % userInput.getDataCheckpoint() == 0) {
                String filename = "Checkpoint_" + i;
                userFileOutput.saveOutputFile(filename, world);
            }
        }
        System.out.println("Simulation ended");

        userFileOutput.saveOutputFile("Final_file", world);
    }

}
