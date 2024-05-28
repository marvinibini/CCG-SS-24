package cgg.a06;

import cgg.*;
import cgtools.*;
import static cgtools.Vector.*;

public class Test {
    public static void main(String[] args) {
        final int width = 1920;
        final int height = 1080;

        Point x0 = new Point(0, 0, 0);
        double tMin = 0;
        double tMax = Double.POSITIVE_INFINITY;
        Matrix matrix = Matrix.identity;
        
        Image image1 = new Image(width, height);
        Camera camera = new Camera(Math.PI / 2, width, height, matrix);


        Group scene2 = new Group();

        scene2.add(new Background(new EmitterMaterial(color(1, 1, 1))));
        scene2.add(new Disc(point(0, -3.25, 0), direction(0, 1, 0), 100,new PerDifMaterial(gray)));

// smiley
        scene2.add(new Sphere(point(0, 0, -10), 2.5, new PerDifMaterial(yellow)));
// Hat    
        scene2.add(new Disc(point(0,1.23,-10), direction(0, 1, 0), 3.3, new PerMirMaterial(color(0.5, 0, 0.5))));
        scene2.add(new ClosedCylinder(point(0,1.2,-10), 2.08, 1.8, new PerMirMaterial(color(0.5, 0, 0.5))));
// Eyes
        scene2.add(new Sphere(point(0.8,0.7,-7.74), 0.4, new PerMirMaterial(color(0.1))));
        scene2.add(new Sphere(point(-0.8,0.7,-7.74), 0.4, new PerMirMaterial(color(0.1))));
// Mouth
        // scene2.add(new Sphere(point(0, -1.5, -8),0.1 , new PerMirMaterial(color(0.1))));

        int anzahlKugeln = 200;
        double radius = 1.5;
        double winkelabstand = 2 * Math.PI / anzahlKugeln;
        for (int i = 0; i < anzahlKugeln; i++) {
            double winkel = i * winkelabstand;
            double x = radius * Math.cos(winkel);
            double y = radius * Math.sin(winkel);
            if (y <= -1.06) {
                
                scene2.add(new Sphere(point(  x,   y, -8 ), 0.15, new PerDifMaterial(color(0.))));
            }
        }

// Trees
        for(double i = -3; i <= 3 ; i = i + 0.5){
            scene2.add(new Sphere(point(i,-3,-13), 0.3, new PerDifMaterial(color(1, Math.random(), Math.random()))));
            scene2.add(new Sphere(point(i,-3,-7), 0.3, new PerDifMaterial(color(1, Math.random(), Math.random()))));
            scene2.add(new Sphere(point(i,3,-13), 0.3, new PerDifMaterial(color(1, Math.random(), Math.random()))));
            scene2.add(new Sphere(point(i,3,-7), 0.3, new PerDifMaterial(color(1, Math.random(), Math.random()))));

            scene2.add(new Sphere(point(-3,i,-7), 0.3, new PerDifMaterial(color(Math.random(), 1, Math.random()))));
            scene2.add(new Sphere(point(-3,i,-13), 0.3, new PerDifMaterial(color(Math.random(), 1, Math.random()))));
            scene2.add(new Sphere(point(3,i,-7), 0.3, new PerDifMaterial(color(Math.random(), 1, Math.random()))));
            scene2.add(new Sphere(point(3,i,-13), 0.3, new PerDifMaterial(color(Math.random(), 1, Math.random()))));        

            scene2.add(new Sphere(point(3,3,i - 10), 0.3, new PerDifMaterial(color(Math.random(), Math.random(), 1))));
            scene2.add(new Sphere(point(-3,3,i - 10), 0.3, new PerDifMaterial(color(Math.random(), Math.random(), 1))));
            scene2.add(new Sphere(point(3,-3,i - 10), 0.3, new PerDifMaterial(color(Math.random(), Math.random(), 1))));
            scene2.add(new Sphere(point(-3,-3,i - 10), 0.3, new PerDifMaterial(color(Math.random(), Math.random(), 1))));
        }



        image1.superSample(new Raytracer(scene2, camera, x0, tMin, tMax, 5), 2, 1);
        final String filename1 = "doc/test.png";
        image1.write(filename1);
        System.out.println("Wrote image: " + filename1);
    }
}
