package cgg.a04;

import cgg.a03.*;
import cgtools.*;

public record Background(Color color) implements Shape {
    public Hit intersect(Ray r){
        Hit hit = new Hit(Double.POSITIVE_INFINITY, null, Vector.direction(0, 0, 0), color);
        return hit;
    }
}
