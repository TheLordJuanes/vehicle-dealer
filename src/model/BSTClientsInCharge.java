/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.Serializable;

public class BSTClientsInCharge implements Serializable {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;
    public final static String SEPARATOR = ";";
    public final static int NUM_MAX_CLIENTS_IN_CHARGE = 5;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private int size;
    private int counterClientsInCharge;

    // -----------------------------------------------------------------
    // Relations
    // -----------------------------------------------------------------

    private Client root;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Name: BSTClientsInCharge Constructor method of a binary search tree that
     * stores clients attended by an employee. <br>
    */
    public BSTClientsInCharge() {
        size = 0;
        counterClientsInCharge = 1;
    }

    /**
     * Name: getSize
     * Method used to get the size of the binary search tree that stores clients attended by an employee. <br>
     * @return An int representing the size of the binary search tree that stores clients attended by an employee.
    */
    public int getSize() {
        return size;
    }

    /**
     * Name: setSize
     * Method used to update the size of the binary search tree that stores clients attended by an employee. <br>
     * @param size - binary search tree size - size = int, size != null
    */
    public void setSize(int size) {
        this.size = size;
    }

    public int getCounterClientsInCharge() {
        return counterClientsInCharge;
    }

    public void setCounterClientsInCharge(int counter) {
        this.counterClientsInCharge = counter;
    }

    /**
     * Name: getRoot
     * Method used to get the root of the binary search tree that stores clients attended by an employee. <br>
     * @return A Client object representing the root of the binary search tree that stores clients attended by an employee.
    */
    public Client getRoot() {
        return root;
    }

    /**
     * Name: setRoot
     * Method used to update the root of the binary search tree that stores clients attended by an employee. <br>
     * @param root - binary search tree root - root = Client object
    */
    public void setRoot(Client root) {
        this.root = root;
    }

    /**
     * Name: addAssignedClient
     * Method used to add a Client node in the binary search tree. <br>
     * <b>pre: </b> Binary search tree of clients attended by an employee already initialized. <br>
     * <b>post: </b> Adding process of a client in the binary search tree determined. <br>
     * @param assigned - Client that an employee will have in his/her charge.
     * @return A boolean with true if the client was added successfully to the BST, or with false if not.
    */
    public boolean addAssignedClient(Client assigned) {
        boolean added = false;
        if (root == null) {
            root = assigned;
            added = true;
            size++;
        } else if (size < NUM_MAX_CLIENTS_IN_CHARGE) {
            if (searchClientInCharge(assigned.getNumPhone()) == null) {
                added = addAssignedClient(root, assigned);
                size++;
            }
        }
        return added;
    }

