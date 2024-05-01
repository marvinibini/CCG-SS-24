/** @author hartmut.schirmacher@bht-berlin.de && henrik.tramberend@bht-berlin.de */
package cgg.a01;

import static cgtools.Vector.*;
import cgg.*;

public class Main {

  public static void main(String[] args) {
    final int width = 480;
    final int height = 270;


    // Creates an image and iterates over all pixel positions inside the image.

    PolkaDotsColor content = new PolkaDotsColor( color(0, 0.54, 0.53),white, 7, 5, 25);

    Image image = new Image(width, height);
    // Write the image to disk.
    image.superSample(content, 15, 15);

    final String filename = "doc/a01-polka-dots.png";
    image.write(filename);
    System.out.println("Wrote image: " + filename);
  }
}
