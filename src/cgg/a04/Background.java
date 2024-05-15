package cgg.a04;

import cgg.a03.*;
import cgg.a05.*;
import cgtools.*;

public record Background(Material material) implements Shape {

    public Hit intersect(Ray r){
        Hit hit = new Hit(Double.POSITIVE_INFINITY, null, Vector.negate(r.direction()), material);
        return hit;
    }
}