package Exceptions;


// TODO: Auto-generated Javadoc
/**
 * The Class WrongPasswordException.
 */
public class WrongKeyException extends Exception{
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
     * Instantiates a new wrong password exception.
     *
     * @param message the message
     */
    public WrongKeyException(String message) {
    	super(message);
    }
}

