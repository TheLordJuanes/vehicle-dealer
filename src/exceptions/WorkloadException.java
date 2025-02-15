package exceptions;

public class WorkloadException extends Exception {

    // -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    /**
	 * Name: WorkloadException
	 * Constructor method of a workload exception. <br>
	 * @param message - WorkloadException's message - message = String, message != null, message != ""
	*/
    public WorkloadException(String message) {
        super(message);
    }
}