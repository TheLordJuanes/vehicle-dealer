package exceptions;

public class LackOfLandException extends Exception {

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    public LackOfLandException(String message) {
        super(message);
    }
}
