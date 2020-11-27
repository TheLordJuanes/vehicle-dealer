package model;

public class Headquarter {

    private String name;
    private String nit;
	private String address;
	private int numSales;
	private double totalEarnings;

	private Headquarter next;
	private Headquarter prev;

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