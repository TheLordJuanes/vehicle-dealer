/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.util.ArrayList;
import java.util.List;

public class Ringlet { // class taken from Juan Manuel Reyes' repository https://github.com/seyerman/java-intermediate-course-examples/blob/master/jfx-thread-ringlete/src/model/Ringlete.java

    // -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

    private boolean spin;

    // -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

    private List<Square> squares;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    /** Name: Ringlet
	 * Constructor method of a ringlet. <br>
	*/
    public Ringlet() {
        squares = new ArrayList<Square>();
        spin = true;
    }

    /**
	 * Name: getSpin
	 * Method used to get the ringlet spin status. <br>
	 * @return A boolean representing the ringlet spin status.
	*/
    public boolean getSpin() {
        return spin;
    }

    /**
	 * Name: setSpin
	 * Method used to update the ringlet spin status. <br>
     * @param spin - Ringlet spin status - spin = boolean, spin begins in true
	*/
    public void setSpin(boolean spin) {
        this.spin = spin;
    }

    /**
	 * Name: getSquares
	 * Method used to get the list of squares of the ringlet. <br>
	 * @return A List<Square> representing the list of squares of the ringlet.
	*/
    public List<Square> getSquares() {
        return squares;
    }

    /**
	 * Name: setSquares
	 * Method used to update the list of squares of the ringlet. <br>
     * @param squares - List of squares of the ringlet - squares = List<Square>
	*/
    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    /** Name: addSquare
     * Method used to add a square to the list of squares of the ringlet. <br>
     * <b>pre: </b> List of squares already initialized. <br>
     * <b>post: </b> Square added to the list of squares of the ringlet. <br>
	 * @param rotation - Square's rotation - rotation = double, rotation != null
	*/
    public void addSquare(double rotation) {
        Square s = new Square(rotation);
        squares.add(s);
    }

    /** Name: rotateSquares
	 * Method used to rotate the squares present in the list of squares of the ringlet. <br>
     * <b>pre: </b> List of squares already initialized. <br>
     * <b>post: </b> Squares in the list of squares of the ringlet rotated. <br>
	*/
    public void rotateSquares() {
        for (Square s : squares)
            s.rotate();
    }
}