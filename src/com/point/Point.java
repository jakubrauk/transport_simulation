package com.point;

import com.world.World;

public abstract class Point implements PointInterface {
    int x_coordinate;
    int y_coordinate;
    protected String type;
    protected String typeOfPoint;

    public String getType(){
        return type;
    }
    public String getTypeOfPoint(){
        return typeOfPoint;
    }

    public void randomizeLocation(){
        x_coordinate = 1;
        y_coordinate = 2;
    }
}



