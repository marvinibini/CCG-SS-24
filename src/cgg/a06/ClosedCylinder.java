package cgg.a06;

import cgtools.*;

public record ClosedCylinder(Point pos, double rad, double height, Material mat) implements Shape{
    
    @Override
    public Hit intersect(Ray r) {
        Group groupe = new Group();
        groupe.add(new OpenCylinder(pos, rad, height, mat));
        groupe.add(new Disc(Vector.point(pos.x(), pos.y() + height, pos.z()), Vector.direction(0, 1, 0), rad, mat));
        groupe.add(new Disc(pos, Vector.direction(0, -1, 0), rad, mat));
        return groupe.intersect(r);
    }
}