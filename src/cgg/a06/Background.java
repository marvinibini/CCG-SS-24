package cgg.a06;

import cgtools.*;

public record Background(Material material) implements Shape {

    public Hit intersect(Ray r){
        Hit hit = new Hit(Double.POSITIVE_INFINITY, null, Vector.negate(r.direction()), material);
        return hit;
    }
}