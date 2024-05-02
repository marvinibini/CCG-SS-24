package cgg.a03;

import java.util.ArrayList;
import java.util.List;

import cgg.*;
import cgtools.*;
import static cgtools.Vector.*;

public class Main {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        // System.out.println(start);

        final int width = 480;
        final int height = 270;
        double angel = Math.PI / 2;
        Point x0 = new Point(0, 0, 0);
        double tMin = 0;
        double tMax = Double.POSITIVE_INFINITY;

        Image image = new Image(width, height);

        List<Sphere> sphereList = new ArrayList<Sphere>();
        Sphere sphere0 = new Sphere(point(-1.0, 1.0, (-7.0)), 1,green);
        sphereList.add(sphere0);
        Sphere sphere1 = new Sphere(point(-2.0, 1.0, (-7.0)), 1.5, color(Math.random(), Math.random(), Math.random()));
        sphereList.add(sphere1);
        Sphere sphere2 = new Sphere(point(2.5, 0.0, (-3.0)), 0.5, color(Math.random(), Math.random(), Math.random()));
        sphereList.add(sphere2);
        Sphere sphere3 = new Sphere(point(-5.0, -4.0, (-10.0)), 2.5, color(Math.random(), Math.random(), Math.random()));
        sphereList.add(sphere3);
        Sphere sphere4 = new Sphere(point(5.0, 0.0, (-50.0)), 10, color(Math.random(), Math.random(), Math.random()));
        sphereList.add(sphere4);

        Camera camera = new Camera(angel, width, height);
        image.sample(new RaySphere((ArrayList<Sphere>) sphereList, camera, x0, tMin, tMax, gray), 50);

        final String filename = "doc/a03-spheres.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
        
        System.out.println(System.currentTimeMillis() - start);

    }
}
