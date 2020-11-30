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

    public Ringlet() {
        squares = new ArrayList<Square>();
        spin = true;
    }

    public boolean getSpin() {
        return spin;
    }

    public void setSpin(boolean spin) {
        this.spin = spin;
    }

    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public void addSquare(double rotation) {
        Square s = new Square(rotation);
        squares.add(s);
    }

    public void rotateSquares() {
        for (Square s : squares)
            s.rotate();
    }
}