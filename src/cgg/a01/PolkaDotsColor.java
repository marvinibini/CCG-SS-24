package cgg.a01;


import cgtools.*;
import cgtools.Color;

public record PolkaDotsColor(Color color, Color colorBack, int anzahl, int reihen, int grosse) implements Sampler {
    
    public Color getColor(double x, double y){
        double widthAnzahl = 480/(anzahl);
        double heightReihen = 270/(reihen);
        
        for(int i = 1; i <= reihen; i++){
            for(int j = 1; j <= anzahl; j++){
                    double sum = Math.pow(x - (widthAnzahl * j - (widthAnzahl / 2)),2) + Math.pow(y -(heightReihen * i - (heightReihen / 2)) ,2);
                    if(-(Math.pow(grosse,2))<= sum && sum <= (Math.pow(grosse, 2)) ){
                    return color;
                    }
            }
        }
        return colorBack;
    }
    
}
