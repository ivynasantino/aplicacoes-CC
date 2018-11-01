package exceptions;

public class DirectionPatternException extends Exception {

	public DirectionPatternException() {
		super("The direction of the command doesn't match the pattern 'l', 'r' or '*'.");
	}

}
