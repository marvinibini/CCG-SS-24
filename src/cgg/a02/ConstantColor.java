/** @author henrik.tramberend@bht-berlin.de */
package cgg.a02;

import cgtools.*;

// Represents the contents of an image.
// Provides the same color for all pixels.
public class ConstantColor implements Sampler {
  Color color;

  ConstantColor(Color color) {
    this.color = color;
  }

  // Returns the color for the given position.
  @Override
  public Color getColor(double x, double y) {
    return color;
  }
}