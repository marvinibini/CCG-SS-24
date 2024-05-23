package cgg.a06;

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
