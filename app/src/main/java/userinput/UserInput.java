package userinput;

import point.harvestpoints.HarvestPoint;

import java.util.Scanner;

public class UserInput {
    private int numberOfIterations;
    private int vehicleNumber;
    private int harvestPointNumber;
    private int sellPointNumber;
    private int dataCheckpoint;
    private int worldSize;
    public Scanner inputScanner = new Scanner(System.in);

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

    public void setWorldSize() {
        this.worldSize = this.getInputValue("world size");
    }

    public void getUserInput() {
        // Collecting data from user
        this.setNumberOfIterations();
        this.setVehicleNumber();
        this.setHarvestPointNumber();
        this.setSellPointNumber();
        this.setDataCheckpoint();
        this.setWorldSize();
    }
}
