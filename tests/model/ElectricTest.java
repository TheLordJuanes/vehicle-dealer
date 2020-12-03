package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ElectricTest {

    public final static String SEPARATOR = ";";

    private Electric electric;

    public void setup1() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
        electric = new Electric(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 'F', 7634, 0);
    }

    public void setup2() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2018, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2020, "76542235", 98989));
        electric = new Electric(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 'F', 7634, 0);
    }

    public void setup3() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2020, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2017, "76542235", 98989));
        electric = new Electric(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 'F', 7634, 0);
    }

    public void setup4() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 2020, "47983432", 905680));
        documents.getFirst().setNext(new Review(544556, 2020, "76542235", 98989));
        electric = new Electric(0, 57849439, "BMW", 2020, 65329, 9868, 'U', "", "", documents, 'S', 4, true, 'F', 7634, 0);
    }

    public void setup5() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        electric = new Electric(0, 57849439, "BMW", 2020, 65329, 9868, 'N', "", "", documents, 'S', 4, true, 'F', 7634, 0);
    }

    public void setup6() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        electric = new Electric(0, 57849439, "BMW", 2020, 4736, 9868, 'N', "", "", documents, 'S', 4, true, 'F', 55, 0);
    }

    public void setup7() {
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        electric = new Electric(0, 57849439, "BMW", 2020, 8769, 9868, 'N', "", "", documents, 'S', 4, true, 'N', 44, 0);
    }

    @Test
    public void testCalculateConsumeBattery() {
        setup6();
        assertEquals(3078.4, electric.getConsumeBattery());
        setup7();
        assertEquals(5173.71, electric.getConsumeBattery());
    }

    @Test
    public void testGetTotalPrice() {
        setup1();
        assertEquals(5.7362804532E7, electric.getTotalPrice());
        setup2();
        assertEquals(5.65904961E7, electric.getTotalPrice());
        setup3();
        assertEquals(5.700196314E7, electric.getTotalPrice());
        setup4();
        assertEquals(5.6229654708000004E7, electric.getTotalPrice());
        setup5();
        assertEquals(7.02182772E7, electric.getTotalPrice());
    }

    @Test
    public void testToString() {
        setup6();
        assertEquals("BMW" + SEPARATOR + 2020 + SEPARATOR + 'N' + SEPARATOR + 57849439.0 + SEPARATOR + "NONE" + SEPARATOR + 4736.0 + SEPARATOR + 9868.0 + SEPARATOR + "NONE" + SEPARATOR + "NONE" + SEPARATOR + 121236.0 + SEPARATOR + 0 + SEPARATOR + 905680.0 + SEPARATOR + "NONE" + SEPARATOR + 544556.0 + SEPARATOR + 0 + SEPARATOR + 0.0 + SEPARATOR + 'S' + SEPARATOR + 4 + SEPARATOR + true + SEPARATOR + 'F' + SEPARATOR + 55.0 + SEPARATOR + 3078.4 + SEPARATOR + 5.8515231E7, electric.toString(SEPARATOR));
    }
}