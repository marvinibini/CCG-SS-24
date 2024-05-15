package cgg.a05;

import cgg.a03.*;
import cgtools.*;;

public interface Material {
    public Color emission();
    public Color albedos();
    public boolean gestreut();
    public Ray reflecRay(Ray ray, Hit hit);
}
