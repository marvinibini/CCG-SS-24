package cgg.a04;

import cgg.a03.*;
import cgtools.*;
import static cgtools.Vector.*;

public record Raytracer(Group list, Camera camera, Point x0, double tMin, double tMax) implements Sampler {
    public Color getColor(double x, double y){
        Direction direction = camera.samplingPoint(x, y);
        Ray r = new Ray(x0, direction, tMin, tMax);
        Hit hit = list.intersect(r);
        return shade(hit.n(), hit.c());            
    }
    static Color shade(Direction normal, Color color) {
        Direction lightDir = normalize(direction(1, 1, 0.5));
        Color ambient = multiply(0.1, color);
        Color diffuse = multiply(0.9 * Math.max(0, dotProduct(lightDir, normal)), color);
        return add(ambient, diffuse);
    }
}