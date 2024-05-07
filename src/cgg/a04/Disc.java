package cgg.a04;

import cgg.a03.*;
import cgtools.*;

public record Disc(Point anchorPoint, Direction normal, double radius, Color color) implements Shape {
    public Hit intersect(Ray r) {

        Direction direction = r.direction();
        Point x0 = r.x0();
        Hit hit = null;

        double limitation = 0;
        double denominator = Vector.dotProduct(direction, normal);

        double t = (Vector.dotProduct(Vector.subtract(anchorPoint, x0), normal)) / (denominator);
        if (r.isValid(t) == true) {
            Point treffer = Vector.add(Vector.multiply(direction, t), x0);
            limitation = Math.abs(Vector.length(Vector.subtract(treffer, anchorPoint)));
            if (limitation < radius) {
                hit = new Hit(t, treffer, normal, color);
            }
        }
        return hit;
    }
}
