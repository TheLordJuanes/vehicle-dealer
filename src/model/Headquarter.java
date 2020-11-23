package model;

public class Headquarter {

    private String name;
    private String nit;
    private String address;

	private Headquarter next;
	private Headquarter prev;

	public Headquarter(String name, String nit, String address) {
		this.name = name;
		this.nit = nit;
		this.address = address;
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
}
