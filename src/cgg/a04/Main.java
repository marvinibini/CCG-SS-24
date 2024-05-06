package cgg.a04;

import cgg.a03.*;
import cgg.*;
import cgtools.*;
import static cgtools.Vector.*;

public class Main {
    public static void main(String[] args) {
        final int width = 1920;
        final int height = 1080;
        double angel = 70;
        Point x0 = new Point(0, 0, 0);
        double tMin = 0;
        double tMax = Double.POSITIVE_INFINITY;
        Image image = new Image(width, height);
        
        Camera camera = new Camera(angel, width, height);
        Group scene = new Group();

        scene.add(new Background(gray));
        scene.add(new Disc(point(0.0, -0.5, 0.0), direction(0, 1, 0), 100, yellow));
        scene.add(new Sphere(point(-1., -0.25, -2.5), 0.7, red));
        scene.add(new Sphere(point(0.0, -0.25, -2.5), 0.5, green));
        scene.add(new Sphere(point(1.0, -0.25, -2.5), 0.7, blue));
      
        image.superSample(new Raytracer(scene, camera, x0, tMin, tMax), 3, 3);

        final String filename = "doc/a04-image.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
    }
}
