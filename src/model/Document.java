/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.Serializable;
import java.util.Random;

public class Document implements Serializable {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	public final static int NUM_ROWS_AND_COLUMNS = 4;

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private double priceDoc;
	private int year;
	private int[][] matrix;
	private String codeDoc;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private Document first;
	private Document next;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/** Name: Document
	 * Constructor method of a vehicle document. <br>
	 * @param priceDoc - document price of a vehicle - priceDoc = double, priceDoc != null, priceDoc != 0
	 * @param year - document year of a vehicle - year = int, year != null, year begins in 0 if typeVehicle == 'N' else year =! 0
	 * @param codeDoc - document code of a vehicle - codeDoc = String, codeDoc != null, codeDoc begins as "" if typeVehicle == 'N' else codeDoc =! ""
	 */
	public Document(double priceDoc, int year, String codeDoc) {
		this.priceDoc = priceDoc;
		this.year = year;
		this.codeDoc = codeDoc;
	}

	public Document() {
	}

	/**
	 * Name: getPriceDoc
	 * Method used to get the document price of a vehicle. <br>
	 * @return A double representing the document price of a vehicle.
	*/
	public double getPriceDoc() {
		return this.priceDoc;
	}

	/**
	 * Name: setPriceDoc
	 * Method used to update the document price of a vehicle.  <br>
	 * @param priceDoc - document price of a vehicle - priceDoc = double, priceDoc != null, priceDoc != 0
	*/
	public void setPriceDoc(double priceDoc) {
		this.priceDoc = priceDoc;
	}

	/**
	 * Name: getYear
	 * Method used to get the document year of a vehicle. <br>
	 * @return A double representing the document year of a vehicle.
	*/
	public int getYear() {
		return this.year;
	}

	/**
	 * Name: setYear
	 * Method used to update the document year of a vehicle.  <br>
	 * @param year - document year of a vehicle - year = int, year != null, year begins in 0 if typeVehicle == 'N' else year =! 0
	*/
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Name: getMatrix
	 * Method used to get a random square matrix (matrix) 4x4 . <br>
	 * @return A random square matrix nxn to it to be evoked in class Soat and in class Review to decode the code of a vehicle documents.
	 */
	public int[][] getMatrix() {
		matrix = new int[NUM_ROWS_AND_COLUMNS][NUM_ROWS_AND_COLUMNS];
		Random r = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++)
				matrix[i][j] = r.nextInt(100) + 1;
		}
		return matrix;
	}

	/**
	 * Name: getCodeDoc
	 * Method used to get the document code of a vehicle. <br>
	 * @return A String representing the document code of a vehicle.
	 */
	public String getCodeDoc() {
		return codeDoc;
	}

	/**
	 * Name: setCodeDoc
	 * Method used to update the document code of a vehicle.  <br>
	 * @param codeDoc - document code of a vehicle - codeDoc = String, codeDoc != null, codeDoc begins as "" if typeVehicle == 'N' else codeDoc =! ""
	*/
	public void setCodeDoc(String codeDoc) {
		this.codeDoc = codeDoc;
	}

	public Document getFirst() {
		return first;
	}

	public void setFirst(Document first) {
		this.first = first;
	}

	public Document getNext() {
		return next;
	}

	public void setNext(Document next) {
		this.next = next;
	}

	/**
	 * Name: decodeCode
	 * <b>pre: </b> Document array already exists. documents!=null
	 * Declared method used to decode the code of a document in class Soat and/or in class Review.
	 * @return An empty String.
	 */
	public String decodeCode(){
		return "";
	}

	/** Name: toString
	 * Method rewritten used to print a String that textually represents an object of from Document class with its elements, for files exporting purposes.
	 * @return A String representing the partial information of a document, for files exporting purposes.
  	*/
	public String toString(String separator) {
		return (!codeDoc.equals("") ? codeDoc : "NONE") + separator + priceDoc + separator + (year != 0 ? year : 0) + separator;
	}
}