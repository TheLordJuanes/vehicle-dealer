package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BSTClientsInChargeTest {

    public final static String SEPARATOR = ";";

    private BSTClientsInCharge clientsInCharge;

    public void setup1() {
        clientsInCharge = new BSTClientsInCharge();
    }

    public void setup2() {
        clientsInCharge = new BSTClientsInCharge();
        Client client = new Client("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false, new BSTFavoriteVehicles());
        clientsInCharge.addAssignedClient(client);
    }

    public void setup3() {
        clientsInCharge = new BSTClientsInCharge();
        clientsInCharge.addAssignedClient(new Client("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 502-4309", "juan@gmail.com", false, false, new BSTFavoriteVehicles()));
        clientsInCharge.addAssignedClient(new Client("Ernesto", "Velez", "49583-72328", "(+57) 301 332-9878", "ernesto@yahoo.com", false, false, new BSTFavoriteVehicles()));
        clientsInCharge.addAssignedClient(new Client("Pablo", "Contreras", "76534-12234", "(+57) 300 988-6754", "pablo@outlook.com", false, false, new BSTFavoriteVehicles()));
        clientsInCharge.addAssignedClient(new Client("Marco", "Silva", "56787-65342", "(+57) 312 286-7232", "marco@hotmail.com", false, false, new BSTFavoriteVehicles()));
        clientsInCharge.addAssignedClient(new Client("Ivan", "Vasquez", "89832-43231", "(+57) 316 789-1293", "ivan@hotmail.com", false, false, new BSTFavoriteVehicles()));
    }

    public void setup4() {
        clientsInCharge = new BSTClientsInCharge();
        clientsInCharge.addAssignedClient(new Client("Juan Esteban", "Caicedo", "397368-45456", "109238-32111", "juan@gmail.com", false, false, new BSTFavoriteVehicles()));
        clientsInCharge.addAssignedClient(new Client("Ernesto", "Velez", "49583-72328", "767432-43551", "ernesto@yahoo.com", false, false, new BSTFavoriteVehicles()));
    }

    @Test
    public void testAddAssignedClient() {
        setup1();
        assertTrue(clientsInCharge.addAssignedClient(new Client("Ernesto", "Velez", "49583-7232", "(+57) 301 332-9878", "ernesto@gmail.com", false, false, new BSTFavoriteVehicles())));
        assertNotNull(clientsInCharge.getRoot());
        assertEquals(1, clientsInCharge.getSize());
        setup2();
        assertFalse(clientsInCharge.addAssignedClient(new Client("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false, new BSTFavoriteVehicles())));
        assertNull(clientsInCharge.getRoot().getRight());
        assertNull(clientsInCharge.getRoot().getLeft());
        assertEquals(1, clientsInCharge.getSize());
        setup3();
        assertFalse(clientsInCharge.addAssignedClient(new Client("Alberto", "Cortes", "26354-93897", "(+57) 313 654-5987", "alberto@gmail.com", false, false, new BSTFavoriteVehicles())));
        assertEquals(5, clientsInCharge.getSize());
    }

    @Test
    public void testSearchClientInCharge() {
        setup4();
        assertNotNull(clientsInCharge.searchClientInCharge("109238-32111"));
        setup4();
        assertNull(clientsInCharge.searchClientInCharge("88113"));
    }

    @Test
    public void testRemoveClientsInCharge() {
        setup3();
        clientsInCharge.removeClientsInCharge("(+57) 301 332-9878");
        assertNull(clientsInCharge.searchClientInCharge("(+57) 301 332-9878"));
        assertEquals(4, clientsInCharge.getSize());
        setup3();
        clientsInCharge.removeClientsInCharge("88113");
        assertEquals(5, clientsInCharge.getSize());
        setup4();
        clientsInCharge.removeClientsInCharge("109238-32111");
        assertNull(clientsInCharge.searchClientInCharge("109238-32111"));
        assertEquals(1, clientsInCharge.getSize());
        setup4();
        clientsInCharge.removeClientsInCharge("88113");
        assertEquals(2, clientsInCharge.getSize());
    }

    @Test
    public void testPrintClientsInCharge() {
        setup2();
        assertEquals("\n\nClient "+ 1 + ":\nLast name" + SEPARATOR + "Name" + SEPARATOR + "ID number" + SEPARATOR + "Active client" + SEPARATOR + "E-mail" + SEPARATOR + "Has seller in charge" + SEPARATOR + "Phone number\n" + "Caicedo " + SEPARATOR + " Juan Esteban " + SEPARATOR + " 397368-45456 " + SEPARATOR + " (+57) 318 302-4309 " + SEPARATOR + " juancaicedo@gmail.com " + SEPARATOR + " " + false + " " + SEPARATOR + " " + false + "\n", clientsInCharge.printClientsInCharge(clientsInCharge.getRoot()));
    }
}