package cgg.a05;

import cgg.a03.Hit;
import cgg.a03.Ray;
import cgtools.Color;

public record EmitterMaterial(Color emission) implements Material{

   @Override
    public Color albedos() {
        return null;
    }

    @Override
    public boolean gestreut() {
       return false;
    }

    @Override
    public Ray reflecRay(Ray ray, Hit hit) {
      return null;
    }
    
}
