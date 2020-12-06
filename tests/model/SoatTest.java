/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SoatTest {

    private Soat soat;

    public void setup1() {
        soat = new Soat(932443, 0, "", 83921);
    }

    public void setup2() {
        soat = new Soat(932443, 2019, "94583257", 83921);
    }

    @Test
    public void testDecodeCode() {
        setup1();
        assertNotEquals(soat.decodeCode(), "", "The soat document code is still empty.");
        setup2();
        assertNotEquals(soat.decodeCode(), "94583257", "The soat document code is still empty.");
    }

    @Test
    public void testToString() {
        String separator = ";";
        setup1();
        assertEquals("NONE" + separator + 932443.0 + separator + 0 + separator + 83921.0, soat.toString(separator), "The soat document information isn't the same one.");
        setup2();
        assertEquals("94583257" + separator + 932443.0 + separator + 2019 + separator + 83921.0, soat.toString(separator), "The soat document information isn't the same one.");
    }
}