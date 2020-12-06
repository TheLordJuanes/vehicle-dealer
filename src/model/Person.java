/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.Serializable;
public abstract class Person implements Serializable {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private String namePerson;
	private String lastName;
	private String id;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Person
	 * Constructor method of a person. <br>
	 * @param namePerson - name of a person - namePerson = String, namePerson != null, namePerson != ""
	 * @param lastName - last name of a person - lastName = String, lastName != null, lastName != ""
	 * @param id - ID of a person - id = String, id != null, id != ""
	*/
	public Person(String namePerson, String lastName, String id) {
		this.namePerson = namePerson;
		this.lastName = lastName;
		this.id = id;
	}

	/**
	 * Name: getNamePerson
	 * Method used to get the name of a person. <br>
	 * @return A String representing the name of a person.
	*/
	public String getNamePerson() {
		return this.namePerson;
	}

	/**
	 * Name: setNamePerson
	 * Method used to update the name of a person.  <br>
	 * @param namePerson - name of a person - namePerson = String, namePerson != null, namePerson != ""
	*/
	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	/**
	 * Name: getNamePerson
	 * Method used to get the last name of a person. <br>
	 * @return A String representing the last name of a person.
	*/
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Name: setNamePerson
	 * Method used to update the last name of a person.  <br>
	 * @param lastName - last name of a person - lastName = String, lastName != null, lastName != ""
	*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Name: getId
	 * Method used to get the ID of a person. <br>
	 * @return A String representing the ID of a person.
	*/
	public String getId() {
		return this.id;
	}

	/**
	 * Name: setNamePerson
	 * Method used to update the ID of a person.  <br>
	 * @param id - ID of a person - id = String, id != null, id != ""
	*/
	public void setId(String id) {
		this.id = id;
	}

	/** Name: toString
	 * Method used to print a String that textually represents an object of from Person class with its elements.
	 * @return A String representing the partial information of a person.
  	*/
	public String toString(String separator) {
		return lastName + " " + separator + " " + namePerson + " " + separator + " " + id + " " + separator + " ";
	}
}