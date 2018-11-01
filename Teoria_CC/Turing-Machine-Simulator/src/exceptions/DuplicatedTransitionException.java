package exceptions;

public class DuplicatedTransitionException extends Exception {

	public DuplicatedTransitionException(String state) {
		super("Your commands have a duplicated line, please fix the problem and rerun the application. State:" + state);
	}
}
