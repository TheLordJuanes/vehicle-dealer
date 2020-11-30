/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public class Soat extends Document {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private double coverageAmount;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Soat
	 * Constructor method of a SOAT document. <br>
	 * @param priceDoc - price of the SOAT document of a vehicle - priceDoc = double, priceDoc != null, priceDoc != 0
	 * @param year - year of the SOAT document of a vehicle - year = int, year != null, year begins in 0 if typeVehicle == 'N' else year =! 0
	 * @param codeDoc - code of the Soat document of a vehicle - codeDoc = String, codeDoc != null, codeDoc begins as "" if typeVehicle == 'N' else codeDoc =! ""
	 * @param coverageAmount - coverage amount of the SOAT document of a vehicle - coverageAmount = double, coverageAmount != null, coverageAmount != 0
	 */
	public Soat(double priceDoc, int year, String codeDoc, double coverageAmount) {
		super(priceDoc, year, codeDoc);
		this.coverageAmount = coverageAmount;
	}

	/**
	 * Name: getCoverageAmount
	 * Method used to get the coverage amount of the SOAT document of a vehicle. <br>
	 * @return A double representing the coverage amount of the Soat document of a vehicle.
	*/
	public double getCoverageAmount() {
		return coverageAmount;
	}

	/**
	 * Name: setCoverageAmount
	 * Method used to update the coverage amount of the SOAT document of a vehicle.  <br>
	 * @param coverageAmount - coverage amount of the SOAT document of the electric car - coverageAmount = double, coverageAmount != null, coverageAmount != 0
	*/
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	/** Name: decodeCode
	 * <b>pre: </b> Document array already exists. documents!=null
	 * Method rewritten used to decode the code of the SOAT document.
	 * @return A String representing the code of the SOAT document.
	*/
	@Override
	public String decodeCode() {
		String codeDoc = "";
		int[][] imageSoat = getMatrix();
		for (int i = 0; i < imageSoat.length; i++)
			codeDoc += imageSoat[i][0] + " ";
		for (int i = 1; i < imageSoat.length; i++)
			codeDoc += imageSoat[imageSoat.length - 1][i] + " ";
		return codeDoc;
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Soat class with its elements, for files exporting purposes.
	 * @return A String representing the partial information of the SOAT document of a vehicle, for files exporting purposes.
  	*/
	@Override
	public String toString(String separator) {
		return super.toString(separator) + coverageAmount;
	}
}