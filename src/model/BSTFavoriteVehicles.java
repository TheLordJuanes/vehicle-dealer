/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.Serializable;

public class BSTFavoriteVehicles implements Serializable {

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;
    public final static String SEPARATOR = ";";

    // -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

    private int counterVehiclesOfInterest;

    // -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

    private Vehicle root;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    /** Name: BSTFavoriteVehicles
	 * Constructor method of a binary search tree that stores vehicles of interest. <br>
	*/
    public BSTFavoriteVehicles() {
        counterVehiclesOfInterest = 1;
    }

    public int getCounterVehiclesOfInterest() {
        return counterVehiclesOfInterest;
    }

    public void setCounterVehiclesOfInterest(int counterVehiclesOfInterest) {
        this.counterVehiclesOfInterest = counterVehiclesOfInterest;
    }

    /**
	 * Name: getRoot
	 * Method used to get the root of the binary search tree that stores vehicles of interest. <br>
	 * @return A Vehicle object representing the root of the binary search tree that stores vehicles of interest.
	*/
    public Vehicle getRoot() {
        return root;
    }

    /**
	 * Name: setRoot
	 * Method used to update the root of the binary search tree that stores vehicles of interest. <br>
	 * @param root - binary search tree root - root = Vehicle object
	*/
    public void setRoot(Vehicle root) {
        this.root = root;
    }

    /**
     * Name: addFavoriteVehicle
     * Method used to add a Vehicle of interest node in the binary search tree. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> Adding process of a Vehicle of interest in the binary search tree determined. <br>
     * @param favorite - Vehicle in which a client is potentially interested in buying it.
    */
    public void addFavoriteVehicle(Vehicle favorite) {
        if (root == null)
            root = favorite;
        else if (searchFavoriteVehicle(favorite.getCylinder()) == null)
            addFavoriteVehicle(root, favorite);
    }

    /**
     * Name: addFavoriteVehicle
     * Recursive method used to add a Vehicle of interest node in the binary search tree, when the root is different from null. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> Adding process of a Vehicle of interest in the binary search tree determined. <br>
     * @param current - Current Vehicle in the BST traversal - current = Vehicle object, current != null
     * @param newVehicle - Vehicle of interest node in question to be added to the BST - newVehicle = Vehicle object, newVehicle != null
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

    /**
     * Name: searchFavoriteVehicle
     * Method used to search a Vehicle of interest node in the binary search tree. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> Searching process of a vehicle of interest in the binary search tree determined. <br>
     * @param cylinder - Vehicle of interest's cylinder - cylinder = double, cylinder != null, cylinder != 0.
	 * @return A Vehicle object different from null if the vehicle of interest in question was found in the BST, or equal to null if not.
    */
    public Vehicle searchFavoriteVehicle(double cylinder) {
        if (root != null)
            return searchFavoriteVehicle(root, cylinder);
        return null;
    }

    /**
     * Name: searchFavoriteVehicle
     * Recursive method used to search a Vehicle of interest node in the binary search tree, when the root is different from null. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> Searching process of a vehicle of interest in the binary search tree determined. <br>
     * @param current - Current Vehicle in the BST traversal - current = Vehicle object, current != null
     * @param cylinder - Vehicle of interest's cylinder - cylinder = double, cylinder != null, cylinder != 0.
     * @return A Vehicle object different from null if the vehicle of interest in question was found in the BST, or equal to null if not.
    */
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

    /**
     * Name: removeFavoriteVehicle
     * Method used to remove a Vehicle of interest node from the binary search tree. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> Removing process of a Vehicle of interest from the binary search tree determined. <br>
     * @param cylinder - Vehicle of interest's cylinder - cylinder = double, cylinder != null, cylinder != 0.
    */
    public void removeFavoriteVehicle(double cylinder) {
        Vehicle objSearch = searchFavoriteVehicle(cylinder);
        if (objSearch != null)
            removeFavoriteVehicle(objSearch);
    }

