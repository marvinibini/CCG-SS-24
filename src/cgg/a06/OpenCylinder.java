package cgg.a06;

import cgtools.*;

public record OpenCylinder(Point pos, double radX, double height, Material mat) implements Shape {

    public Hit intersect(Ray ray) {

        Direction dir = Vector.subtract(ray.x0(), pos);

        double a = ray.direction().x() * ray.direction().x() + ray.direction().z() * ray.direction().z();
        double b = 2 * (ray.direction().x() * dir.x() + ray.direction().z() * dir.z());
        double c = dir.x() * dir.x() + dir.z() * dir.z() - radX * radX;

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) return null;

        double t1 = (-b - Math.sqrt(discriminant)) / (2 * a);
        double t2 = (-b + Math.sqrt(discriminant)) / (2 * a);

        double t = (t1 >= ray.tMin() && t1 <= ray.tMax()) ? t1 : (t2 >= ray.tMin() && t2 <= ray.tMax()) ? t2 : -1;
        if (!ray.isValid(t)) return null;

        if (ray.pointAt(t).y() < pos.y() || ray.pointAt(t).y() > pos.y() + height) 
        
            return null;

        return new Hit(t, ray.pointAt(t), Vector.normalize(Vector.subtract(ray.pointAt(t), pos)), mat);
    }
}

//     @Override
//     public Hit intersect(Ray r) {
        
//         Hit hit = null;
//         Direction d = r.direction();
//         double t = 0;
//         Direction direction = r.direction();
//         double a =  direction.x() * direction.x() + direction.z() * direction.z();
//         double b =  2 * (r.x0().x() * r.x0().z()) * (direction.x() * direction.z());
//         double c =  (r.x0().x() * r.x0().z()) * (r.x0().x() * r.x0().z()) -(radius * radius);
        
//         double discriminant = b * b - 4 * a * c;
//         if(discriminant == 0){
//             t = (-b + Math.sqrt(discriminant))/(2*a);
//             if(t >= r.tMin() && t <= r.tMax()){
//                 Point x = add(r.x0(), (multiply(d, t)));
//                 Direction nullVector = normalize(divide((subtract(x, r.))), radius));
//                 hit = new Hit(t, x, nullVector, material);
//             }
//         }
//         else if(discriminant > 0){
//             double tPlus = (-b + Math.sqrt(discriminant))/(2*a);
//             double tMinus = (-b - Math.sqrt(discriminant))/(2*a);
//             if(r.isValid(tPlus) == true && r.isValid(tMinus) == true){
//                 if(tPlus < tMinus){
//                     t = tPlus;
//                 }
//                 else{
//                     t = tMinus;
//                 }           
//             Point x = r.pointAt(t);
//             Direction nullVector = normalize(divide((subtract(x, r.))), radius));
//             hit = new Hit(t, x, nullVector, material);
//             }
//             else if(r.isValid(tMinus) == true){
//                 t = tMinus;
//                 Point x = r.pointAt(t);
//                 Direction nullVector =normalize(divide((subtract(x, r.))), radius));
//                 hit = new Hit(t, x, nullVector, material);
//             }
//             else if(r.isValid(tPlus) == true){
//                 t = tPlus;
//                 Point x = r.pointAt(t);
//                 Direction nullVector = normalize(divide((subtract(x, r.))), radius));
//                 hit = new Hit(t, x, nullVector, material);
//             }
//         }
//         return hit;
//     }
    
// }