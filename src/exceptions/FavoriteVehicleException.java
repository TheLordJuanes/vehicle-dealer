package exceptions;

public class FavoriteVehicleException extends Exception {

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    /**
	 * Name: FavoriteVehicleException
	 * Constructor method of a favorite vehicle exception. <br>
	 * @param message - FavoriteVehicleException's message - message = String, message != null, message != ""
	*/
    public FavoriteVehicleException(String message) {
        super(message);
    }
}