    /**
     * Name: removeFavoriteVehicle
     * Recursive method used to remove a Vehicle of interest node from the binary search tree, when this vehicle exists. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> Removing process of a Vehicle of interest from the binary search tree determined. <br>
     * @param nodeToErase - Vehicle of interest node in question to be removed from the BST - nodeToErase = Vehicle object, nodeToErase != null
    */
    private void removeFavoriteVehicle(Vehicle nodeToErase) {
        if (nodeToErase.getLeft() == null && nodeToErase.getRight() == null) {
            if (nodeToErase.equals(root))
                root = null;
            else if (nodeToErase.getParent().getLeft().equals(nodeToErase))
                nodeToErase.getParent().setLeft(null);
            else if (nodeToErase.getParent().getRight().equals(nodeToErase)) {
                nodeToErase.getParent().setRight(null);
            }
            nodeToErase.setParent(null);
        } else if (nodeToErase.getLeft() == null || nodeToErase.getRight() == null) {
            Vehicle child = nodeToErase.getLeft() != null ? nodeToErase.getLeft() : nodeToErase.getRight();
            if (nodeToErase.equals(root)) {
                root = child;
                root.setParent(null);
            } else {
                if (nodeToErase.getParent().getLeft().equals(nodeToErase))
                    nodeToErase.getParent().setLeft(child);
                else if (nodeToErase.getParent().getRight().equals(nodeToErase)) {
                    nodeToErase.getParent().setRight(child);
                }
                child.setParent(nodeToErase.getParent());
                nodeToErase.setRight(null);
                nodeToErase.setLeft(null);
            }
        } else if (nodeToErase.getLeft() != null && nodeToErase.getRight() != null) {
            Vehicle nodeMostToLeft = goToLeft(nodeToErase.getRight());
            if (nodeMostToLeft != null ) {
                nodeToErase.getParent().setLeft(nodeMostToLeft);
                removeFavoriteVehicle(nodeMostToLeft);
            }
        }
    }

    /**
     * Name: goToLeft
     * Recursive method used to get the Vehicle of interest node located further to the left of the BST. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> Arrival at the leftmost Vehicle node of the BST. <br>
     * @param node - current vehicle where the traversal to the leftmost Vehicle node will begin - node = Vehicle object, node != null
    */
    private Vehicle goToLeft(Vehicle node) {
        if (node.getLeft() != null)
            return goToLeft(node.getLeft());
        return node;
    }

