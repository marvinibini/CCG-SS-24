package cgg.a06;

import cgtools.*;


public record PerMirMaterial(Color albedos) implements Material{
    public boolean scattered(){
        return true;
    }
    public Color emission(){
        return Vector.color(0);
    }
    
    public Ray reflecRay(Ray ray, Hit hit){
        Direction reflecRay = Vector.subtract(ray.direction(), Vector.multiply(2.0, Vector.multiply(Vector.dotProduct(ray.direction(), hit.n()),hit.n())));
        double t = 1 * Math.pow(10, -6);
        Ray nRay = new Ray(hit.x(), reflecRay, t, Double.POSITIVE_INFINITY);
        return nRay;
    }
}
