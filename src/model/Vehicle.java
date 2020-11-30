/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Vehicle implements Serializable {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	public final static char TYPE_VEHICLE_NEW = 'N';
	public final static char TYPE_VEHICLE_USED = 'U';

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private double totalPrice;
	private double basePrice;
	private String brand;
	private int model;
	private double cylinder;
	private double mileage;
	private char typeVehicle;
	private String licensePlate;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private Client owner;
	private Document documents;
	private Vehicle parent;
	private Vehicle left;
	private Vehicle right;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Vehicle
	 * Constructor method of a vehicle. <br>
	 * @param totalPrice - vehicle's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - vehicle's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param brand - vehicle's brand - brand = String, brand != null, brand != ""
	 * @param model - vehicle's model - model = int, model != null, model != 0
	 * @param cylinder - vehicle's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - vehicle's mileage - mileage = double, mileage != null
	 * @param typeVehicle - vehicle's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - vehicle's license plate - licensePlate = String, licensePlate != null
	 * @param owner - gasoline car's owner ID - owner = Client object, owner != null
	 * @param documents - vehicle's documents - documents = Document object
	 */
	public Vehicle(double totalPrice, double basePrice, String brand, int model, double cylinder, double mileage,
			char typeVehicle, String licensePlate, Client owner, Document documents) {
		this.totalPrice = totalPrice;
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cylinder = cylinder;
		this.mileage = mileage;
		this.typeVehicle = typeVehicle;
		this.licensePlate = licensePlate;
		this.owner = owner;
		this.documents = documents;
		documents = new Document();
	}

	/**
	 * Name: getTotalPrice
	 * Method used to get the total price of a vehicle. <br>
	 * @return A double representing the total price of a vehicle.
	*/
	public double getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * Name: setTotalPrice
	 * Method used to update the total price of a vehicle.  <br>
	 * @param totalPrice - vehicle's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	*/
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Name: getBasePrice
	 * Method used to get the base price of a vehicle. <br>
	 * @return A double representing the base price of a vehicle.
	*/
	public double getBasePrice() {
		return this.basePrice;
	}

	/**
	 * Name: setBasePrice
	 * Method used to update the base price of a vehicle.  <br>
	 * @param basePrice - vehicle's base price - basePrice = double, basePrice != null, basePrice != 0
	*/
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * Name: getBrand
	 * Method used to get the brand of a vehicle. <br>
	 * @return A String representing the brand of a vehicle.
	*/
	public String getBrand() {
		return this.brand;
	}

	/**
	 * Name: setBrand
	 * Method used to update the brand of a vehicle.  <br>
	 * @param brand - vehicle's brand - brand = String, brand != null, brand != ""
	*/
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Name: getModel
	 * Method used to get the model of a vehicle. <br>
	 * @return An int representing the model of a vehicle.
	*/
	public int getModel() {
		return this.model;
	}

	/**
	 * Name: setModel
	 * Method used to update the brand of a vehicle.  <br>
	 * @param model - vehicle's model - model = int, model != null, model != 0
	*/
	public void setModel(int model) {
		this.model = model;
	}

	/**
	 * Name: getCylinder
	 * Method used to get the cylinder of a vehicle. <br>
	 * @return A double representing the cylinder of a vehicle.
	*/
	public double getCylinder() {
		return this.cylinder;
	}

	/**
	 * Name: setCylinder
	 * Method used to update the cylinder of a vehicle.  <br>
	 * @param cylinder - vehicle's cylinder - cylinder = double, cylinder != 0
	*/
	public void setCylinder(double cylinder) {
		this.cylinder = cylinder;
	}

	/**
	 * Name: getMileage
	 * Method used to get the mileage of a vehicle. <br>
	 * @return A double representing the mileage of a vehicle.
	*/
	public double getMileage() {
		return this.mileage;
	}

	/**
	 * Name: setMileage
	 * Method used to update the mileage of a vehicle.  <br>
	 * @param mileage - vehicle's mileage - mileage = double, mileage != null
	*/
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	/**
	 * Name: getTypeVehicle
	 * Method used to get the type of a vehicle. <br>
	 * @return A char representing the type of a vehicle.
	*/
	public char getTypeVehicle() {
		return this.typeVehicle;
	}

	/**
	 * Name: setTypeVehicle
	 * Method used to update the type of a vehicle.  <br>
	 * @param typeVehicle - vehicle's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	*/
	public void setTypeVehicle(char typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	/**
	 * Name: getLicensePlate
	 * Method used to get the license plate of a vehicle. <br>
	 * @return A String representing the license plate of a vehicle.
	*/
	public String getLicensePlate() {
		return this.licensePlate;
	}

	/**
	 * Name: setLicensePlate
	 * Method used to update the license plate of a vehicle.  <br>
	 * @param licensePlate - vehicle's license plate - licensePlate = String, licensePlate != null
	*/
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	/**
	 * Name: getOwner
	 * Method used to get the owner of a vehicle. <br>
	 * @return A Client representing the owner of a vehicle.
	*/
	public Client getOwner() {
		return owner;
	}

	/**
	 * Name: setOwner
	 * Method used to update the owner of a vehicle.  <br>
	 * @param owner - vehicle's owner - owner = Client, owner begins in null
	*/
	public void setOwner(Client owner) {
		this.owner = owner;
	}

	/**
	 * Name: getDocuments
	 * Method used to get the documents of a vehicle. <br>
	 * @return A Document object representing the documents of a vehicle.
	*/
	public Document getDocuments() {
		return documents;
	}

	/**
	 * Name: setDocuments
	 * Method used to update the documents of a vehicle.  <br>
	 * @param documents - vehicle's documents - documents = Document object
	*/
	public void setDocuments(Document documents) {
		this.documents = documents;
	}

	public Vehicle getParent() {
		return parent;
	}

	public void setParent(Vehicle parent) {
		this.parent = parent;
	}

	public Vehicle getLeft() {
		return left;
	}

	public void setLeft(Vehicle left) {
		this.left = left;
	}

	public Vehicle getRight() {
		return right;
	}

	public void setRight(Vehicle right) {
		this.right = right;
	}

	/** Name: totalSellingPrice
	 * Method used to partially calculate the total selling price of a vehicle. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. Array of the documents of a vehicle already initialized, documents != null. Half of the penalty amount (250000) will be considered if only one of the two documents does not have the current year at the present moment. <br>
	 * <b>post: </b> Total selling price of the vehicle calculated partially. <br>
	 * @return A double representing the partial total selling price of a vehicle in question.
	*/
	public double totalSellingPrice() {
		double total = 0;
		int currentYear = LocalDate.now().getYear();
		if (typeVehicle == 'U') {
			if (documents.getFirst().getYear() != currentYear && documents.getFirst().getNext().getYear() != currentYear)
				total = (basePrice + 500000 + documents.getFirst().getPriceDoc() + documents.getFirst().getNext().getPriceDoc()) * 0.9;
			else if (documents.getFirst().getYear() != currentYear && documents.getFirst().getNext().getYear() == currentYear)
				total = (basePrice + 250000 + documents.getFirst().getPriceDoc()) * 0.9;
			else if (documents.getFirst().getYear() == currentYear && documents.getFirst().getNext().getYear() != currentYear)
				total = (basePrice + 250000 + documents.getFirst().getNext().getPriceDoc()) * 0.9;
			else if (documents.getFirst().getYear() == currentYear && documents.getFirst().getNext().getYear() == currentYear)
				total = basePrice * 0.9;
		} else if (typeVehicle == 'N')
			total = basePrice + documents.getFirst().getPriceDoc() + documents.getFirst().getNext().getPriceDoc();
		return total;
	}

	/** Name: toString
	 * Method used to print a String that textually represents an object of from Vehicle class with its elements, for files exporting purposes.
	 * @return A String representing the partial information of a vehicle, for files exporting purposes.
	*/
	public String toString(String separator) {
		Soat soat = (Soat) documents.getFirst();
		Review review = (Review) documents.getFirst().getNext();
		return brand + separator + model + separator + typeVehicle + separator + basePrice + separator + (!licensePlate.equals("") ? licensePlate : "NONE") + separator + cylinder + separator + mileage + separator + soat.toString(separator) + separator + review.toString(separator) + separator;
	}
}