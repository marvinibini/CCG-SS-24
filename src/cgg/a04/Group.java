package cgg.a04;

import java.util.ArrayList;
import cgg.a03.*;

public class Group implements Shape{

    public ArrayList<Shape> shapes = new ArrayList<Shape>();

    public Hit intersect(Ray r){
        Hit hit = null;
        for(Shape s : shapes){
            if(s.intersect(r) != null && (hit == null || s.intersect(r).t() < hit.t())){
                hit = s.intersect(r);
            }
        }
        return hit;
    }

    public void add(Shape shape){
        shapes.add(shape);
    }
}