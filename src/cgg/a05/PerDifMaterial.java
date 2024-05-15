package cgg.a05;

import static cgtools.Vector.color;

import cgg.a03.*;
import cgtools.*;

public record PerDifMaterial(Color albedos) implements Material{
    @Override
    public boolean gestreut() {
        return true;
    }
    @Override
    public Ray reflecRay(Ray ray, Hit hit) {
        double x = new Random().nextDouble(2) - 1;
        double y = new Random().nextDouble(2) - 1;
        double z = new Random().nextDouble(2) - 1;
        double xyz = Math.sqrt((x * x) + (y * y) + (z * z));
        double t = 1 * Math.pow(10, -7);

        if(xyz <= 1){
            Direction r = new Direction(x, y, z);
            Direction d = Vector.normalize(Vector.add(hit.n(), r));
            Point x0 = hit.x();
            return new Ray(x0, d, t, Double.POSITIVE_INFINITY);
        }
        else{
            return reflecRay(ray, hit);

        }
    }
    @Override
    public Color emission() {
        return color(0);
    }
}
