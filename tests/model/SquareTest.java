/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SquareTest {

    private Square square;

    public void setup1() {
        square = new Square(0);
    }

    @Test
    public void testRotate() {
        setup1();
        square.rotate();
        assertNotEquals(0, square.getRotation());
    }
}