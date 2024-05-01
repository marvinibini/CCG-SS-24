package cgg.a02;

import cgtools.Color;

public class Disc {
    private double centerX;
    private double centerY;
    public double radius;
    private Color color;

    public Disc(double centerX, double centerY, double radius, Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.color = color;
    }

    public boolean isPointInDisc(double x, double y) {
        double dx = x - this.centerX;
        double dy = y - this.centerY;
        return dx * dx + dy * dy <= radius * radius;
    }

    public double centerX() {
        return centerX;
    }

    public double centerY() {
        return centerY;
    }

    public double radius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }
}