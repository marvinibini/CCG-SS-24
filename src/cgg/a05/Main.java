package cgg.a05;

import cgg.*;
import cgg.a03.*;
import cgg.a04.*;
import cgtools.*;
import static cgtools.Vector.*;

public class Main {
    public static void main(String[] args) {
        final int width = 1920;
        final int height = 1080;

        Point x0 = new Point(0, 0, 0);
        double tMin = 0;
        double tMax = Double.POSITIVE_INFINITY;

        Image image1 = new Image(width, height);
        Camera camera = new Camera(Math.PI / 2.6, width, height);

        Group scene1 = new Group();

        scene1.add(new Background(new EmitterMaterial(color(0.8,0.8, 1))));
        scene1.add(new Disc(point(0.0, -0.5, 0.0), direction(0, 1, 0), 100,new PerDifMaterial(gray)));
        scene1.add(new Sphere(point(0, -0.02, -3.5), .5, new PerDifMaterial(red)));

        
        image1.superSample(new Raytracer(scene1, camera, x0, tMin, tMax, 5), 2, 1);
        final String filename1 = "doc/a05-test-scene.png";
        image1.write(filename1);
        System.out.println("Wrote image: " + filename1);

//nur zum testen des programms

        Image image2 = new Image(width, height);
        Camera camera2 = new Camera(Math.PI / 2, width, height);

        Group scene2 = new Group();
        
        scene2.add(new Background(new EmitterMaterial(color(1))));
        scene2.add(new Disc(point(0.0, -3.25, 0.0), direction(0, 1, 0),Double.POSITIVE_INFINITY, new PerDifMaterial(color(0.1))));
        scene2.add(new Disc(point(0,0,-10), direction(1,1,-1),2, new PerDifMaterial(blue)));
        scene2.add(new Disc(point(0,0,-10), direction(1,-1,1),2, new PerDifMaterial(green)));
        scene2.add(new Disc(point(0,0,-10), direction(0,1,1),2, new PerDifMaterial(red)));
        scene2.add(new Sphere(point(0,0,-10), 1, new PerDifMaterial(black)));        
        for(double i = -3; i <= 3 ; i = i + 0.5){
            scene2.add(new Sphere(point(i,-3,-13), 0.3, new PerDifMaterial(color(1, Math.random(), Math.random()))));
            scene2.add(new Sphere(point(i,-3,-7), 0.3, new PerDifMaterial(color(1, Math.random(), Math.random()))));
            scene2.add(new Sphere(point(i,3,-13), 0.3, new PerDifMaterial(color(1, Math.random(), Math.random()))));
            scene2.add(new Sphere(point(i,3,-7), 0.3, new PerDifMaterial(color(1, Math.random(), Math.random()))));

            scene2.add(new Sphere(point(-3,i,-7), 0.3, new PerDifMaterial(color(Math.random(), 1, Math.random()))));
            scene2.add(new Sphere(point(-3,i,-13), 0.3, new PerDifMaterial(color(Math.random(), 1, Math.random()))));
            scene2.add(new Sphere(point(3,i,-7), 0.3, new PerDifMaterial(color(Math.random(), 1, Math.random()))));
            scene2.add(new Sphere(point(3,i,-13), 0.3, new PerDifMaterial(color(Math.random(), 1, Math.random()))));        
        }
        for(double j = -13; j <= -7; j += 0.5){
            scene2.add(new Sphere(point(3,3,j), 0.3, new PerDifMaterial(color(Math.random(), Math.random(), 1))));
            scene2.add(new Sphere(point(-3,3,j), 0.3, new PerDifMaterial(color(Math.random(), Math.random(), 1))));
            scene2.add(new Sphere(point(3,-3,j), 0.3, new PerDifMaterial(color(Math.random(), Math.random(), 1))));
            scene2.add(new Sphere(point(-3,-3,j), 0.3, new PerDifMaterial(color(Math.random(), Math.random(), 1))));
        }

        image2.superSample(new Raytracer(scene2, camera2, x0, tMin, tMax, 5), 5, 5);
        final String filename2 = "doc/a05-test2.png";
        image2.write(filename2);
        System.out.println("Wrote image: " + filename2);
    }
}
