package cgg.a06;

import cgtools.*;
import static cgtools.Vector.*;

public record Ray(Point x0, Direction direction, double tMin, double tMax){
    public Point pointAt(double t){
        Point point = add((multiply(t, direction)), x0);        
        return point;
    }
    public boolean isValid(double t){
       return t >= tMin && t <= tMax;
    }
}
