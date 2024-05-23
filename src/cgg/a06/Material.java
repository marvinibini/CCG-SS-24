package cgg.a06;

import cgtools.*;;

public interface Material {
    public Color emission();
    public Color albedos();
    public boolean gestreut();
    public Ray reflecRay(Ray ray, Hit hit);
}
