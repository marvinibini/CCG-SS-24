package cgg.a03;

import cgtools.Direction;
import cgtools.Vector;

public record Lochkamera(double angle, double width, double height) {
    
    public Direction abtastPunktStrahl(double x, double y){

        double vectorx;
        double vectory;
        double vectorz;

        vectorx = x - (width / 2);
        vectory = -(y - (height / 2));
        vectorz = - (width / 2) / (Math.tan(angle / 2));
        Direction d = new Direction(vectorx, vectory, vectorz);
        d = Vector.normalize(d);
        return d;
     }
}
