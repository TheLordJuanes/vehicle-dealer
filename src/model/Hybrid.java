/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public class Hybrid extends Car implements GasolineConsumable, BatteryConsumable {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	public final static char TYPE_GASOLINE_EXTRA = 'E';
	public final static char TYPE_GASOLINE_ORDINARY = 'O';
	public final static char TYPE_GASOLINE_DIESEL = 'D';
	public final static char TYPE_CHARGER_FAST = 'F';
	public final static char TYPE_CHARGER_NORMAL = 'N';
	public final static String SEPARATOR = " | ";

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private double capacityGasoline;
	private char typeGasoline;
	private double consumeGasoline;
	private char typeCharger;
	private double durationBattery;
	private double consumeBattery;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Hybrid
	 * Constructor method of an hybrid car. <br>
	 * @param totalPrice - hybrid car's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - hybrid car's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param brand - hybrid car's brand - brand = String, brand != null, brand != ""
	 * @param model - hybrid car's model - model = int, model != null, model != 0
	 * @param cylinder - hybrid car's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - hybrid car's mileage - mileage = double, mileage != null
	 * @param typeVehicle - hybrid car's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - hybrid car's license plate - licensePlate = String, licensePlate != null
	 * @param owner - gasoline car's owner ID - owner = Client object, owner != null
	 * @param documents - hybrid car's documents - documents = Document[]
	 * @param typeCar - hybrid car's type - typeCar = char, typeCar != null, typeCar != ''
	 * @param numDoors - hybrid car's doors number - numDoors = int, numDoors != null, numDoors != 0
	 * @param polarizedWindows - hybrid car's polarized windows declaration - polarizedWindows = boolean, numDoors != null, polarizedWindows begins in false
	 * @param capacityGasoline - gasoline capacity of a gasoline car - capacityGasoline = double, capacityGasoline != null, capacityGasoline != 0
	 * @param typeGasoline - gasoline type of a hybrid car - typeGasoline = char, typeGasoline != null, typeGasoline != ''
	 * @param consumeGasoline - gasoline consume of a hybrid car - consumeGasoline = double, consumeGasoline != null, consumeGasoline begins in 0
	 * @param typeCharger - charger type of a hybrid car - typeCharger = char, typeCharger != null, typeCharger != ''
	 * @param durationBattery - battery duration of a hybrid car - durationBattery = double, durationBattery != null, durationBattery != 0
	 * @param consumeBattery - battery consume of a hybrid car - consumeBattery = double, consumeBattery != null, consumeBattery begins in 0
	 */
	public Hybrid(double totalPrice, double basePrice, String brand, int model, double cylinder, double mileage,
			char typeVehicle, String licensePlate, Client owner, Document documents, char typeCar, int numDoors,
			boolean polarizedWindows, double capacityGasoline, char typeGasoline, double consumeGasoline,
			char typeCharger, double durationBattery, double consumeBattery) {
		super(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle, licensePlate, owner, documents,
				typeCar, numDoors, polarizedWindows);
		this.capacityGasoline = capacityGasoline;
		this.typeGasoline = typeGasoline;
		this.consumeGasoline = consumeGasoline;
		this.typeCharger = typeCharger;
		this.durationBattery = durationBattery;
		this.consumeBattery = consumeBattery;
	}

	/**
	 * Name: getCapacityGasoline
	 * Method used to get the gasoline capacity of a hybrid car. <br>
	 * @return A double representing the gasoline capacity of a hybrid car.
	*/
	public double getCapacityGasoline() {
		return this.capacityGasoline;
	}

	/**
	 * Name: setCapacityGasoline
	 * Method used to update the gasoline capacity of a hybrid car.  <br>
	 * @param capacityGasoline - gasoline capacity of a gasoline car - capacityGasoline = double, capacityGasoline != null, capacityGasoline != 0
	*/
	public void setCapacityGasoline(double capacityGasoline) {
		this.capacityGasoline = capacityGasoline;
	}

	/**
	 * Name: getTypeGasoline
	 * Method used to get the gasoline type of a hybrid car. <br>
	 * @return A char representing the gasoline type of a hybrid car.
	*/
	public char getTypeGasoline() {
		return this.typeGasoline;
	}

	/**
	 * Name: setTypeGasoline
	 * Method used to update the gasoline type of a hybrid car.  <br>
	 * @param typeGasoline - gasoline type of a hybrid car - typeGasoline = char, typeGasoline != null, typeGasoline != ''
	*/
	public void setTypeGasoline(char typeGasoline) {
		this.typeGasoline = typeGasoline;
	}

	/**
	 * Name: getConsumeGasoline
	 * Method used to get the gasoline consume of a hybrid car. <br>
	 * @return A double representing the gasoline consume of a hybrid car.
	*/
	public double getConsumeGasoline() {
		return calculateConsumeGasoline();
	}

	/**
	 * Name: setConsumeGasoline
	 * Method used to update the gasoline consume of a hybrid car.  <br>
	 * @param consumeGasoline - gasoline consume of a hybrid car - consumeGasoline = double, consumeGasoline != null, consumeGasoline begins in 0
	*/
	public void setConsumeGasoline(double consumeGasoline) {
		this.consumeGasoline = consumeGasoline;
	}

	/**
	 * Name: getTypeCharger
	 * Method used to get the charger type of a hybrid car. <br>
	 * @return A char representing the charger type of a hybrid car.
	*/
	public char getTypeCharger() {
		return this.typeCharger;
	}

	/**
	 * Name: setTypeCharger
	 * Method used to update the charger type of a hybrid car.  <br>
	 * @param typeCharger - charger type of a hybrid car - typeCharger = char, typeCharger != null, typeCharger != ''
	*/
	public void setTypeCharger(char typeCharger) {
		this.typeCharger = typeCharger;
	}

	/**
	 * Name: getDurationBattery
	 * Method used to get the battery duration of a hybrid car. <br>
	 * @return A double representing the battery duration of a hybrid car.
	*/
	public double getDurationBattery() {
		return this.durationBattery;
	}

	/**
	 * Name: setDurationBattery
	 * Method used to update the battery duration of a hybrid car.  <br>
	 * @param durationBattery - battery duration of a hybrid car - durationBattery = double, durationBattery != null, durationBattery != 0
	*/
	public void setDurationBattery(double durationBattery) {
		this.durationBattery = durationBattery;
	}

	/**
	 * Name: getConsumeBattery
	 * Method used to get the battery consume of a hybrid car. <br>
	 * @return A double representing the battery consume of a hybrid car.
	*/
	public double getConsumeBattery() {
		return calculateConsumeBattery();
	}

	/**
	 * Name: setConsumeBattery
	 * Method used to update the battery consume of a hybrid car.  <br>
	 * @param consumeBattery - battery consume of a hybrid car - consumeBattery = double, consumeBattery != null, consumeBattery begins in 0
	*/
	public void setConsumeBattery(double consumeBattery) {
		this.consumeBattery = consumeBattery;
	}

	/** Name: calculateConsumeGasoline
	 * Method used to calculate the gasoline consume of a hybrid car. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. <br>
	 * <b>post: </b> Gasoline consume of the hybrid car in question calculated. <br>
	 * @return A double representing the gasoline consume of a hybrid car in question.
	*/
	@Override
	public double calculateConsumeGasoline() {
		consumeGasoline = capacityGasoline * (super.getCylinder() / 100);
		return consumeGasoline;
	}

	/** Name: calculateConsumeBattery
	 * Method rewritten used to calculate the battery consume of a hybrid car. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. <br>
	 * <b>post: </b> Battery consume of the hybrid car in question calculated. <br>
	 * @return A double representing the battery consume of a hybrid car in question.
	*/
	@Override
	public double calculateConsumeBattery() {
		if (typeCharger == 'F')
			consumeBattery = durationBattery * (super.getCylinder() / 100);
		else if (typeCharger == 'N')
			consumeBattery = (durationBattery + 5) * (super.getCylinder() / 100);
		return consumeBattery;
	}

	/** Name: totalSellingPrice
	 * Method rewritten used to continue and finish the calculation of the total selling price of a car, specifically of a hybrid one. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. Array of the documents of a vehicle already initialized, super.getDocuments != null. <br>
	 * <b>post: </b> Total selling price of the hybrid car calculated. <br>
	 * @return A double representing the total selling price of a hybrid car in question.
	*/
	@Override
	public double getTotalPrice() {
		double additionalPercentage = 1.15;
		double total = super.totalSellingPrice() * additionalPercentage;
		return total;
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Hybrid class with its elements, for files exporting purposes.
	 * @return A String representing the information of a hybrid car, for files exporting purposes.
  	*/
	@Override
	public String toString(String separator) {
		return super.toString() + typeGasoline + separator + capacityGasoline + separator + calculateConsumeGasoline() + separator + typeCharger + separator + durationBattery + separator + calculateConsumeBattery() + separator + totalSellingPrice();
	}
}