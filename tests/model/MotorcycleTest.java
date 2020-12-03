package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MotorcycleTest {

    public final static String SEPARATOR = ";";

    private Motorcycle motorcycle;

    public void setup1() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
        motorcycle = new Motorcycle(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'D', 32, 0);
    }

    public void setup2() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2018, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2020, "76542235", 98989));
        motorcycle = new Motorcycle(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'D', 32, 0);
    }

    public void setup3() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2020, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2017, "76542235", 98989));
        motorcycle = new Motorcycle(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'D', 32, 0);
    }

    public void setup4() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2020, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2020, "76542235", 98989));
        motorcycle = new Motorcycle(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'D', 32, 0);
    }

    public void setup5() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        motorcycle = new Motorcycle(0, 57849439, "BMW", 2020, 65329, 9868, 'N', "", "", documents, 'D', 32, 0);
    }

    public void setup6() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        motorcycle = new Motorcycle(0, 57849439, "BMW", 2020, 4736, 9868, 'N', "", "", documents, 'D', 34682, 0);
    }

    @Test
    public void testCalculateConsumeGasoline() {
        setup6();
        assertEquals(1825043.911111111, motorcycle.getConsumeGasoline());
    }

    @Test
    public void testGetTotalPrice() {
        setup1();
        assertEquals(5.4133491091680005E7, motorcycle.getTotalPrice());
        setup2();
        assertEquals(5.3404660764000006E7, motorcycle.getTotalPrice());
        setup3();
        assertEquals(5.3792963733600006E7, motorcycle.getTotalPrice());
        setup4();
        assertEquals(5.306413340592001E7, motorcycle.getTotalPrice());
        setup5();
        assertEquals(6.085584024E7, motorcycle.getTotalPrice());
    }

    @Test
    public void testToString() {
        setup6();
        assertEquals("BMW" + SEPARATOR + 2020 + SEPARATOR + 'N' + SEPARATOR + 57849439.0 + SEPARATOR + "NONE" + SEPARATOR + 4736.0 + SEPARATOR + 9868.0 + SEPARATOR + "NONE" + SEPARATOR + "NONE" + SEPARATOR + 121236.0 + SEPARATOR + 0 + SEPARATOR + 905680.0 + SEPARATOR + "NONE" + SEPARATOR + 544556.0 + SEPARATOR + 0 + SEPARATOR + 0.0 + SEPARATOR + 'D' + SEPARATOR + 34682.0 + SEPARATOR + 1825043.911111111 + SEPARATOR + 5.8515231E7, motorcycle.toString(SEPARATOR));
    }
}