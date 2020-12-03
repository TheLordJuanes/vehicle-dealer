package exceptions;

public class LackOfLandException extends Exception {

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    /**
	 * Name: LackOfLandException
	 * Constructor method of a lack of land exception exception. <br>
	 * @param message - LackOfLandException's message - message = String, message != null, message != ""
	*/
    public LackOfLandException(String message) {
        super(message);
    }
}