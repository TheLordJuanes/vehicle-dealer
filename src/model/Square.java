/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

public class Square { // class taken from Juan Manuel Reyes' repository https://github.com/seyerman/java-intermediate-course-examples/blob/master/jfx-thread-ringlete/src/model/Square.java

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

    public final static double ANGLE_ROTATE = 1;

    // -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

    private double rotation;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    /** Name: Square
	 * Constructor method of a square. <br>
     * @param rotation - Square's rotation - rotation = double, rotation != null
	*/
    public Square(double rotation) {
        this.rotation = rotation;
    }

    /**
	 * Name: getRotation
	 * Method used to get the rotation of a square. <br>
	 * @return A double representing the rotation of a square.
	*/
    public double getRotation() {
        return rotation;
    }

    /**
	 * Name: setRotation
	 * Method used to update the rotation of a square. <br>
     * @param rotation - Square's rotation - rotation = double, rotation != null
	*/
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    /** Name: rotate
	 * Method used to rotate a square. <br>
     * <b>pre: </b> Square object already created. <br>
     * <b>post: </b> Rotated square. <br>
	*/
    public void rotate() {
        rotation = (rotation + ANGLE_ROTATE) % 360;
    }
}