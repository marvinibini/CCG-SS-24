package cgg.a06;

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
        Matrix matrix = Matrix.identity;
        
        Image image1 = new Image(width, height);

        //camera.setmatrix(Matrix.translation(point(0,0,-10)));
        // matrix = Matrix.multiply(matrix,(Matrix.rotation(0, 1, 0, 90)));
        // matrix = Matrix.multiply(matrix,(Matrix.translation(point(0,10,10))));
        // Point testx = Matrix.multiply(matrix, x0);
        matrix = Matrix.multiply(matrix,Matrix.rotation( zAxis, 45));

        Camera camera = new Camera(Math.PI / 2.6, width, height, matrix);


        Group scene1 = new Group();

        scene1.add(new Background(new EmitterMaterial(color(1, 1, 1))));
        scene1.add(new Disc(point(0.0, -0.5, 0.0), direction(0, 1, 0), 100,new PerDifMaterial(gray)));
        scene1.add(new Sphere(point(0, -0.02, -3.5), .5, new PerDifMaterial(red)));
 

        image1.superSample(new Raytracer(scene1, camera, x0, tMin, tMax, 5), 2, 1);
        final String filename1 = "doc/a06-cam-rotation.png";
        image1.write(filename1);
        System.out.println("Wrote image: " + filename1);

        Matrix matrix2 = Matrix.identity;
        Image image2 = new Image(width, height);
        Camera camera2 = new Camera(Math.PI / 2, width, height, matrix2);

        Group scene2 = new Group();

        scene2.add(new Background(new EmitterMaterial(color(1))));
        scene2.add(new Disc(point(0.0, -3.25, 0.0), direction(0, 1, 0),Double.POSITIVE_INFINITY, new PerDifMaterial(color(0.1))));
        scene2.add(Baum(point(0,-3.25,-30)));
        for(int i = 0; i < 20 ; i++){
            scene2.add(Baum(point(Math.random() * 70 - 35 , -3.25, Math.random() * 15- 45)));
        }      
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


        image2.superSample(new Raytracer(scene2, camera2, x0, tMin, tMax, 7), 7, 3);
        final String filename2 = "doc//a06-20plus.png";
        image2.write(filename2);
        System.out.println("Wrote image: " + filename2);
    }
   
    
    public static Group Baum(Point point){
        Group baum = new Group();
        int anzahlKugeln = 8;
        double radius = 1.5;
        double winkelabstand = 2 * Math.PI / anzahlKugeln;

        baum.add(new ClosedCylinder(point, 1, 5, new PerDifMaterial(color(0.633, 0.406,0.155))));
        for (int i = 0; i < anzahlKugeln; i++) {
            double winkel = i * winkelabstand;
            double x = radius * Math.cos(winkel);
            double z = radius * Math.sin(winkel);
            baum.add(new Sphere(point(point.x() + x, point.y() + 5,point.z() + z), 1.2, new PerDifMaterial(color(0.235,0.388,0.196))));
        }
        for (int i = 0; i < 7; i++) {
            baum.add(new Sphere(point((point.x() + (Random.random() * 2.2 - 1.1)), (point.y() + 5.5 + (Random.random())),(point.z() + (Random.random() * 2.2 - 1.1))), 1, new PerMirMaterial(color(0.335,0.488,0.296))));
        }
        return baum;
    }
}
