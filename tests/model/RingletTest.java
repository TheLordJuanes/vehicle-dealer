/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RingletTest {

    private Ringlet ringlet;

    public void setup1() {
        ringlet = new Ringlet();
    }

    public void setup2() {
        ringlet = new Ringlet();
        ringlet.addSquare(0);
    }

    @Test
    public void testAddSquare() {
        setup1();
        ringlet.addSquare(0);
        assertEquals(1, ringlet.getSquares().size(), "The square wasn't added to the list of squares of the ringlet.");
    }

    @Test
    public void testRotateSquares() {
        setup2();
        ringlet.rotateSquares();
        assertNotEquals(0, ringlet.getSquares().get(0).getRotation());
    }
}