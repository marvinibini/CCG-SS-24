package cgg.a06;

import static cgtools.Vector.*;

import cgtools.*;

public record Camera(double angel, double width, double height, Matrix matrix) {

    public Ray samplingPoint(double x, double y){
        double vecktorX = 0;
        double vecktorY = 0;
        double vecktorZ = 0;
        vecktorX = (x - (width / 2));
        vecktorY = (-(y - (height / 2)));
        vecktorZ = -((width / 2) / (Math.tan((angel / 2))));
        Direction dir = normalize(direction(vecktorX, vecktorY, vecktorZ));        
        
        double tmin = 0;
        double tmax = Double.POSITIVE_INFINITY;
        Ray ray = new Ray(Matrix.multiply(matrix, new Point(0, 0, 0)), Matrix.multiply(matrix,dir), tmin, tmax);
        
        return ray;
    }
}
