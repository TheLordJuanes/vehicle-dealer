package model;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ListHeadquartersTest {

    private ListHeadquarters headquarters;

    public void setup1() {
        headquarters = new ListHeadquarters();
    }

    public void setup2() {
        headquarters = new ListHeadquarters();
        try {
            headquarters.addHeadquarter("Dealer", "109238-32111", "Avenue 5 # 89-08", 0, 0);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void setup3() {
        headquarters = new ListHeadquarters();
        try {
            headquarters.addHeadquarter("Dealer", "109238-32111", "Avenue 5 # 89-08", 0, 0);
            headquarters.addHeadquarter("Dealer", "767432-43551", "Avenue 5 # 89-08", 0, 0);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void testAddHeadquarter() {
        try {
            setup1();
            assertTrue(headquarters.addHeadquarter("Dealer", "109238-32111", "Avenue 5 # 89-08", 0, 0));
            assertNotNull(headquarters.getFirst());
            setup2();
            assertFalse(headquarters.addHeadquarter("Dealer", "109238-32111", "Avenue 5 # 89-08", 0, 0));
        } catch (IOException ioe) {
            fail("IOException not expected.");
        }
    }

    @Test
    public void testSearchHeadquarter() {
        setup2();
        assertNotNull(headquarters.searchHeadquarter("109238-32111"));
        setup3();
        assertNull(headquarters.searchHeadquarter("88113"));
    }

    @Test
    public void testRemoveHeadquarter() {
        try {
            setup3();
            assertTrue(headquarters.removeHeadquarter("109238-32111"));
            assertNull(headquarters.searchHeadquarter("109238-32111"));
            setup3();
            assertFalse(headquarters.removeHeadquarter("88113"));
            assertNotNull(headquarters.searchHeadquarter("109238-32111"));
            assertNotNull(headquarters.searchHeadquarter("767432-43551"));
        } catch (IOException ioe) {
            fail("IOException not expected.");
        }
    }
}