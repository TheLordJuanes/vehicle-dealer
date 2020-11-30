/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.IOException;
import java.io.Serializable;

public class BSTFavoriteVehicles implements Serializable {

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;
    public final static String SEPARATOR = " | ";

    // -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

    private Vehicle root;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    public BSTFavoriteVehicles() {
    }

    public Vehicle getRoot() {
        return root;
    }

    public void setRoot(Vehicle root) {
        this.root = root;
    }

    /**
     * Name: addFavoriteVehicle
     * Method used to add a Vehicle of interest as node in a binary search tree. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> Adding process of a Vehicle of interest in the binary search tree determined. <br>
     * @param favorite - Vehicle in which a client is potentially interested in buying it.
     * @throws IOException
    */
    public void addFavoriteVehicle(Vehicle favorite) {
        if (root == null) {
            root = favorite;
        } else
            addFavoriteVehicle(root, favorite);
    }

    /**
     * Name: addFavoriteVehicle
     * Recursive method used to add a new Vehicle of interest as node in a binary search tree, when the root is different from null. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> Adding process of a Vehicle of interest in the binary search tree determined. <br>
     * @param current - Current Vehicle - current = Vehicle object, current != null
     * @param newVehicle - Vehicle of interest in question to be added - newVehicle = Vehicle object, newVehicle != null
     * @throws IOException
    */
    private void addFavoriteVehicle(Vehicle current, Vehicle newVehicle) {
        if (newVehicle.getCylinder() < current.getCylinder()) {
            if (current.getLeft() == null) {
                current.setLeft(newVehicle);
                newVehicle.setParent(current);
            } else
                addFavoriteVehicle(current.getLeft(), newVehicle);
        } else {
            if (current.getRight() == null) {
                current.setRight(newVehicle);
                newVehicle.setParent(current);
            } else
                addFavoriteVehicle(current.getRight(), newVehicle);
        }
    }

    public Vehicle searchFavoriteVehicle(double cylinder) {
        Vehicle objSearch = null;
        if (root != null)
            objSearch = searchFavoriteVehicle(root, cylinder);
        return objSearch;
    }

    private Vehicle searchFavoriteVehicle(Vehicle current, double cylinder) {
        Vehicle objSearch = null;
        if (current.getCylinder() == cylinder)
            objSearch = current;
        else if (cylinder < current.getCylinder() && current.getLeft() != null)
            objSearch = searchFavoriteVehicle(current.getLeft(), cylinder);
        else if (cylinder > current.getCylinder() && current.getRight() != null)
            objSearch = searchFavoriteVehicle(current.getRight(), cylinder);
        return objSearch;
    }

    public void removeFavoriteVehicle(double cylinder) {
        Vehicle objSearch = searchFavoriteVehicle(cylinder);
        if (objSearch != null)
            removeFavoriteVehicle(objSearch);
    }

    private void removeFavoriteVehicle(Vehicle nodeToErase) {
        if (nodeToErase.getLeft() == null && nodeToErase.getRight() == null) {
            if (nodeToErase.getParent().getLeft().equals(nodeToErase))
                nodeToErase.getParent().setLeft(null);
            else if (nodeToErase.getParent().getRight().equals(nodeToErase)) {
                nodeToErase.getParent().setRight(null);
            }
            nodeToErase.setParent(null);
        } else if (nodeToErase.getLeft() == null || nodeToErase.getRight() == null) {
            Vehicle child = nodeToErase.getLeft() != null ? nodeToErase.getLeft() : nodeToErase.getRight();
            if (nodeToErase.getParent().getLeft().equals(nodeToErase))
                nodeToErase.getParent().setLeft(child);
            else if (nodeToErase.getParent().getRight().equals(nodeToErase)) {
                nodeToErase.getParent().setRight(child);
            }
            child.setParent(nodeToErase.getParent());
            nodeToErase.setRight(null);
            nodeToErase.setLeft(null);
        } else if (nodeToErase.getLeft() != null && nodeToErase.getRight() != null) {
            Vehicle nodeMostToLeft = goToLeft(nodeToErase.getRight());
            if (nodeMostToLeft != null ) {
                nodeToErase.getParent().setLeft(nodeMostToLeft);
                removeFavoriteVehicle(nodeMostToLeft);
            }
        }
    }

    private Vehicle goToLeft(Vehicle node) {
        if (node.getLeft() != null)
            return goToLeft(node.getLeft());
        return node;
    }

