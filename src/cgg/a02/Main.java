package cgg.a02;

import cgg.Image;

public class Main {
  public static void main(String[] args) {

    final int width = 960;
    final int height = 540;

    Image image = new Image(width, height);

    // Beispiel mit farbigen Scheiben und Stratified Sampling
    image.sample(new ColoredDiscs(75), 10);  // 10x10 Stratified Sampling
    
    
        // Write the image to disk.
        final String filename = "doc/a02-stratified.png";
        image.write(filename);
        System.out.println("Wrote image: " + filename);
      }
}