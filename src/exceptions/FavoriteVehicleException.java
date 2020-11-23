package exceptions;

public class FavoriteVehicleException extends Exception {

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    public FavoriteVehicleException(String message) {
        super(message);
    }
}
