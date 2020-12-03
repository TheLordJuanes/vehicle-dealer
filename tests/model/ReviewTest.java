package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ReviewTest {

    private Review review;

    public void setup1() {
        review = new Review(128345, 0, "", 0);
    }

    public void setup2() {
        review = new Review(128345, 2018, "94583257", 37824);
    }

    @Test
    public void testDecodeCode() {
        setup1();
        assertNotEquals(review.decodeCode(), "", "The review document code is still empty.");
        setup2();
        assertNotEquals(review.decodeCode(), "94583257", "The review document code is still empty.");
    }

    @Test
    public void testToString() {
        String separator = ";";
        setup1();
        assertEquals("NONE" + separator + 128345.0 + separator + 0 + separator + 0.0, review.toString(separator), "The review document information isn't the same one.");
        setup2();
        assertEquals("94583257" + separator + 128345.0 + separator + 2018 + separator + 37824.0, review.toString(separator), "The review document information isn't the same one.");
    }
}