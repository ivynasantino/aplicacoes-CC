package exceptions;

public class MissingCommandException extends Exception {
	public MissingCommandException(String state, String input) {
		super("The state " + state + " cannot process the " + input
				+ " character, please check your commands and try again.");
	}
}
