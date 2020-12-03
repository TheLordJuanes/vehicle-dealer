/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public abstract class Car extends Vehicle {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	public final static char TYPE_CAR_SEDAN = 'S';
	public final static char TYPE_CAR_VAN = 'V';

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private char typeCar;
	private int numDoors;
	private boolean polarizedWindows;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Car
	 * Constructor method of a car. <br>
	 * @param totalPrice - car's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - car's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param brand - car's brand - brand = String, brand != null, brand != ""
	 * @param model - car's model - model = int, model != null, model != 0
	 * @param cylinder - car's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - car's mileage - mileage = double, mileage != null
	 * @param typeVehicle - car's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - car's license plate - licensePlate = String, licensePlate != null
	 * @param owner - gasoline car's owner ID - owner = Client object, owner != null
	 * @param documents - car's documents - documents = Document[]
	 * @param typeCar - car's type - typeCar = char, typeCar != null, typeCar != ''
	 * @param numDoors - car's doors number - numDoors = int, numDoors != null, numDoors != 0
	 * @param polarizedWindows - car's polarized windows declaration - polarizedWindows = boolean, numDoors != null, polarizedWindows begins in false
	*/
	public Car(double totalPrice, double basePrice, String brand, int model, double cylinder, double mileage,
			char typeVehicle, String licensePlate, String ownerID, Document documents, char typeCar, int numDoors,
			boolean polarizedWindows) {
		super(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle, licensePlate, ownerID, documents);
		this.typeCar = typeCar;
		this.numDoors = numDoors;
		this.polarizedWindows = polarizedWindows;
	}

	/**
	 * Name: getTypeCar
	 * Method used to get the type of a car. <br>
	 * @return A char representing the type of a car.
	*/
	public char getTypeCar() {
		return this.typeCar;
	}

	/**
	 * Name: setTypeCar
	 * Method used to update the type of a car.  <br>
	 * @param typeCar - car's type - typeCar = char, typeCar != null, typeCar != ''
	*/
	public void setTypeCar(char typeCar) {
		this.typeCar = typeCar;
	}

	/**
	 * Name: getNumDoors
	 * Method used to get the doors number of a car. <br>
	 * @return An int representing the doors number of a car.
	*/
	public int getNumDoors() {
		return this.numDoors;
	}

	/**
	 * Name: setNumDoors
	 * Method used to update the doors number of a car.  <br>
	 * @param numDoors - car's doors number - numDoors = int, numDoors != null, numDoors != 0
	*/
	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}

	/**
	 * Name: getPolarizedWindows
	 * Method used to get the polarized windows declaration of a car. <br>
	 * @return A boolean representing the polarized windows declaration of a car.
	*/
	public boolean getPolarizedWindows() {
		return this.polarizedWindows;
	}

	/**
	 * Name: setNumDoors
	 * Method used to update the polarized windows declaration of a car.  <br>
	 * @param polarizedWindows - car's polarized windows declaration - polarizedWindows = boolean, numDoors != null, polarizedWindows begins in false
	*/
	public void setPolarizedWindows(boolean polarizedWindows) {
		this.polarizedWindows = polarizedWindows;
	}

	/** Name: totalSellingPrice
	 * Method rewritten used to continue the calculation of the total selling price of a car. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. Array of the documents of a vehicle already initialized, getDocuments != null. <br>
	 * <b>post: </b> Total selling price of the car is still calculated partially. <br>
	 * @return A double representing the partial total selling price of a car in question.
	*/
	@Override
	public double totalSellingPrice() {
		double discount = 0.9;
		double total = super.totalSellingPrice();
		if (super.getTypeVehicle() == 'U')
			total *= discount;
		return total;
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Car class with its elements, for files exporting purposes.
	 * @return A String representing the partial information of a car, for files exporting purposes.
	*/
	@Override
	public String toString(String separator) {
		return super.toString(separator) + typeCar + separator + numDoors + separator + polarizedWindows + separator;
	}
}