/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public class Electric extends Car implements BatteryConsumable {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	public final static char TYPE_CHARGER_FAST = 'F';
	public final static char TYPE_CHARGER_NORMAL = 'N';

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private char typeCharger;
	private double durationBattery;
	private double consumeBattery;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Electric
	 * Constructor method of an electric car. <br>
	 * @param totalPrice - electric car's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - electric car's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param brand - electric car's brand - brand = String, brand != null, brand != ""
	 * @param model - electric car's model - model = int, model != null, model != 0
	 * @param cylinder - electric car's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - electric car's mileage - mileage = double, mileage != null
	 * @param typeVehicle - electric car's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - electric car's license plate - licensePlate = String, licensePlate != null
	 * @param owner - gasoline car's owner ID - owner = Client object, owner != null
	 * @param documents - electric car's documents - documents = Document[]
	 * @param typeCar - electric car's type - typeCar = char, typeCar != null, typeCar != ''
	 * @param numDoors - electric car's doors number - numDoors = int, numDoors != null, numDoors != 0
	 * @param polarizedWindows - electric car's polarized windows declaration - polarizedWindows = boolean, numDoors != null, polarizedWindows begins in false
	 * @param typeCharger - charger type of an electric car - typeCharger = char, typeCharger != null, typeCharger != ''
	 * @param durationBattery - battery duration of an electric car - durationBattery = double, durationBattery != null, durationBattery != 0
	 * @param consumeBattery - battery consume of an electric car - consumeBattery = double, consumeBattery != null, consumeBattery begins in 0
	 */
	public Electric(double totalPrice, double basePrice, String brand, int model, double cylinder, double mileage,
			char typeVehicle, String licensePlate, Client owner, Document documents, char typeCar, int numDoors,
			boolean polarizedWindows, char typeCharger, double durationBattery, double consumeBattery) {
		super(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle, licensePlate, owner, documents,
				typeCar, numDoors, polarizedWindows);
		this.typeCharger = typeCharger;
		this.durationBattery = durationBattery;
		this.consumeBattery = consumeBattery;
	}

	/**
	 * Name: getTypeCharger
	 * Method used to get the charger type of an electric car. <br>
	 * @return A char representing the charger type of an electric car.
	*/
	public char getTypeCharger() {
		return this.typeCharger;
	}

	/**
	 * Name: setTypeCharger
	 * Method used to update the charger type of an electric car.  <br>
	 * @param typeCharger - charger type of an electric car - typeCharger = char, typeCharger != null, typeCharger != ''
	*/
	public void setTypeCharger(char typeCharger) {
		this.typeCharger = typeCharger;
	}

	/**
	 * Name: getDurationBattery
	 * Method used to get the battery duration of an electric car. <br>
	 * @return A double representing the battery duration of an electric car.
	*/
	public double getDurationBattery() {
		return this.durationBattery;
	}

	/**
	 * Name: setDurationBattery
	 * Method used to update the battery duration of an electric car.  <br>
	 * @param durationBattery - battery duration of an electric car - durationBattery = double, durationBattery != null, durationBattery != 0
	*/
	public void setDurationBattery(double durationBattery) {
		this.durationBattery = durationBattery;
	}

	/**
	 * Name: getConsumeBattery
	 * Method used to get the battery consume of an electric car. <br>
	 * @return A double representing the battery consume of an electric car.
	*/
	public double getConsumeBattery() {
		return calculateConsumeBattery();
	}

	/**
	 * Name: setConsumeBattery
	 * Method used to update the battery consume of an electric car.  <br>
	 * @param consumeBattery - battery consume of an electric car - consumeBattery = double, consumeBattery != null, consumeBattery begins in 0
	*/
	public void setConsumeBattery(double consumeBattery) {
		this.consumeBattery = consumeBattery;
	}

	/** Name: calculateConsumeBattery
	 * Method rewritten used to calculate the battery consume of an electric car. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. <br>
	 * <b>post: </b> Battery consume of the electric car in question calculated. <br>
	 * @return A double representing the battery consume of an electric car in question.
	*/
	public double calculateConsumeBattery() {
		if (typeCharger == 'F')
			consumeBattery = (durationBattery + 10) * (super.getCylinder() / 100);
		else if (typeCharger == 'N')
			consumeBattery = (durationBattery + 15) * (super.getCylinder() / 100);
		return consumeBattery;
	}

	/** Name: totalSellingPrice
	 * Method rewritten used to continue and finish the calculation of the total selling price of a car, specifically of an electric one. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. Array of the documents of a vehicle already initialized, super.getDocuments != null. <br>
	 * <b>post: </b> Total selling price of the electric car calculated. <br>
	 * @return A double representing the total selling price of an electric car in question.
	*/
	@Override
	public double getTotalPrice() {
		double additionalPercentage = 1.2;
		double total = super.totalSellingPrice() * additionalPercentage;
		return total;
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Electric class with its elements, for files exporting purposes.
	 * @return A String representing the information of an electric car, for files exporting purposes.
  	*/
	@Override
	public String toString(String separator) {
		return super.toString(separator) + typeCharger + separator + durationBattery + separator + calculateConsumeBattery() + separator + totalSellingPrice();
	}
}