    /**
     * Name: printVehiclesOfInterest
     * Method used to print the vehicles of interest data after an inorder traversal through the binary search tree. <br>
     * <b>pre: </b> Binary search tree of vehicles of interest already initialized. <br>
     * <b>post: </b> An enumerated vertical list of the vehicles of interest data present in the BST has been printed. <br>
     * @param vehicle - Current vehicle in the BST inorder traversal - vehicle = Vehicle object
     * @return A String with the vehicles of interest data present in the BST, or an empty String if the root was null.
    */
    public String printVehiclesOfInterest(Vehicle vehicle) {
		String message = "";
        if (vehicle == null) {
            return message;
        }
		message += printVehiclesOfInterest(vehicle.getLeft());
		if (vehicle instanceof Gasoline) {
			Gasoline gas = (Gasoline) vehicle;
			message += "\n\nVehicle of interest " + counterVehiclesOfInterest + ":\nVehicle brand" + SEPARATOR + "Vehicle model" + SEPARATOR + "Vehicle type" + SEPARATOR + "Vehicle base price" + SEPARATOR + "Vehicle license plate" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Vehicle mileage" + SEPARATOR + "Owner ID" + SEPARATOR + "SOAT document code" + SEPARATOR + "SOAT document price" + SEPARATOR + "SOAT document year" + SEPARATOR + "SOAT coverage amount" + SEPARATOR + "Mechanical Technical Review document code" + SEPARATOR + "Mechanical Technical Review document price" + SEPARATOR + "Mechanical Technical Review document year" + SEPARATOR + "Gas level released" + SEPARATOR + "Car type" + SEPARATOR + "Doors number" + SEPARATOR + "Polarized Windows" + SEPARATOR + "Gasoline type" + SEPARATOR + "Gasoline capacity" + SEPARATOR + "Gasoline consume" + SEPARATOR + "Total selling price\n" + gas.toString(SEPARATOR) + "\n";
		} else if (vehicle instanceof Electric) {
			Electric elec = (Electric) vehicle;
			message += "\n\nVehicle of interest " + counterVehiclesOfInterest + ":\nVehicle brand" + SEPARATOR + "Vehicle model" + SEPARATOR + "Vehicle type" + SEPARATOR + "Vehicle base price" + SEPARATOR + "Vehicle license plate" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Vehicle mileage" + SEPARATOR + "Owner ID" + SEPARATOR + "SOAT document code" + SEPARATOR + "SOAT document price" + SEPARATOR + "SOAT document year" + SEPARATOR + "SOAT coverage amount" + SEPARATOR + "Mechanical Technical Review document code" + SEPARATOR + "Mechanical Technical Review document price" + SEPARATOR + "Mechanical Technical Review document year" + SEPARATOR + "Gas level released" + SEPARATOR + "Car type" + SEPARATOR + "Doors number" + SEPARATOR + "Polarized Windows" + SEPARATOR + "Charger type" + SEPARATOR + "Battery duration" + SEPARATOR + "Battery consume" + SEPARATOR + "Total selling price\n" + elec.toString(SEPARATOR) + "\n";
		} else if (vehicle instanceof Hybrid) {
			Hybrid hyb = (Hybrid) vehicle;
			message += "\n\nVehicle of interest " + counterVehiclesOfInterest + ":\nVehicle brand" + SEPARATOR + "Vehicle model" + SEPARATOR + "Vehicle type" + SEPARATOR + "Vehicle base price" + SEPARATOR + "Vehicle license plate" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Vehicle mileage" + SEPARATOR + "Owner ID" + SEPARATOR + "SOAT document code" + SEPARATOR + "SOAT document price" + SEPARATOR + "SOAT document year" + SEPARATOR + "SOAT coverage amount" + SEPARATOR + "Mechanical Technical Review document code" + SEPARATOR + "Mechanical Technical Review document price" + SEPARATOR + "Mechanical Technical Review document year" + SEPARATOR + "Gas level released" + SEPARATOR + "Car type" + SEPARATOR + "Doors number" + SEPARATOR + "Polarized Windows" + SEPARATOR + "Gasoline type" + SEPARATOR + "Gasoline capacity" + SEPARATOR + "Gasoline consume" + SEPARATOR + "Charger type" + SEPARATOR + "Battery duration" + SEPARATOR + "Battery consume" + SEPARATOR + "Total selling price\n" + hyb.toString(SEPARATOR) + "\n";
		} else if (vehicle instanceof Motorcycle) {
			Motorcycle moto = (Motorcycle) vehicle;
			message += "\n\nVehicle of interest " + counterVehiclesOfInterest + ":\nVehicle brand" + SEPARATOR + "Vehicle model" + SEPARATOR + "Vehicle type" + SEPARATOR + "Vehicle base price" + SEPARATOR + "Vehicle license plate" + SEPARATOR + "Vehicle cylinder" + SEPARATOR + "Vehicle mileage" + SEPARATOR + "Owner ID" + SEPARATOR + "SOAT document code" + SEPARATOR + "SOAT document price" + SEPARATOR + "SOAT document year" + SEPARATOR + "SOAT coverage amount" + SEPARATOR + "Mechanical Technical Review document code" + SEPARATOR + "Mechanical Technical Review document price" + SEPARATOR + "Mechanical Technical Review document year" + SEPARATOR + "Gas level released" + SEPARATOR + "Motorcycle type" + SEPARATOR + "Gasoline capacity" + SEPARATOR + "Gasoline consume" + SEPARATOR + "Total selling price\n" + moto.toString(SEPARATOR) + "\n";
        }
        counterVehiclesOfInterest++;
        message += printVehiclesOfInterest(vehicle.getRight());
		return message;
    }
}