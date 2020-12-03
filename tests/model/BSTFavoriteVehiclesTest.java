package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BSTFavoriteVehiclesTest {

    public final static String SEPARATOR = ";";

    private BSTFavoriteVehicles vehiclesOfInterest;

    public void setup1() {
        vehiclesOfInterest = new BSTFavoriteVehicles();
    }

    public void setup2() {
        vehiclesOfInterest = new BSTFavoriteVehicles();
        Document documents = new Document();
        documents.setFirst(new Soat(121236, 0, "", 905680));
        documents.getFirst().setNext(new Review(544556, 0, "", 0));
        Vehicle favorite = new Gasoline(0, 6543, "BMW", 2020, 65329, 9868, 'N', "", "", documents, 'S', 4, true, 32, 'O', 65);
        vehiclesOfInterest.addFavoriteVehicle(favorite);
    }

    public void setup3() {
        vehiclesOfInterest = new BSTFavoriteVehicles();
        Document documents1 = new Document();
        documents1.setFirst(new Soat(121236, 0, "", 905680));
        documents1.getFirst().setNext(new Review(544556, 0, "", 0));
        Vehicle favorite1 = new Gasoline(0, 6543, "BMW", 2020, 65329, 9868, 'N', "", "", documents1, 'S', 4,
                true, 54325, 'O', 7945824);
        vehiclesOfInterest.addFavoriteVehicle(favorite1);
        Document documents2 = new Document();
        documents2.setFirst(new Soat(45768, 2019, "54678798", 32891));
        documents2.getFirst().setNext(new Review(1098495, 2018, "76898645", 696532));
        Vehicle favorite2 = new Gasoline(0, 6543, "BMW", 2020, 86734, 9868, 'N', "", "", documents2, 'S', 4,
                true, 54325, 'O', 7945824);
        vehiclesOfInterest.addFavoriteVehicle(favorite2);
    }

    @Test
    public void testAddAssignedClient() {
        setup1();
        Document documents1 = new Document();
        documents1.setFirst(new Soat(121236, 0, "", 905680));
        documents1.getFirst().setNext(new Review(544556, 0, "", 0));
        Vehicle favorite = new Gasoline(0, 6543, "BMW", 2020, 65329, 9868, 'N', "", "", documents1, 'S', 4, true,
                54325, 'O', 7945824);
        vehiclesOfInterest.addFavoriteVehicle(favorite);
        assertNotNull(vehiclesOfInterest.getRoot());
        setup2();
        Document documents2 = new Document();
        documents2.setFirst(new Soat(121236, 0, "", 905680));
        documents2.getFirst().setNext(new Review(544556, 0, "", 0));
        Vehicle favorite2 = new Gasoline(0, 6543, "BMW", 2020, 65329, 9868, 'N', "", "", documents2, 'S', 4,
                true, 54325, 'O', 7945824);
        vehiclesOfInterest.addFavoriteVehicle(favorite2);
        assertNull(vehiclesOfInterest.getRoot().getLeft());
        assertNull(vehiclesOfInterest.getRoot().getRight());
    }

    @Test
    public void testSearchClientInCharge() {
        setup3();
        assertNotNull(vehiclesOfInterest.searchFavoriteVehicle(65329));
        setup3();
        assertNull(vehiclesOfInterest.searchFavoriteVehicle(21234));
    }

    @Test
    public void testRemoveClientsInCharge() {
        setup3();
        vehiclesOfInterest.removeFavoriteVehicle(65329);
        assertNull(vehiclesOfInterest.searchFavoriteVehicle(65329));
        setup3();
        vehiclesOfInterest.removeFavoriteVehicle(21234);
        assertNotNull(vehiclesOfInterest.searchFavoriteVehicle(65329));
        assertNotNull(vehiclesOfInterest.searchFavoriteVehicle(86734));
    }

    @Test
    public void testPrintVehiclesOfInterest() {
        setup2();
        assertEquals("\nVehicle of interest " + 1 + ":\nVehicle brand" + SEPARATOR + "Vehicle model" + SEPARATOR + "Vehicle type" + SEPARATOR + "Vehicle base price" + SEPARATOR + "Vehicle license plate" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Vehicle mileage" + SEPARATOR + "Owner ID" + SEPARATOR + "SOAT document code" + SEPARATOR + "SOAT document price" + SEPARATOR + "SOAT document year" + SEPARATOR + "SOAT coverage amount" + SEPARATOR + "Mechanical Technical Review document code" + SEPARATOR + "Mechanical Technical Review document price" + SEPARATOR + "Mechanical Technical Review document year" + SEPARATOR + "Gas level released" + SEPARATOR + "Car type" + SEPARATOR + "Doors number" + SEPARATOR + "Polarized Windows" + SEPARATOR + "Gasoline type" + SEPARATOR + "Gasoline capacity" + SEPARATOR + "Gasoline consume" + SEPARATOR + "Total selling price\n" + "BMW" + SEPARATOR + 2020 + SEPARATOR + 'N' + SEPARATOR + 6543.0 + SEPARATOR + "NONE" + SEPARATOR + 65329.0 + SEPARATOR + 9868.0 + SEPARATOR + "NONE" + SEPARATOR + "NONE" + SEPARATOR + 121236.0 + SEPARATOR + 0 + SEPARATOR + 905680.0 + SEPARATOR + "NONE" + SEPARATOR + 544556.0 + SEPARATOR + 0 + SEPARATOR + 0.0 + SEPARATOR + 'S' + SEPARATOR + 4 + SEPARATOR + true + SEPARATOR + 'O' + SEPARATOR + 32.0 + SEPARATOR + 20905.28 + SEPARATOR + 672335.0 + "\n", vehiclesOfInterest.printVehiclesOfInterest(vehiclesOfInterest.getRoot()));
    }
}