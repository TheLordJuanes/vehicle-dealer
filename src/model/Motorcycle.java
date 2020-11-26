/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public class Motorcycle extends Vehicle implements GasolineConsumable {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	public final static char TYPE_MOTO_STANDARD = 'S';
	public final static char TYPE_MOTO_SPORTY = 'D';
	public final static char TYPE_MOTO_SCOOTER = 'E';
	public final static char TYPE_MOTO_CROSS = 'C';
	public final static String SEPARATOR = " | ";
	public final static String CSV_SEPARATOR = ";";

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private char typeMoto;
	private double capacityGasoline;
	private double consumeGasoline;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Motorcycle
	 * Constructor method of a motorcycle. <br>
	 * @param totalPrice - motorcycle's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - motorcycle's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param brand - motorcycle's brand - brand = String, brand != null, brand != ""
	 * @param model - motorcycle's model - model = int, model != null, model != 0
	 * @param cylinder - motorcycle's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - motorcycle's mileage - mileage = double, mileage != null
	 * @param typeVehicle - motorcycle's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - motorcycle's license plate - licensePlate = String, licensePlate != null
	 * @param owner - gasoline car's owner ID - owner = Client object, owner != null
	 * @param documents - motorcycle's documents - documents = Document[]
	 * @param typeMoto - motorcycle's type - typeMoto = char, typeMoto != null, typeMoto != ''
	 * @param capacityGasoline - gasoline capacity of a motorcycle - capacityGasoline = double, capacityGasoline != null, capacityGasoline != 0
	 * @param consumeGasoline - gasoline consume of a motorcycle - consumeGasoline = double, consumeGasoline != null, consumeGasoline begins in 0
	 */
	public Motorcycle(double totalPrice, double basePrice, String brand, int model, double cylinder, double mileage,
			char typeVehicle, String licensePlate, Client owner, Document documents, char typeMoto,
			double capacityGasoline, double consumeGasoline) {
		super(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle, licensePlate, owner, documents);
		this.typeMoto = typeMoto;
		this.capacityGasoline = capacityGasoline;
		this.consumeGasoline = consumeGasoline;
	}

	/**
	 * Name: getTypeMoto
	 * Method used to get the type of a motorcycle. <br>
	 * @return A double representing the type of a motorcycle.
	*/
	public char getTypeMoto() {
		return this.typeMoto;
	}

	/**
	 * Name: setTypeMoto
	 * Method used to update the type of a motorcycle.  <br>
	 * @param typeMoto - motorcycle's type - typeMoto = char, typeMoto != null, typeMoto != ''
	*/
	public void setTypeMoto(char typeMoto) {
		this.typeMoto = typeMoto;
	}

	/**
	 * Name: getCapacityGasoline
	 * Method used to get the gasoline capacity of a motorcycle. <br>
	 * @return A double representing the gasoline capacity of a motorcycle.
	*/
	public double getCapacityGasoline() {
		return this.capacityGasoline;
	}

	/**
	 * Name: setCapacityGasoline
	 * Method used to update the gasoline capacity of a motorcycle.  <br>
	 * @param capacityGasoline - gasoline capacity of a motorcycle - capacityGasoline = double, capacityGasoline != null, capacityGasoline != 0
	*/
	public void setCapacityGasoline(double capacityGasoline) {
		this.capacityGasoline = capacityGasoline;
	}

	/**
	 * Name: getConsumeGasoline
	 * Method used to get the gasoline consume of a motorcycle. <br>
	 * @return A double representing the gasoline consume of a motorcycle.
	*/
	public double getConsumeGasoline() {
		return calculateConsumeGasoline();
	}

	/**
	 * Name: setConsumeGasoline
	 * Method used to update the gasoline consume of a motorcycle.  <br>
	 * @param consumeGasoline - gasoline consume of a motorcycle - consumeGasoline = double, consumeGasoline != null, consumeGasoline begins in 0
	*/
	public void setConsumeGasoline(double consumeGasoline) {
		this.consumeGasoline = consumeGasoline;
	}

	/** Name: calculateConsumeGasoline
	 * Method rewritten used to calculate the gasoline consume of a motorcycle. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. <br>
	 * <b>post: </b> Gasoline consume of the motorcycle in question calculated. <br>
	 * @return A double representing the gasoline consume of a motorcycle in question.
	*/
	@Override
	public double calculateConsumeGasoline() {
		consumeGasoline = capacityGasoline * (super.getCylinder() / 90);
		return consumeGasoline;
	}

	/** Name: totalSellingPrice
	 * Method rewritten used to continue and finish the calculation of the total selling price of a motorcycle. <br>
	 * <b>pre: </b> List of vehicles already initialized and different from null. Array of the documents of a vehicle already initialized, super.getDocuments != null. <br>
	 * <b>post: </b> Total selling price of the motorcycle calculated. <br>
	 * @return A double representing the total selling price of a motorcycle in question.
	*/
	@Override
	public double getTotalPrice() {
		double total = super.totalSellingPrice();
		double additionalPercentage = 1.04;
		double discount = 0.98;
		if (super.getTypeVehicle() == 'N')
			total *= additionalPercentage;
		else if (super.getTypeVehicle() == 'U')
			total *= additionalPercentage * discount;
		return total;
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Motorcycle class with its elements, for files exporting purposes.
	 * @return A String representing the information of a motorcycle, for files exporting purposes.
  	*/
	@Override
	public String toString(String separator) {
		return super.toString() + typeMoto + separator + capacityGasoline + separator + calculateConsumeGasoline() + separator + totalSellingPrice();
	}
}