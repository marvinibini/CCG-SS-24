package cgg.a04;

import cgg.a03.*;
import cgg.*;
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
        Image image2 = new Image(width, height);

        Camera camera = new Camera(Math.PI / 2.6, width, height);
        Camera camera2 = new Camera(Math.PI / 2.6, width, height);

        // Erste Szene (eigene)
        Group scene1 = new Group();
        scene1.add(new Background(new Color(0.05, 0.05, 0.2)));
        scene1.add(new Disc(point(0, -4, 7), direction(0, 1, 0), 1000, new Color(0.2, 0.2, 0.25)));
        scene1.add(new Sphere(point(-2, 1, -5), 1, new Color(0.5, 0.5, 0.6)));
        scene1.add(new Sphere(point(2, 3, -10), 0.3, new Color(1, 1, 1)));
        scene1.add(new Sphere(point(-1, 3, -8), 0.2, new Color(1, 1, 1)));
        scene1.add(new Sphere(point(0, 0, -3), 0.2, new Color(0.8, 0.2, 0.2)));
        scene1.add(new Sphere(point(-3, -0.5, -7), 0.5, new Color(0.7, 0.7, 0.7)));
        scene1.add(new Sphere(point(3, 0.5, -13), 0.5, new Color(0.1, 0.6, 0.1)));
        scene1.add(new Sphere(point(-4, 0, -15), 0.5, new Color(0.7, 0.4, 0.4)));
        scene1.add(new Sphere(point(4, 0, -15), 0.5, new Color(0.4, 0.4, 0.9)));

        // Zweite Szene
        Group scene2 = new Group();
        scene2.add(new Background(new Color(0.05, 0.05, 0.2)));
        scene2.add(new Disc(point(0.0, -0.5, 0.0), direction(0, 1, 0), 100, color(0.498, 0.964, 0.784)));
        scene2.add(new Sphere(point(-1., -0.25, -2.5), 0.7, color(1, 0.498, 0.611)));
        scene2.add(new Sphere(point(0.0, -0.25, -2.5), 0.5, color(0.4)));
        scene2.add(new Sphere(point(1.0, -0.25, -2.5), 0.7, color(0.313, 0.145, 0.564)));

        // Rendering der ersten Szene 
        image1.superSample(new Raytracer(scene1, camera, x0, tMin, tMax), 2, 3);
        final String filename1 = "doc/a04-creative-image.png";
        image1.write(filename1);
        System.out.println("Wrote image: " + filename1);

        // // Rendering der zweiten Szene
        image2.superSample(new Raytracer(scene2, camera2, x0, tMin, tMax), 2, 3);
        final String filename2 = "doc/a04-image.png";
        image2.write(filename2);
        System.out.println("Wrote image: " + filename2);
    }
}