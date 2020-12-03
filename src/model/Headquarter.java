/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.Serializable;

public class Headquarter implements Serializable {

	//-----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private String name;
    private String nit;
	private String address;
	private int numSales;
	private double totalEarnings;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private Headquarter next;
	private Headquarter prev;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Name: Headquarter
	 * Constructor method of a headquarter. <br>
	 * @param name - name of the company - nameCompany = String, nameCompany != null, nameCompany != ""
	 * @param nit - Headquarter NIT - nit = String, nit != null, nit != ""
	 * @param address - Headquarter address - address = String, address != null, address != ""
	 * @param numSales - Sales number of the headquarter - numSales = int, numSales != null
	 * @param totalEarnings - Total earnings of the headquarter - totalEarnings = double, totalEarnings != null
	*/
	public Headquarter(String name, String nit, String address, int numSales, double totalEarnings) {
		this.name = name;
		this.nit = nit;
		this.address = address;
		this.numSales = numSales;
		this.totalEarnings = totalEarnings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumSales() {
		return numSales;
	}

	public void setNumSales(int numSales) {
		this.numSales = numSales;
	}
	public double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public Headquarter getNext() {
		return next;
	}

	public void setNext(Headquarter next) {
		this.next = next;
	}

	public Headquarter getPrev() {
		return prev;
	}

	public void setPrev(Headquarter prev) {
		this.prev = prev;
	}
}