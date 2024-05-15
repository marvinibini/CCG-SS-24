package cgg.a03;

import cgtools.*;
import static cgtools.Vector.*;

import cgg.a04.Shape;
import cgg.a05.Material;

public record Sphere(Point sphereCenter, double radius, Material material) implements Shape{
    public Hit intersect(Ray r){

        Hit hit = null;
        Direction d = r.direction();
        Point x0 = r.x0();
        Direction x0Strich = subtract(x0, sphereCenter);
        double t = 0;
    
        double a = squaredLength(d);
        double b = dotProduct((multiply(2,x0Strich)),d);
        double c = (squaredLength(x0Strich) - Math.pow(radius, 2)); 
        double diskriminante = Math.pow(b, 2) - (4 * a * c);
    
        if(diskriminante == 0){
            t = (-b + Math.sqrt(diskriminante))/(2*a);
            if(t >= r.tMin() && t <= r.tMax()){
                Point x = add(x0, (multiply(d, t)));
                Direction nullVector = normalize(divide((subtract(x, sphereCenter)), radius));
                hit = new Hit(t, x, nullVector, material);
            }
        }
        else if(diskriminante > 0){
            double tPlus = (-b + Math.sqrt(diskriminante))/(2*a);
            double tMinus = (-b - Math.sqrt(diskriminante))/(2*a);
            if(r.isValid(tPlus) == true && r.isValid(tMinus) == true){
                if(tPlus < tMinus){
                    t = tPlus;
                }
                else{
                    t = tMinus;
                }           
            Point x = r.pointAt(t);
            Direction nullVector = normalize(divide((subtract(x, sphereCenter)), radius));
            hit = new Hit(t, x, nullVector, material);
            }
            else if(r.isValid(tMinus) == true){
                t = tMinus;
                Point x = r.pointAt(t);
                Direction nullVector =normalize(divide((subtract(x, sphereCenter)), radius));
                hit = new Hit(t, x, nullVector, material);
            }
            else if(r.isValid(tPlus) == true){
                t = tPlus;
                Point x = r.pointAt(t);
                Direction nullVector = normalize(divide((subtract(x, sphereCenter)), radius));
                hit = new Hit(t, x, nullVector, material);
            }
        }
        return hit;
    }   
}
