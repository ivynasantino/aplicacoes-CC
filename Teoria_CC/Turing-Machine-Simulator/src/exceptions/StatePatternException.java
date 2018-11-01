package exceptions;

public class StatePatternException extends Exception {
	public StatePatternException() {
		super("The state of the command doesn't match the pattern 'q<digit,a,r>'.");
	}

}
