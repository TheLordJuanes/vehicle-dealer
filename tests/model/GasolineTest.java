package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GasolineTest {

    public final static String SEPARATOR = ";";

    private Gasoline gasoline;

    public void setup1() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
        gasoline = new Gasoline(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 32, 'O', 0);
    }

    public void setup2() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2018, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2020, "76542235", 98989));
        gasoline = new Gasoline(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 32, 'O', 0);
    }

    public void setup3() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2020, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2017, "76542235", 98989));
        gasoline = new Gasoline(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 32, 'O', 0);
    }

    public void setup4() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2020, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2020, "76542235", 98989));
        gasoline = new Gasoline(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 32, 'O', 0);
    }

    public void setup5() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        gasoline = new Gasoline(0, 57849439, "BMW", 2020, 65329, 9868, 'N', "", "", documents, 'S', 4, true, 32, 'O', 0);
    }

    public void setup6() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        gasoline = new Gasoline(0, 57849439, "BMW", 2020, 4736, 9868, 'N', "", "", documents, 'S', 4, true, 34682, 'O', 0);
    }

    @Test
    public void testCalculateConsumeGasoline() {
        setup6();
        assertEquals(1642539.52, gasoline.getConsumeGasoline());
    }

    @Test
    public void testGetTotalPrice() {
        setup1();
        assertEquals(4.780233711E7, gasoline.getTotalPrice());
        setup2();
        assertEquals(4.715874675E7, gasoline.getTotalPrice());
        setup3();
        assertEquals(4.750163595E7, gasoline.getTotalPrice());
        setup4();
        assertEquals(4.685804559E7, gasoline.getTotalPrice());
        setup5();
        assertEquals(5.8515231E7, gasoline.getTotalPrice());
    }

    @Test
    public void testToString() {
        setup6();
        assertEquals("BMW" + SEPARATOR + 2020 + SEPARATOR + 'N' + SEPARATOR + 57849439.0 + SEPARATOR + "NONE" + SEPARATOR + 4736.0 + SEPARATOR + 9868.0 + SEPARATOR + "NONE" + SEPARATOR + "NONE" + SEPARATOR + 121236.0 + SEPARATOR + 0 + SEPARATOR + 905680.0 + SEPARATOR + "NONE" + SEPARATOR + 544556.0 + SEPARATOR + 0 + SEPARATOR + 0.0 + SEPARATOR + 'S' + SEPARATOR + 4 + SEPARATOR + true + SEPARATOR + 'O' + SEPARATOR + 34682.0 + SEPARATOR + 1642539.52 + SEPARATOR + 5.8515231E7, gasoline.toString(SEPARATOR));
    }
}