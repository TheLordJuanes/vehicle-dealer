package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HybridTest {

    public final static String SEPARATOR = ";";

    private Hybrid hybrid;

    public void setup1() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
        hybrid = new Hybrid(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0);
    }

    public void setup2() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2018, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2020, "76542235", 98989));
        hybrid = new Hybrid(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0);
    }

    public void setup3() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2020, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2017, "76542235", 98989));
        hybrid = new Hybrid(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0);
    }

    public void setup4() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2020, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2020, "76542235", 98989));
        hybrid = new Hybrid(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0);
    }

    public void setup5() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        hybrid = new Hybrid(0, 57849439, "BMW", 2020, 65329, 9868, 'N', "", "", documents, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0);
    }

    public void setup6() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        hybrid = new Hybrid(0, 57849439, "BMW", 2020, 65329, 9868, 'N', "", "", documents, 'S', 4, true, 34682, 'O', 0, 'F', 7634, 0);
    }

    public void setup7() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        hybrid = new Hybrid(0, 57849439, "BMW", 2020, 4736, 9868, 'N', "", "", documents, 'S', 4, true, 32, 'O', 0, 'F', 55, 0);
    }

    public void setup8() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        hybrid = new Hybrid(0, 57849439, "BMW", 2020, 8769, 9868, 'N', "", "", documents, 'S', 4, true, 32, 'O', 0, 'N', 44, 0);
    }

    @Test
    public void testCalculateConsumeGasoline() {
        setup6();
        assertEquals(2.2657403779999997E7, hybrid.getConsumeGasoline());
    }

    @Test
    public void testCalculateConsumeBattery() {
        setup7();
        assertEquals(2604.8, hybrid.getConsumeBattery());
        setup8();
        assertEquals(4296.8099999999995, hybrid.getConsumeBattery());
    }

    @Test
    public void testGetTotalPrice() {
        setup1();
        assertEquals(5.497268767649999E7, hybrid.getTotalPrice());
        setup2();
        assertEquals(5.4232558762499996E7, hybrid.getTotalPrice());
        setup3();
        assertEquals(5.46268813425E7, hybrid.getTotalPrice());
        setup4();
        assertEquals(5.38867524285E7, hybrid.getTotalPrice());
        setup5();
        assertEquals(6.729251564999999E7, hybrid.getTotalPrice());
    }

    @Test
    public void testToString() {
        setup6();
        assertEquals("BMW" + SEPARATOR + 2020 + SEPARATOR + 'N' + SEPARATOR + 57849439.0 + SEPARATOR + "NONE" + SEPARATOR + 65329.0 + SEPARATOR + 9868.0 + SEPARATOR + "NONE" + SEPARATOR + "NONE" + SEPARATOR + 121236.0 + SEPARATOR + 0 + SEPARATOR + 905680.0 + SEPARATOR + "NONE" + SEPARATOR + 544556.0 + SEPARATOR + 0 + SEPARATOR + 0.0 + SEPARATOR + 'S' + SEPARATOR + 4 + SEPARATOR + true + SEPARATOR + 'O' + SEPARATOR + 34682.0 + SEPARATOR + 2.2657403779999997E7 + SEPARATOR + 'F' + SEPARATOR + 7634.0 + SEPARATOR + 4987215.859999999 + SEPARATOR + 5.8515231E7, hybrid.toString(SEPARATOR));
    }
}