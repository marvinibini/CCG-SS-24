package cgg.a03;

import static cgtools.Vector.*;

import cgtools.*;

public record Camera(double angel, double width, double height) {
    public Direction samplingPoint(double x, double y){
        double vecktorX = 0;
        double vecktorY = 0;
        double vecktorZ = 0;
        vecktorX = (x - (width / 2));
        vecktorY = (-(y - (height / 2)));
        vecktorZ = -((width / 2) / (Math.tan((angel / 2))));
        return normalize(direction(vecktorX, vecktorY, vecktorZ));
    }
}