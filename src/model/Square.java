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

    public Square(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void rotate() {
        rotation = (rotation + ANGLE_ROTATE) % 360;
    }
}