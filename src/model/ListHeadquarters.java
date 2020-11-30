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

	public String addHeadquarter(Headquarter headquarter) throws IOException {
		String message = "";
		if (first == null) {
			first = headquarter;
			saveDataHeadquarters();
		}
		else {
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
				message = "Headquarter successfully registered.";
			} else
				message = "This headquarter already exists in the system.";
		}
		return message;
	}

	public Headquarter searchHeadquarter(String nit) {
		Headquarter exist = first;
		if (first != null) {
			while (!exist.getNext().getNit().equals(first.getNit()) && !exist.getNit().equals(nit))
				exist = exist.getNext();
			if (exist.getNit().equals(first.getPrev().getNit())) {
				if (!exist.getNit().equals(nit))
					exist = null;
			}
		}
		return exist;
	}

	public String removeHeadquarter(String nit) { // verify later
		String message = "";
		Headquarter headquarter = null;
		if (first != null) {
			if (nit.equals(first.getNit())) {
				headquarter = first;
				first.getNext().setPrev(null);
				first = first.getNext();
				message = "The headquarter with NIT " + headquarter.getNit();
			} else {
				Headquarter current = searchHeadquarter(nit).getPrev();
				if (current.getNext() != null ) {
					headquarter = current.getNext();
					current.getNext().getNext().setPrev(current);
					current.setNext(current.getNext().getNext());
					message = "The headquarter with NIT " + headquarter.getNit();
				}
			}
		} else
			message = "There are no headquarters registered in the system to remove one.";
		return message;
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