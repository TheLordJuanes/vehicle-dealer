/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.Serializable;

public class BSTClientsInCharge implements Serializable {

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	public final static String SEPARATOR = " | ";
	public final static int NUM_MAX_CLIENTS_IN_CHARGE = 5;

    // -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private int size;

    // -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

    private Client root;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    public BSTClientsInCharge() {
    	size = 0;
    }

	public Client getRoot() {
		return root;
	}

	public void setRoot(Client root) {
		this.root = root;
	}

    public boolean addAssignedClient(Client assigned) {
        if (root == null) {
            root = assigned;
            return true;
        }
        else
            return addAssignedClient(root, assigned);
    }

    private boolean addAssignedClient(Client current, Client newClient) {
        boolean added = false;
        if (size < NUM_MAX_CLIENTS_IN_CHARGE) {
            if (newClient.getNumPhone().compareTo(current.getNumPhone()) < 0) {
    		    if (current.getLeft() == null) {
    			    current.setLeft(newClient);
                    newClient.setParent(current);
                    added = true;
    			    size++;
    		    } else
    			    addAssignedClient(current.getLeft(), newClient);
    	    } else {
    		    if (current.getRight() == null) {
    			    current.setRight(newClient);
                    newClient.setParent(current);
                    added = true;
    			    size++;
    		    } else
    			    addAssignedClient(current.getRight(), newClient);
    	    }
        }
    	return added;
    }

    public Client searchClientInCharge(String phone) {
        if (root != null)
            return searchClientInCharge(root, phone);
        return null;
    }

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

    public void removeClientsInCharge(String phone) {
        Client objSearch = searchClientInCharge(phone);
        if (objSearch != null)
            removeClientsInCharge(objSearch);
    }

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
            size--;
        } else if (nodeToErase.getLeft() == null || nodeToErase.getRight() == null) {
            Client child = nodeToErase.getLeft() != null ? nodeToErase.getLeft() : nodeToErase.getRight();
            if (nodeToErase.getParent().getLeft().equals(nodeToErase))
                nodeToErase.getParent().setLeft(child);
            else if (nodeToErase.getParent().getRight().equals(nodeToErase)) {
                nodeToErase.getParent().setRight(child);
            }
            child.setParent(nodeToErase.getParent());
            nodeToErase.setRight(null);
            nodeToErase.setLeft(null);
            size--;
        } else if (nodeToErase.getLeft() != null && nodeToErase.getRight() != null) {
            Client nodeMostToLeft = goToLeft(nodeToErase.getRight());
            if (nodeMostToLeft != null ) {
                nodeToErase.getParent().setLeft(nodeMostToLeft);
                removeClientsInCharge(nodeMostToLeft);
                size--;
            }
        }
    }

    private Client goToLeft(Client node) {
        if (node.getLeft() != null)
            return goToLeft(node.getLeft());
        return node;
    }

    public String printClientsInCharge(Client client) {
		String message = "";
        if (client == null) {
            return message;
        }
		message += printClientsInCharge(client.getLeft());
		message += "Last name" + SEPARATOR + "Name" + SEPARATOR + "ID number" + SEPARATOR + "Active client" + SEPARATOR + "E-mail" + SEPARATOR + "Has seller in charge" + SEPARATOR + "Phone number\n" + client.toString() + "\n";
        message += printClientsInCharge(client.getRight());
		return message;
    }
}