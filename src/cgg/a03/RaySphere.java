package cgg.a03;

import cgtools.*;
import java.util.ArrayList;
import static cgtools.Vector.*;

public record RaySphere(ArrayList<Sphere> list,Camera camera, Point x0, double tMin, double tMax, Color backColor) implements Sampler{
   
    public Color getColor(double x, double y){
        Direction direction = camera.samplingPoint(x, y);
        Ray r = new Ray(x0, direction, tMin, tMax);
        Hit hit1 = null;
        for(Sphere s : list){
            Hit hit = s.intersect(r);
            if(hit != null &&  (hit1 == null || hit.t() < hit1.t())){
                hit1 = hit;
            }
        }
            if(hit1 != null){
                Color color = hit1.c();
                color = shade(Vector.normalize(hit1.n()), color);
                return color;
            }
       return backColor;
    }
    static Color shade(Direction normal, Color color) {
        Direction lightDir = normalize(direction(1, 1, 0.5));
        Color ambient = multiply(0.1, color);
        Color diffuse = multiply(0.9 * Math.max(0, dotProduct(lightDir, normal)), color);
        return add(ambient, diffuse);
    }
}
