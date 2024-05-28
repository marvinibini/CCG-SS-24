package cgg.a06;

import static cgtools.Vector.*;
import cgtools.*;

public record TransMaterial(Color albedos, double brechung) implements Material{
    public boolean scattered(){
        return false;
    }
    @Override
    public Color emission() {
        return color(0);
    }
    public Ray reflecRay(Ray ray, Hit hit){
        double n1 = 1;
        double n2 = brechung;
        
        double nd = Vector.dotProduct(ray.direction(), hit.n());
        Direction n = hit.n();
        Direction d = ray .direction();
        Direction nDirection = null;
        double t = 1 * Math.pow(10, -7);

        if(nd > 0){
            n = Vector.negate(n);
            double tamp = n1;
            n1 = n2;
            n2 = tamp;
        }
        if(refract(d, n, n1, n2) == null){
            nDirection = reflect(d, n);
        }
        else{
            if(Random.random() > schlick(d, n, n1, n2)){
                nDirection = refract(d, n, n1, n2);
            }
            else{
                nDirection = reflect(d, n);
            }
        }
        Ray nRay = new Ray(hit.x(), nDirection, t, Double.POSITIVE_INFINITY);
        return nRay;

        
    }
    public static double schlick(Direction d, Direction n, double n1, double n2){
        double r0 = Math.pow(((n1 - n2)/(n1 + n2)), 2);

        double schlick = r0 + ((1 - r0)*(Math.pow(1 + Vector.dotProduct(Vector.normalize(d), n), 5)));    
        return schlick;
    }
    public static Direction reflect(Direction d, Direction n){
        Direction reflecdDirection = Vector.subtract(d, Vector.multiply(2.0, Vector.multiply(Vector.dotProduct(d, n), n)));
        return reflecdDirection;
    }
    public static Direction refract(Direction d, Direction n, double n1, double n2){
        double r = n1/n2;
        double c = Vector.dotProduct(Vector.negate(n), Vector.normalize(d));
        double dis = 1 - Math.pow(r, 2)*(1 - Math.pow(c, 2));
        if(dis < 0){
            return null;
        }
        else{
            Direction refractDirection = Vector.add(Vector.multiply(r, Vector.normalize(d)),Vector.multiply(r * c - Math.sqrt(dis),n));
            return refractDirection;
        }
    }
}
