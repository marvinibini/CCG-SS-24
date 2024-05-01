package cgg.a03;

import static cgtools.Vector.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;


public class SphereTest {

    @Test
    public void test0() {
        Sphere sphere = new Sphere(point(0, 0, -2), 1, white);
        Ray ray = new Ray(point(0, 0, 0), direction(0, 0, -1), 0, Double.POSITIVE_INFINITY);

        Hit hit = sphere.intersect(ray);
        assertNotNull(hit, "ok");

        assertEquals(point(0, 0, -1), hit.x());
        assertNotNull(sphere.intersect(ray), "Ray should not intersect with the sphere");
        assertEquals(direction(0, 0, 1), hit.n());
    }

    @Test
    public void test1() {
        Sphere sphere = new Sphere(point(0, 0, -2), 1, white);
        Ray ray = new Ray(point(0, 0, 0), direction(0, 1, -1), 0, Double.POSITIVE_INFINITY);
        assertNull(sphere.intersect(ray), "Ray should not intersect with the sphere");
    }

    @Test
    public void test2() {
        Sphere sphere = new Sphere(point(0, -1, -2), 1, white);
        Ray ray = new Ray(point(0, 0, 0), direction(0, 0, -1), 0, Double.POSITIVE_INFINITY);

        Hit hit = sphere.intersect(ray);
        assertNotNull(hit, "ok");

        assertEquals(point(0, 0, -2), hit.x());
        assertNotNull(sphere.intersect(ray), "Ray should not intersect with the sphere");
        assertEquals(direction(0, 1, 0), hit.n());
    }

    @Test
    public void test3() {
        Sphere sphere = new Sphere(point(0, 0, -2), 1, white);
        Ray ray = new Ray(point(0, 0, -4), direction(0, 0, -1), 0, Double.POSITIVE_INFINITY);
        assertNull(sphere.intersect(ray), "Ray should not intersect with the sphere");
    }

    @Test
    public void test4() {
        Sphere sphere = new Sphere(point(0, 0, -4), 1, white);
        Ray ray = new Ray(point(0, 0, 0), direction(0, 0, -1), 0, 2);
        assertNull(sphere.intersect(ray), "Ray should not intersect with the sphere");
    }
}