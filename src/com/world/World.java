package com.world;

import com.point.PointInterface;

import java.util.ArrayList;
import java.util.List;

public class World {
    int world_size;
    List<PointInterface> pointsList = new ArrayList<>();
    public World(int worldSize) {
        this.world_size = worldSize;
    }

    public void generateWorld() {
        System.out.println("GENERATING WORLD");
        // Randomly places all objects on map.
    }

    public static void checkWorldField(int x, int y) {
        // Returns what object is on specified field
    }

}
