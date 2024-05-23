package cgg.a06;

import cgtools.*;
import static cgtools.Vector.*;

public record Raytracer(Group list, Camera camera, Point x0, double tMin, double tMax, int depth) implements Sampler {
    
    public Color getColor(double x, double y){
        
        Ray r = camera.samplingPoint(x, y);
        // Ray r = new Ray(Matrix.multiply(camera.matrix(),x0), direction, tMin, tMax);

        return calculateRadiance(list, r , depth);            
    }

    public Color calculateRadiance(Shape scene, Ray ray, int depth){
        if(depth == 0){
            return black;
        }else{
            Hit hit = scene.intersect(ray);
            Material material = hit.material();
            Ray newRay = material.reflecRay(ray, hit);
            if(newRay != null){
                // return Vector.asColor(hit.n());
                return Vector.multiply(material.albedos(),calculateRadiance(scene, newRay, depth - 1));
            }
            else{
                // return Vector.asColor(hit.n());
                return material.emission();
            }
        }


    }
}