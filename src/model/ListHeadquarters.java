/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ListHeadquarters implements Serializable {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private Headquarter first;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: ListHeadquarters
	 * Constructor method of a doubly linked list of headquarters. <br>
	*/
	public ListHeadquarters() {
	}

	/**
	 * Name: getFirst
	 * Method used to get the first node of the doubly linked list of headquarters. <br>
	 * @return A Headquarter object representing the first node of the doubly linked list of headquarters.
	*/
	public Headquarter getFirst() {
		return first;
	}

	/**
	 * Name: setFirst
	 * Method used to update the first node of the doubly linked list of headquarters. <br>
	 * @param first - doubly linked list first node - first = Headquarter object
	*/
	public void setFirst(Headquarter first) {
		this.first = first;
	}

	/**
     * Name: addHeadquarter
     * Method used to add a Headquarter node in the doubly linked list. <br>
     * <b>pre: </b> Doubly linked list of headquarters already initialized. <br>
     * <b>post: </b> Adding process of a headquarter in the doubly linked list determined. <br>
     * @param name - name of the company - nameCompany = String, nameCompany != null, nameCompany != ""
	 * @param nit - Headquarter NIT - nit = String, nit != null, nit != ""
	 * @param address - Headquarter address - address = String, address != null, address != ""
	 * @param numSales - Sales number of the headquarter - numSales = int, numSales != null
	 * @param totalEarnings - Total earnings of the headquarter - totalEarnings = double, totalEarnings != null
	 * @throws IOException - if it cannot write the file properly while saving.
     * @return A boolean with true if the headquarter was added successfully to the doubly linked list, or with false if not.
    */
	public boolean addHeadquarter(String name, String nit, String address, int numSales, int totalEarnings) throws IOException {
		Headquarter headquarter = new Headquarter(name, nit, address, numSales, totalEarnings);
		if (first == null) {
			first = headquarter;
			saveDataHeadquarters();
			return true;
		} else {
			Headquarter objSearch = searchHeadquarter(headquarter.getNit());
			if (objSearch == null) {
				Headquarter current = first;
				while (current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(headquarter);
				headquarter.setPrev(current);
				headquarter.setNext(null);
				saveDataHeadquarters();
				return true;
			} else
				return false;
		}
	}

	/**
     * Name: searchHeadquarter
     * Method used to search a Headquarter node in the doubly linked list. <br>
     * <b>pre: </b> Doubly linked list of headquarters already initialized. <br>
     * <b>post: </b> Searching process of a headquarter in the doubly linked list determined. <br>
	 * @param nit - Headquarter NIT - nit = String, nit != null, nit != ""
     * @return A Headquarter object different from null if the headquarter in question was found in the doubly linked list, or equal to null if not.
    */
	public Headquarter searchHeadquarter(String nit) { // remove the design test of this method. Method taken from https://gist.github.com/krthr/91cc3a4ebd3c888880532190881b6f2d
		Headquarter objSearch = first;
		while (objSearch != null) {
            if (objSearch.getNit().equals(nit)) {
				return objSearch;
			}
            objSearch = objSearch.getNext();
        }
		return objSearch;
	}

	/**
     * Name: removeHeadquarter
     * Method used to remove a Headquarter node from the doubly linked list. <br>
     * <b>pre: </b> Doubly linked list of headquarters already initialized. <br>
     * <b>post: </b> Removing process of a headquarter from the doubly linked list determined. <br>
	 * @param nit - Headquarter NIT - nit = String, nit != null, nit != ""
	 * @throws IOException - if it cannot write the file properly while saving.
     * @return A boolean with true if the headquarter was removed successfully from the doubly linked list, or with false if not.
    */
	public boolean removeHeadquarter(String nit) throws IOException {
		if (first != null) {
			if (first.getNext() == null) {
				first = null;
				saveDataHeadquarters();
				return true;
			} else {
				Headquarter objSearch = searchHeadquarter(nit);
				if (objSearch != null) {
					if (objSearch == first) {
						first = first.getNext();
						first.setPrev(null);
					} else {
						Headquarter current = first;
						while (current != objSearch)
							current = current.getNext();
						if (current.getNext() == null)
							current.getPrev().setNext(null);
						else {
							current.getPrev().setNext(current.getNext());
							current.getNext().setPrev(current.getPrev());
							current = null;
						}
					}
					saveDataHeadquarters();
					return true;
				}
			}
		}
		return false;
	}

	/**
	* Name: saveDataHeadquarters
	* Method used to serialize the doubly linked list of headquarters of the system. <br>
	* <b>pre: </b> Doubly linked list of headquarters already initialized and a Headquarter object is added to this list. <br>
	* <b>post: </b> Doubly linked list of headquarters serialized. <br>
	* @throws IOException - if it cannot write the file properly while saving.
	*/
	private void saveDataHeadquarters() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Company.SAVE_HEADQUARTERS_PATH_FILE));
		oos.writeObject(first);
		oos.close();
	}
}