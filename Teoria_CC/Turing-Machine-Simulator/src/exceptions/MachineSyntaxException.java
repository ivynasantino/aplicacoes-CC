package exceptions;

public class MachineSyntaxException extends Exception {

	public MachineSyntaxException(String message, int line) {
		super("At line "+ (line + 1) + ". " + message );
	}

}
