/** @author hartmut.schirmacher@bht-berlin.de && henrik.tramberend@bht-berlin.de */
package cgg;

import cgtools.*;

public class Image {

  public int width = 0;
  public int height = 0;
  private double[] data;

  public Image(int width, int height) {
    this.width = width;
    this.height = height;
    data = new double[width * height * 3];
  }

  public void setPixel(int i, int j, Color color) {
    data[((j * width + i) * 3 + 0)] = gammaCorrect(color.r());
    data[((j * width + i) * 3 + 1)] = gammaCorrect(color.g());
    data[((j * width + i) * 3 + 2)] = gammaCorrect(color.b());
  }

  private double gammaCorrect(double value) {
    if (value < 0)
      value = 0; // Verhindern von negativen Farbwerten
    if (value > 1)
      value = 1; // Verhindern von Clipping
    return Math.pow(value, 1.0 / 2.2); // Gammakorrektur für einen Gamma-Wert von 2.2
  }

  public void write(String filename) {
    try {
      ImageWriter.write(filename, data, width, height);
    } catch (Exception e) {
      System.err.println("Fehler beim Schreiben des Bildes in die Datei: " + e.getMessage());
      System.exit(1);
    }
  }

  public void sample(Sampler sampler, int samplesPerDimension) {
    for (int j = 0; j < height; j++) {
      for (int i = 0; i < width; i++) {
        Color avgColor = new Color(0, 0, 0);
        for (int dy = 0; dy < samplesPerDimension; dy++) {
          for (int dx = 0; dx < samplesPerDimension; dx++) {
            double offsetX = (dx + Random.random()) / samplesPerDimension;
            double offsetY = (dy + Random.random()) / samplesPerDimension;
            double sampleX = i + offsetX;
            double sampleY = j + offsetY;
            Color sampledColor = sampler.getColor(sampleX, sampleY);
            avgColor = new Color(
                avgColor.r() + sampledColor.r() / (samplesPerDimension * samplesPerDimension),
                avgColor.g() + sampledColor.g() / (samplesPerDimension * samplesPerDimension),
                avgColor.b() + sampledColor.b() / (samplesPerDimension * samplesPerDimension));
          }
        }
        setPixel(i, j, avgColor);
      }
    }
  }

  public void superSample(Sampler content, int n, int m) {
    setPixel(80, 135, content.getColor(240, 200));
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        double rotGanz = 0;
        double gruenGanz = 0;
        double blauGanz = 0;
        for (int i = 0; i < m; i++) {
          for (int xi = 0; xi < n; xi++) {
            for (int yi = 0; yi < n; yi++) {
              double rx = cgtools.Random.random();
              double ry = cgtools.Random.random();
              double xs = x + (xi + rx) / n;
              double ys = y + (yi + ry) / n;
              Color pixelColor = content.getColor(xs, ys);
              rotGanz = rotGanz + pixelColor.r();
              gruenGanz = gruenGanz + pixelColor.g();
              blauGanz = blauGanz + pixelColor.b();

            }
          }
        }
        rotGanz = rotGanz / (n * n * m);
        gruenGanz = gruenGanz / (n * n * m);
        blauGanz = blauGanz / (n * n * m);
        Color color = new Color(rotGanz, gruenGanz, blauGanz);
        setPixel(x, y, color);
      }
    }
  }
}
