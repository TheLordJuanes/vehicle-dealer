/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public class Review extends Document {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private double gasLevel;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Review
	 * Constructor method of a Mechanical Technical Review document. <br>
	 * @param priceDoc - price of the SOAT document of a vehicle - priceDoc = double, priceDoc != null, priceDoc != 0
	 * @param year - year of the SOAT document of a vehicle - year = int, year != null, year begins in 0 if typeVehicle == 'N' else year =! 0
	 * @param codeDoc - code of the Mechanical Technical Review document of a vehicle - codeDoc = String, codeDoc != null, codeDoc begins as "" if typeVehicle == 'N' else codeDoc =! ""
	 * @param gasLevel - gas level thrown by a vehicle (Mechanical Technical Review document information) - gasLevel = double, gasLevel != null, gasLevel begins in 0 if typeVehicle == 'N' else gasLevel =! 0
	 */
	public Review(double priceDoc, int year, String codeDoc, double gasLevel) {
		super(priceDoc, year, codeDoc);
		this.gasLevel = gasLevel;
	}

	/**
	 * Name: getGasLevelCar
	 * Method used to get the gas level thrown by a vehicle. <br>
	 * @return A double representing the gas level thrown by a vehicle.
	*/
	public double getGasLevelCar() {
		return gasLevel;
	}

	/**
	 * Name: setGasLevelCar
	 * Method used to update the gas level thrown by a vehicle.  <br>
	 * @param gasLevel - gas level thrown by a vehicle (Mechanical Technical Review document information) - gasLevel = double, gasLevel != null, gasLevel begins in 0 if typeVehicle == 'N' else gasLevel =! 0
	*/
	public void setGasLevelCar(double gasLevel) {
		this.gasLevel = gasLevel;
	}

	/** Name: decodeCode
	 * <b>pre: </b> Document array already exists. documents!=null
	 * Method rewritten used to decode the code of the Mechanical Technical Review document.
	 * @return A String representing the code of the Mechanical Technical Review document.
	*/
	@Override
	public String decodeCode() {
		String codeDoc = "";
		int[][] imageReview=getMatrix();
		for (int i = 0; i < imageReview.length; i++) {
			codeDoc += imageReview[0][i] + " ";
		}
		for (int i = 1; i < imageReview.length; i++) {
			codeDoc += imageReview[i][imageReview.length - 1 - i] + " ";
		}
		for (int i = 1; i < imageReview.length; i++) {
			codeDoc += imageReview[imageReview.length - 1][i] + " ";
		}
		return codeDoc;
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Review class with its elements, for files exporting purposes.
	 * @return A String representing the partial information of the mechanical technical review document of a vehicle, for files exporting purposes.
  	*/
	@Override
	public String toString(String separator) {
		return super.toString(separator) + gasLevel;
	}
}