    public String printVehiclesOfInterest(Vehicle vehicle) {
		String message = "";
        if (vehicle == null) {
            return message;
        }
		message += printVehiclesOfInterest(vehicle.getLeft());
		if (vehicle instanceof Gasoline) {
			Gasoline gas = (Gasoline) vehicle;
			message += "Vehicle brand" + SEPARATOR + "Vehicle model" + SEPARATOR + "Vehicle type" + SEPARATOR + "Vehicle base price" + SEPARATOR + "Vehicle license plate" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Owner ID" + SEPARATOR + "SOAT document code" + SEPARATOR + "SOAT document price" + SEPARATOR + "SOAT document year" + SEPARATOR + "SOAT coverage amount" + SEPARATOR + "Mechanical Technical Review document code" + SEPARATOR + "Mechanical Technical Review document price" + SEPARATOR + "Mechanical Technical Review document year" + SEPARATOR + "Gas level released" + SEPARATOR + "Car type" + SEPARATOR + "Doors number" + SEPARATOR + "Polarized Windows" + SEPARATOR + "Gasoline type" + SEPARATOR + "Gasoline capacity" + SEPARATOR + "Gasoline consume" + SEPARATOR + "Total selling price\n" + gas.toString() + "\n";
		} else if (vehicle instanceof Electric) {
			Electric elec = (Electric) vehicle;
			message += "Vehicle brand" + SEPARATOR + "Vehicle model" + SEPARATOR + "Vehicle type" + SEPARATOR + "Vehicle base price" + SEPARATOR + "Vehicle license plate" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Owner ID" + SEPARATOR + "SOAT document code" + SEPARATOR + "SOAT document price" + SEPARATOR + "SOAT document year" + SEPARATOR + "SOAT coverage amount" + SEPARATOR + "Mechanical Technical Review document code" + SEPARATOR + "Mechanical Technical Review document price" + SEPARATOR + "Mechanical Technical Review document year" + SEPARATOR + "Gas level released" + SEPARATOR + "Car type" + SEPARATOR + "Doors number" + SEPARATOR + "Polarized Windows" + SEPARATOR + "Charger type" + SEPARATOR + "Battery duration" + SEPARATOR + "Battery consume" + SEPARATOR + "Total selling price\n" + elec.toString() + "\n";
		} else if (vehicle instanceof Hybrid) {
			Hybrid hyb = (Hybrid) vehicle;
			message += "Vehicle brand" + SEPARATOR + "Vehicle model" + SEPARATOR + "Vehicle type" + SEPARATOR + "Vehicle base price" + SEPARATOR + "Vehicle license plate" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Owner ID" + SEPARATOR + "SOAT document code" + SEPARATOR + "SOAT document price" + SEPARATOR + "SOAT document year" + SEPARATOR + "SOAT coverage amount" + SEPARATOR + "Mechanical Technical Review document code" + SEPARATOR + "Mechanical Technical Review document price" + SEPARATOR + "Mechanical Technical Review document year" + SEPARATOR + "Gas level released" + SEPARATOR + "Car type" + SEPARATOR + "Doors number" + SEPARATOR + "Polarized Windows" + SEPARATOR + "Gasoline type" + SEPARATOR + "Gasoline capacity" + SEPARATOR + "Gasoline consume" + SEPARATOR + "Charger type" + SEPARATOR + "Battery duration" + SEPARATOR + "Battery consume" + SEPARATOR + "Total selling price\n" + hyb.toString() + "\n";
		} else if (vehicle instanceof Motorcycle) {
			Motorcycle moto = (Motorcycle) vehicle;
			message += "Vehicle brand" + SEPARATOR + "Vehicle model" + SEPARATOR + "Vehicle type" + SEPARATOR + "Vehicle base price" + SEPARATOR + "Vehicle license plate" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Owner ID" + SEPARATOR + "SOAT document code" + SEPARATOR + "SOAT document price" + SEPARATOR + "SOAT document year" + SEPARATOR + "SOAT coverage amount" + SEPARATOR + "Mechanical Technical Review document code" + SEPARATOR + "Mechanical Technical Review document price" + SEPARATOR + "Mechanical Technical Review document year" + SEPARATOR + "Gas level released" + SEPARATOR + "Motorcycle type" + SEPARATOR + "Gasoline capacity" + SEPARATOR + "Gasoline consume" + SEPARATOR + "Total selling price\n" + moto.toString() + "\n";
		}
        message += printVehiclesOfInterest(vehicle.getRight());
		return message;
    }
}