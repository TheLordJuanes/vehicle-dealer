package exceptions;

public class WorkloadException extends Exception {

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    public WorkloadException(String message) {
        super(message);
    }
}
