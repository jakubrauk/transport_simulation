package vehicles;

import incomemanager.IncomeManager;

import java.util.Random;

public abstract class Vehicle {
    protected int id;
    protected Random randomMoneyGenerator = new Random();
    protected String type;
    protected int transportCost;
    protected IncomeManager income = new IncomeManager(randomMoneyGenerator.nextInt(2000) + 1000);
    protected int maxAmountOfGoods;
    protected int currentAmoutOfGoods;
    protected int xCoordinate;
    protected int yCoordinate;
    protected boolean isLoaded;
    protected int fieldsMoved = 0;

    public int getMoney() {
        return this.income.getMoney();
    }

    public int getInitialMoney() {
        return this.income.getInitialMoney();
    }

    public int getCurrentAmoutOfGoods() {
        return currentAmoutOfGoods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCoordinates(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getFieldsMoved() {
        return fieldsMoved;
    }

    public void appendFieldsMoved() {
        this.fieldsMoved += 1;
    }

    public int getxCoordinate() {
        return this.xCoordinate;
    }

    public int getyCoordinate() {
        return this.yCoordinate;
    }

    public String getType() {
        return type;
    }

    public int getTransportCost() {
        return transportCost;
    }

    public int getMaxAmountOfGoods() {
        return this.maxAmountOfGoods;
    }

    public boolean isVehicleLoaded() {
        return this.isLoaded;
    }

    public int[] moveVehicle(int worldSize) {
//        System.out.println("Vehicle position: " + this.xCoordinate + " " + this.yCoordinate);
        // Trzeba ten pojazd usunac ze starego punktu i przypisac do nowego.
        // Moves vehicle in random direction (always 1 point), causing decrease of money
        // x+1 or y+1 or x-1..
        boolean coordsValid = false;
        Random r = new Random();
        int[] randomCoords = new int[2];
        randomCoords = new int[]{0, 0};

        int[] newRandomCoords = new int[2];
        newRandomCoords[0] = this.xCoordinate;
        newRandomCoords[1] = this.yCoordinate;
        while (true) {
            while (randomCoords[0] == 0 && randomCoords[1] == 0) {
                randomCoords[0] = r.nextInt(3) - 1;
                randomCoords[1] = r.nextInt(3) - 1;
//                System.out.println("random direction x " + randomCoords[0]);
//                System.out.println("random direction y " + randomCoords[1]);
            }
            if ((newRandomCoords[0] + randomCoords[0] >=0) && (newRandomCoords[0] + randomCoords[0] <= worldSize - 1)){
                if ((newRandomCoords[1] + randomCoords[1] >=0) && (newRandomCoords[1] + randomCoords[1] <= worldSize - 1)){
                    newRandomCoords[0] += randomCoords[0];
                    newRandomCoords[1] += randomCoords[1];
                    this.xCoordinate = newRandomCoords[0];
                    this.yCoordinate = newRandomCoords[1];
                    break;
                } else {
                    randomCoords[0] = 0;
                    randomCoords[1] = 0;
                }
            } else {
                randomCoords[0] = 0;
                randomCoords[1] = 0;
            }
        }

        // 0 , 0 - aktualne polozenie
        // -1 , -1 - nowe coordy
        // +1 +1
        // 0 , 0

//        int randX = this.xCoordinate + randomCoords[0];
//        int randY = this.yCoordinate + randomCoords[1];

//        int[] newRandomCoords = new int[2];
//        newRandomCoords[0] = randX;
//        newRandomCoords[1] = randY;
        this.income.decreaseMoney(this.transportCost);
//        System.out.println("new x coords" + newRandomCoords[0]);
//        System.out.println("new y coords" + newRandomCoords[1]);
        return newRandomCoords;
    }

}
