package userinput;
import java.util.Scanner;
/**
 * Class responsible for gathering necessary data from user
 */
public class UserInput {
    private int numberOfIterations;
    private int vehicleNumber;
    private int harvestPointNumber;
    private int sellPointNumber;
    private int dataCheckpoint;
    private int worldSize;
    public Scanner inputScanner = new Scanner(System.in);

    /**
     * Get input from user, with basic input security, does not accept values less than 0, or not digit.
     * @param displayAttrName Name of variable to be passed.
     * @return Returns value passed by the User.
     */
    public int getInputValue(String displayAttrName) {
        int intInput = 0;
        do {
            System.out.println("Enter " + displayAttrName);
            while (!this.inputScanner.hasNextInt()) {
                String input = this.inputScanner.next();
                System.out.println(input + " is not a valid format for " + displayAttrName +", try again - Integer must be provided.");
            }
            intInput = this.inputScanner.nextInt();
            if (intInput <= 0) {
                System.out.println("Input must be larger than 0");
            }
        } while (intInput <= 0);
        return intInput;
    }

    public void setNumberOfIterations() {
        this.numberOfIterations = this.getInputValue("number of iterations");
    }

    public int getNumberOfIterations() { return numberOfIterations; }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber() {
        this.vehicleNumber = this.getInputValue("number of vehicles");
    }

    public int getHarvestPointNumber() {
        return harvestPointNumber;
    }

    public void setHarvestPointNumber() {
        this.harvestPointNumber = this.getInputValue("number of harvest point ");
    }

    public int getSellPointNumber() {
        return sellPointNumber;
    }

    public void setSellPointNumber() {
        this.sellPointNumber = this.getInputValue("number of sell point");
    }

    public int getDataCheckpoint() {
        return dataCheckpoint;
    }

    public void setDataCheckpoint() {
        this.dataCheckpoint = this.getInputValue("number of data checkpoints");
    }

    public int getWorldSize() {
        return worldSize;
    }

    /**
     * Gathers world size (x by x) from user. World size cannot be less than sum of harvest and sell points
     * that were passed before, to prevent lack of free space.
     */
    public void setWorldSize() {
        int newWorldSize = 0;
        do {
            newWorldSize = this.getInputValue("world size");
            if (newWorldSize * newWorldSize < this.getHarvestPointNumber()+this.getSellPointNumber()) {
                System.out.println("world size to small.");
            }
        } while (newWorldSize * newWorldSize < this.getHarvestPointNumber()+this.getSellPointNumber());
        this.worldSize = newWorldSize;
    }

    /**
     * Collecting data from user.
     */
    public void getUserInput() {
        this.setNumberOfIterations();
        this.setVehicleNumber();
        this.setHarvestPointNumber();
        this.setSellPointNumber();
        this.setDataCheckpoint();
        this.setWorldSize();
    }
}
