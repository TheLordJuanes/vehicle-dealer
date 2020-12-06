/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public class Gasoline extends Car implements GasolineConsumable {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	public final static char TYPE_GASOLINE_EXTRA = 'E';
	public final static char TYPE_GASOLINE_ORDINARY = 'O';
	public final static char TYPE_GASOLINE_DIESEL = 'D';

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private double capacityGasoline;
	private char typeGasoline;
	private double consumeGasoline;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Gasoline
	 * Constructor method of a gasoline car. <br>
	 * @param totalPrice - gasoline car's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - gasoline car's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param brand - gasoline car's brand - brand = String, brand != null, brand != ""
	 * @param model - gasoline car's model - model = int, model != null, model != 0
	 * @param cylinder - gasoline car's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - gasoline car's mileage - mileage = double, mileage != null
	 * @param typeVehicle - gasoline car's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - gasoline car's license plate - licensePlate = String, licensePlate != null
	 * @param owner - gasoline car's owner ID - owner = Client object, owner != null
	 * @param documents - gasoline car's documents - documents = Document[]
	 * @param typeCar - gasoline car's type - typeCar = char, typeCar != null, typeCar != ''
	 * @param numDoors - gasoline car's doors number - numDoors = int, numDoors != null, numDoors != 0
	 * @param polarizedWindows - gasoline car's polarized windows declaration - polarizedWindows = boolean, numDoors != null, polarizedWindows begins in false
	 * @param capacityGasoline - gasoline capacity of a gasoline car - capacityGasoline = double, capacityGasoline != null, capacityGasoline != 0
	 * @param typeGasoline - gasoline type of a gasoline car - typeGasoline = char, typeGasoline != null, typeGasoline != ''
	 * @param consumeGasoline - gasoline consume of a gasoline car - consumeGasoline = double, consumeGasoline != null, consumeGasoline begins in 0
	*/
	public Gasoline(double totalPrice, double basePrice, String brand, int model, double cylinder, double mileage,
			char typeVehicle, String licensePlate, String ownerID, Document documents, char typeCar, int numDoors,
			boolean polarizedWindows, double capacityGasoline, char typeGasoline, double consumeGasoline) {
		super(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle, licensePlate, ownerID, documents,
				typeCar, numDoors, polarizedWindows);
		this.capacityGasoline = capacityGasoline;
		this.typeGasoline = typeGasoline;
		this.consumeGasoline = consumeGasoline;
	}

	/**
	 * Name: getCapacityGasoline
	 * Method used to get the gasoline capacity of a gasoline car. <br>
	 * @return A double representing the gasoline capacity of a gasoline car.
	*/
	public double getCapacityGasoline() {
		return this.capacityGasoline;
	}

	/**
	 * Name: setCapacityGasoline
	 * Method used to update the gasoline capacity of a gasoline car.  <br>
	 * @param capacityGasoline - gasoline capacity of a gasoline car - capacityGasoline = double, capacityGasoline != null, capacityGasoline != 0
	*/
	public void setCapacityGasoline(double capacityGasoline) {
		this.capacityGasoline = capacityGasoline;
	}

	/**
	 * Name: getTypeGasoline
	 * Method used to get the gasoline type of a gasoline car. <br>
	 * @return A char representing the gasoline type of a gasoline car.
	*/
	public char getTypeGasoline() {
		return this.typeGasoline;
	}

	/**
	 * Name: setTypeGasoline
	 * Method used to update the gasoline type of a gasoline car.  <br>
	 * @param typeGasoline - gasoline type of a gasoline car - typeGasoline = char, typeGasoline != null, typeGasoline != ''
	*/
	public void setTypeGasoline(char typeGasoline) {
		this.typeGasoline = typeGasoline;
	}

	/**
	 * Name: getConsumeGasoline
	 * Method used to get the gasoline consume of a gasoline car. <br>
	 * @return A double representing the gasoline consume of a gasoline car.
	*/
	public double getConsumeGasoline() {
		return calculateConsumeGasoline();
	}

	/**
	 * Name: setConsumeGasoline
	 * Method used to update the gasoline consume of a gasoline car.  <br>
	 * @param consumeGasoline - gasoline consume of a gasoline car - consumeGasoline = double, consumeGasoline != null, consumeGasoline begins in 0
	*/
	public void setConsumeGasoline(double consumeGasoline) {
		this.consumeGasoline = consumeGasoline;
	}

	/** Name: calculateConsumeGasoline
	 * Method rewritten used to calculate the gasoline consume of a gasoline car. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. <br>
	 * <b>post: </b> Gasoline consume of the gasoline car in question calculated. <br>
	 * @return A double representing the gasoline consume of a gasoline car in question.
	*/
	@Override
	public double calculateConsumeGasoline() {
		consumeGasoline = capacityGasoline * (super.getCylinder() / 100);
		return consumeGasoline;
	}

	/** Name: totalSellingPrice
	 * Method rewritten used to continue and finish the calculation of the total selling price of a car, specifically of a gasoline one. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. Array of the documents of a vehicle already initialized, super.getDocuments != null. <br>
	 * <b>post: </b> Total selling price of the gasoline car calculated. <br>
	 * @return A double representing the total selling price of a gasoline car in question.
	*/
	@Override
	public double getTotalPrice() {
		return super.totalSellingPrice();
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Gasoline class with its elements, for files exporting purposes.
	 * @return A String representing the information of a gasoline car, for files exporting purposes.
	*/
	@Override
	public String toString(String separator) {
		return super.toString(separator) + typeGasoline + separator + capacityGasoline + separator + calculateConsumeGasoline() + separator + totalSellingPrice();
	}
}