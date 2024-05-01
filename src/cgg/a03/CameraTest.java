package cgg.a03;

import static cgtools.Vector.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class CameraTest {

    @Test
    public void test0() {
        Camera camera = new Camera((Math.PI/2), 10, 10);
        assertEquals(camera.samplingPoint(0,0), direction(-1/Math.sqrt(3), 1/Math.sqrt(3), -1/Math.sqrt(3)));
    }

    @Test
    public void test1() {
        Camera camera = new Camera((Math.PI/2), 10, 10);
        assertEquals(camera.samplingPoint(5,5), direction(0,0,-1));
    }

    @Test
    public void test2() {
        Camera camera = new Camera((Math.PI/2), 10, 10);
        assertEquals(camera.samplingPoint(10,10), direction(1/Math.sqrt(3), -1/Math.sqrt(3), -1/Math.sqrt(3)));
    }
}
