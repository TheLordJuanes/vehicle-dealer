/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
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

	public ListHeadquarters() {
	}

	public Headquarter getFirst() {
		return first;
	}

	public void setFirst(Headquarter first) {
		this.first = first;
	}

	public boolean addHeadquarter(String name, String nit, String address, int numSales, int totalEarnings) throws IOException { // update class diagram
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

	private Headquarter searchHeadquarter(String nit) { // remove the design test of this method. Method taken from https://gist.github.com/krthr/91cc3a4ebd3c888880532190881b6f2d
		Headquarter objSearch = first;
		while (objSearch != null) {
            if (objSearch.getNit().equals(nit)) {
				return objSearch;
			}
            objSearch = objSearch.getNext();
        }
		return objSearch;
	}

	public boolean removeHeadquarter(String nit) throws IOException { // update class diagram
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
	* Method used to serialize the linked list of headquarters of the system. <br>
	* <b>pre: </b> Linked list of headquarters already initialized and a Headquarter object is added to this list. <br>
	* <b>post: </b> Linked list of headquarters serialized. <br>
	* @throws IOException - if it cannot write the file properly while saving.
	*/
	private void saveDataHeadquarters() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Company.SAVE_HEADQUARTERS_PATH_FILE));
		oos.writeObject(first);
		oos.close();
	}
}