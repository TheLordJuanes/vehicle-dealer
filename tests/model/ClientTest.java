package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClientTest {

    private Client client;

    public void setup1() {
        client = new Client("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false, new BSTFavoriteVehicles());
    }

    @Test
    public void testToString() {
        String separator = ";";
        setup1();
        assertEquals("Caicedo " + separator + " Juan Esteban " + separator + " 397368-45456 " + separator + " (+57) 318 302-4309 " + separator + " juancaicedo@gmail.com " + separator + " " + false + " " + separator + " " + false, client.toString(separator), "The client information isn't the same one.");
    }
}