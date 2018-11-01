package exceptions;

public class StateNotFoundException extends Exception {
	public StateNotFoundException(String string) {
		super("Your commands doesn't have a " + string + " state");
	}
}
