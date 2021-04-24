package com.world;

import com.point.Point;
import com.point.harvestpoints.CarDealer;
import com.point.harvestpoints.Refinery;

public class World {
    int worldSize;
    Point[][] pointsList;
    public World(int worldSize) {
        this.worldSize = worldSize;
        this.pointsList = new Point[this.worldSize][this.worldSize];
    }


    public void generateWorld() {
        System.out.println("GENERATING WORLD");
        this.pointsList = new Point[this.worldSize][this.worldSize];
        this.pointsList[0][0] = new CarDealer(100);
        this.pointsList[0][1] = new Refinery(150);
    }

    public void checkWorldField(int x, int y) { System.out.println(this.pointsList[x][y]); }

    public void printPoints() {
        for (int x = 0; x < this.worldSize; x++) {
            for (int y = 0; y < this.worldSize; y++) {
                if (this.pointsList[x][y] != null) {
                    System.out.println("[" + x + "][" + y + "] " + this.pointsList[x][y]);
                } else {
                    System.out.println("[" + x + "][" + y + "] NULL");
                }
            }
        }
    }


    public Point getPoint(int x, int y) { return this.pointsList[x][y]; }


}
