/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public class Employee extends Person implements Comparable<Employee> {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private int quantTotalSales;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private BSTClientsInCharge clientsInCharge;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Employee
	 * Constructor method of an employee. <br>
	 * @param namePerson - name of a person - namePerson = String, namePerson != null, namePerson != ""
	 * @param lastName - last name of a person - lastName = String, lastName != null, lastName != ""
	 * @param id - ID of a person - id = String, id != null, id != ""
	 * @param quantTotalSales - total quantity of an employee sales - quantTotalSales = int, quantTotalSales != null, quantTotalSales begins in 0
	 * @param clientsInCharge - Array of clients that an employee (seller) has in his/her charge - clientsInCharge = Client object.
	 */
	public Employee(String namePerson, String lastName, String id, int quantTotalSales, BSTClientsInCharge clientsInCharge) {
		super(namePerson, lastName, id);
		this.quantTotalSales = quantTotalSales;
		this.clientsInCharge = clientsInCharge;
	}

	/**
	 * Name: getQuantTotalSales
	 * Method used to get the total quantity of an employee sales. <br>
	 * @return An int representing the total quantity of an employee sales.
	*/
	public int getQuantTotalSales() {
		return this.quantTotalSales;
	}

	/**
	 * Name: setQuantTotalSales
	 * Method used to update the total quantity of an employee sales.  <br>
	 * @param quantTotalSales - total quantity of an employee sales - quantTotalSales = int, quantTotalSales != null, quantTotalSales begins in 0
	*/
	public void setQuantTotalSales(int quantTotalSales) {
		this.quantTotalSales = quantTotalSales;
	}

	/**
	 * Name: getClientsInCharge
	 * Method used to get the array of clients that an employee (seller) has in his/her charge. <br>
	 * @return A BSTClientsInCharge object representing the array of clients that an employee (seller) has in his/her charge.
	*/
	public BSTClientsInCharge getClientsInCharge() {
		return clientsInCharge;
	}

	/**
	 * Name: setClientsInCharge
	 * Method used to update the array of clients that an employee (seller) has in his/her charge.  <br>
	 * @param clientsInCharge - Array of clients that an employee (seller) has in his/her charge - clientsInCharge = BSTClientsInCharge object.
	*/
	public void setClientsInCharge(BSTClientsInCharge clientsInCharge) {
		this.clientsInCharge = clientsInCharge;
	}

	/** Name: compareTo
	 * Method used to compare lexicographically String attributes (or attributes that were converted to String) from an employee.
     * <b>pre: </b> List of employees created locally already exists and has at least one employee added in it. <br>
     * <b>post: </b> Comparison result obtained of the degree of lexicographicity between the String attributes compared. <br>
     * @param emp - An Employee object - emp != null
	 * @return An int representing the comparison result, be it positive, negative or equal to 0.
  	*/
	@Override
	public int compareTo(Employee emp) {
		int result = String.valueOf(emp.getQuantTotalSales()).compareTo(String.valueOf(quantTotalSales));
        if (result == 0)
            result = emp.getId().compareTo(super.getId());
		return result;
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Employee class with its elements.
	 * @return A String representing the complete information of an employee.
  	*/
	@Override
	public String toString(String separator) {
		String message = super.toString(separator) + quantTotalSales;
		message += clientsInCharge.printClientsInCharge(clientsInCharge.getRoot());
		clientsInCharge.setCounterClientsInCharge(1);
		return message;
	}
}