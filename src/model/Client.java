/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public class Client extends Person  {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	public final static String SEPARATOR = " | ";

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private String numPhone;
	private String email;
	private boolean active;
	private boolean hasSeller;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private Client parent;
	private Client right;
	private Client left;
	private BSTFavoriteVehicles vehiclesOfInterest;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Client
	 * Constructor method of a client. <br>
	 * @param namePerson - name of a person - namePerson = String, namePerson != null, namePerson != ""
	 * @param lastName - last name of a person - lastName = String, lastName != null, lastName != ""
	 * @param id - ID of a person - id = String, id != null, id != ""
	 * @param numPhone - cell phone number of the client - numPhone = String, numPhone != null, numPhone != ""
	 * @param email - e-mail of the client - email = String, email != null, email != ""
	 * @param active - status of a client in the company - active = boolean, active != null, active begins in true
	 * @param hasSeller - parameter to identify if a client is being attended by an employee - hasSeller = boolean, hasSeller != null, hasSeller begins in false
	 * @param vehiclesOfInterest - list of vehicles of interest of a client - vehiclesOfInterest = BST
	*/
	public Client(String namePerson, String lastName, String id, String numPhone, String email, boolean hasSeller, boolean active, BSTFavoriteVehicles vehiclesOfInterest) {
		super(namePerson, lastName, id);
		this.numPhone = numPhone;
		this.email = email;
		this.active = active;
		this.hasSeller = hasSeller;
		this.vehiclesOfInterest = vehiclesOfInterest;
	}

	/**
	 * Name: getNumPhone
	 * Method used to get the cell phone number of the client. <br>
	 * @return A String representing the cell phone number of the client.
	*/
	public String getNumPhone() {
		return this.numPhone;
	}

	/**
	 * Name: setNumPhone
	 * Method used to update the cell phone number of the client.  <br>
	 * @param numPhone - cell phone number of the client - numPhone = String, numPhone != null, numPhone != ""
	*/
	public void setNumPhone(String numPhone) {
		this.numPhone = numPhone;
	}

	/**
	 * Name: getEmail
	 * Method used to get the e-mail of the client. <br>
	 * @return A String representing the e-mail of the client.
	*/
	public String getEmail() {
		return this.email;
	}

	/**
	 * Name: setEmail
	 * Method used to update the e-mail of the client.  <br>
	 * @param email - e-mail of the client - email = String, email != null, email != ""
	*/
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Name: getActive
	 * Method used to get the status of a client in the company. <br>
	 * @return A String representing the client status in the company.
	*/
	public boolean getActive() {
		return active;
	}

	/**
	 * Name: setActive
	 * Method used to update the status of a client in the company.  <br>
	 * @param active - status of a client in the company - active = boolean, active != null, active begins in true
	*/
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Name: getHasSeller
	 * Method used to get the parameter to identify if a client is being attended by an employee. <br>
	 * @return A String representing the parameter to identify if a client is being attended by an employee.
	*/
	public boolean getHasSeller() {
		return hasSeller;
	}

	/**
	 * Name: setHasSeller
	 * Method used to update the parameter to identify if a client is being attended by an employee.  <br>
	 * @param hasSeller - parameter to identify if a client is being attended by an employee - hasSeller = boolean, hasSeller != null, hasSeller begins in false
	*/
	public void setHasSeller(boolean hasSeller) {
		this.hasSeller = hasSeller;
	}

	public Client getParent() {
		return parent;
	}

	public void setParent(Client parent) {
		this.parent = parent;
	}

	public Client getRight() {
		return right;
	}

	public void setRight(Client right) {
		this.right = right;
	}

	public Client getLeft() {
		return left;
	}

	public void setLeft(Client left) {
		this.left = left;
	}

	/**
	 * Name: getVehiclesOfInterest
	 * Method used to get the list of vehicles of interest of a client. <br>
	 * @return A String representing the list of vehicles of interest of a client.
	*/
	public BSTFavoriteVehicles getVehiclesOfInterest() {
		return vehiclesOfInterest;
	}

	/**
	 * Name: setVehiclesOfInterest
	 * Method used to update the list of vehicles of interest of a client.  <br>
	 * @param vehiclesOfInterest - list of vehicles of interest of a client - vehiclesOfInterest = ArrayList of Vehicle
	*/
	public void setVehiclesOfInterest(BSTFavoriteVehicles vehiclesOfInterest) {
		this.vehiclesOfInterest = vehiclesOfInterest;
	}

	/** Name: toString
	 * Method used to print a String that textually represents an object of the Client class with its elements.
	 * @return A String representing the complete information of a client.
	*/
	@Override
	public String toString() {
		String message = super.toString() + active + SEPARATOR + email + SEPARATOR + hasSeller + SEPARATOR + numPhone;
		message += vehiclesOfInterest.printVehiclesOfInterest(vehiclesOfInterest.getRoot());
		vehiclesOfInterest.setCounterVehiclesOfInterest(1);
		return message;
	}
}