    /**
     * Name: addAssignedClient
     * Recursive method used to add a Client node in the binary search tree, when the root is different from null. <br>
     * <b>pre: </b> Binary search tree of clients attended by an employee already initialized. <br>
     * <b>post: </b> Adding process of a client in the binary search tree determined. <br>
     * @param current   - Current Client in the BST traversal - current = Client object, current != null
     * @param newClient - Client in question to be added to the BST - newClient = Client object, newClient != null
    */
    private boolean addAssignedClient(Client current, Client newClient) {
        boolean added = false;
        if (newClient.getNumPhone().compareTo(current.getNumPhone()) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(newClient);
                newClient.setParent(current);
                added = true;
            } else
                added = addAssignedClient(current.getLeft(), newClient);
        } else {
            if (current.getRight() == null) {
                current.setRight(newClient);
                newClient.setParent(current);
                added = true;
            } else
                added = addAssignedClient(current.getRight(), newClient);
        }
        return added;
    }

    /**
     * Name: searchClientInCharge Method used to search a Client node in the binary search tree. <br>
     * <b>pre: </b> Binary search tree of clients attended by an employee already initialized. <br>
     * <b>post: </b> Searching process of a client in the binary search tree determined. <br>
     * @param phone - Client's phone - phone = String, phone != null, phone != "".
     * @return A Client object different from null if the client in question was found in the BST, or equal to null if not.
    */
    public Client searchClientInCharge(String phone) {
        if (root != null)
            return searchClientInCharge(root, phone);
        return null;
    }

    /**
     * Name: searchClientInCharge Recursive method used to search a Client node in the binary search tree, when the root is different from null. <br>
     * <b>pre: </b> Binary search tree of clients attended by an employee already initialized. <br>
     * <b>post: </b> Searching process of a client in the binary search tree determined. <br>
     * @param current - Current Client in the BST traversal - current = Client object, current != null
     * @param phone   - Client's phone - phone = String, phone != null, phone != "".
     * @return A Client object different from null if the client in question was found in the BST, or equal to null if not.
    */
    private Client searchClientInCharge(Client current, String phone) {
        Client objSearch = null;
        if (current.getNumPhone().equalsIgnoreCase(phone))
            objSearch = current;
        else if (phone.compareTo(current.getNumPhone()) < 0 && current.getLeft() != null)
            objSearch = searchClientInCharge(current.getLeft(), phone);
        else if (phone.compareTo(current.getNumPhone()) > 0 && current.getRight() != null)
            objSearch = searchClientInCharge(current.getRight(), phone);
        return objSearch;
    }

    /**
     * Name: removeClientsInCharge Method used to remove a Client node from the binary search tree. <br>
     * <b>pre: </b> Binary search tree of clients attended by an employee already initialized. <br>
     * <b>post: </b> Removing process of a client from the binary search tree determined. <br>
     * @param phone - Client's phone - phone = String, phone != null, phone != "".
    */
    public void removeClientsInCharge(String phone) {
        Client objSearch = searchClientInCharge(phone);
        if (objSearch != null) {
            removeClientsInCharge(objSearch);
            size--;
        }
    }

    /**
     * Name: removeClientsInCharge Recursive method used to remove a Client node in the binary search tree, when this client exists. <br>
     * <b>pre: </b> Binary search tree of clients attended by an employee already initialized. <br>
     * <b>post: </b> Removing process of a Client from the binary search tree determined. <br>
     * @param nodeToErase - Client node in question to be removed from the BST - nodeToErase = Client object, nodeToErase != null
    */
    private void removeClientsInCharge(Client nodeToErase) {
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
            Client child = nodeToErase.getLeft() != null ? nodeToErase.getLeft() : nodeToErase.getRight();
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
            Client nodeMostToLeft = goToLeft(nodeToErase.getRight());
            if (nodeMostToLeft != null) {
                nodeToErase.getParent().setLeft(nodeMostToLeft);
                removeClientsInCharge(nodeMostToLeft);
            }
        }
    }

    /**
     * Name: goToLeft Recursive method used to get the Client node located further to the left of the BST. <br>
     * <b>pre: </b> Binary search tree of clients attended by an employee already initialized. <br>
     * <b>post: </b> Arrival at the leftmost Client node of the BST. <br>
     * @param node - current client where the traversal to the leftmost Client node will begin - node = Client object, node != null
    */
    private Client goToLeft(Client node) {
        if (node.getLeft() != null)
            return goToLeft(node.getLeft());
        return node;
    }

    /**
     * Name: printClientsInCharge Method used to print the clients data present in the BST, after an inorder traversal through it. <br>
     * <b>pre: </b> Binary search tree of clients attended by an employee already initialized. <br>
     * <b>post: </b> An enumerated vertical list of the clients data present in the BST has been printed. <br>
     * @param client - Current client in the BST inorder traversal - client = Client object
     * @return A String with the clients data present in the BST, or an empty String if the root was null.
    */
    public String printClientsInCharge(Client client) {
        String message = "";
        if (client == null) {
            return message;
        }
        message += printClientsInCharge(client.getLeft());
        message += "\n\nClient assigned " + counterClientsInCharge + ":\nLast name" + SEPARATOR + "Name" + SEPARATOR + "ID number" + SEPARATOR + "Active client" + SEPARATOR + "E-mail" + SEPARATOR + "Has seller in charge" + SEPARATOR + "Phone number\n" + client.toString(SEPARATOR) + "\n";
        counterClientsInCharge++;
        message += printClientsInCharge(client.getRight());
        return message;
    }
}