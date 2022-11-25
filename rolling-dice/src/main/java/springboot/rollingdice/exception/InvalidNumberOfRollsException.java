package springboot.rollingdice.exception;

public class InvalidNumberOfRollsException extends RuntimeException {

	public InvalidNumberOfRollsException() {
		super();
	}
	
	public InvalidNumberOfRollsException(String message) {
		super(message);
	}
	
}
