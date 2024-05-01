package cgg.a02;

import cgtools.Color;
import cgtools.Random;
import cgtools.Sampler;

import java.util.List;
import java.util.ArrayList;

public class ColoredDiscs implements Sampler {
    private List<Disc> discs;

    public ColoredDiscs(int numberOfDiscs) {
        discs = new ArrayList<>();

        for (int i = 0; i < numberOfDiscs; i++) {

            double x = Random.random() * 960; // Beispielhafte Breite
            double y = Random.random() * 540; // Beispielhafte Höhe
            double radius = 5 + Random.random() * 85; // Radius zwischen 5 und 50
            Color color = new Color(Random.random(), Random.random(), Random.random());
            Disc disc = new Disc(x, y, radius, color);
            discs.add(disc);
        }

        // Sortieren der Scheiben, damit größere Scheiben zuerst gezeichnet werden
        discs.sort((d1, d2) -> Double.compare(d2.radius, d1.radius));
    }    

    @Override
    public Color getColor(double x, double y) {

        Color result = new Color(0, 0, 0); // Starte mit Schwarz als Hintergrund

        for (Disc disc : discs) {
            if (disc.isPointInDisc(x, y)) {
                Color discColor = disc.getColor();
                
                result = new Color(
                    Math.min(result.r() + 0.5 * discColor.r(), 1.0),
                    Math.min(result.g() + 0.5 * discColor.g(), 1.0),
                    Math.min(result.b() + 0.5 * discColor.b(), 1.0)
                ); // Additive Farbmischung mit Begrenzung und Reduktion der Intensität
                // result = disc.getColor();
            }
        }
        return result;
    }    
}
