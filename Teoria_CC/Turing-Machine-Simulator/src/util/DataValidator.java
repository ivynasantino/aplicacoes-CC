package util;

import java.util.List;

import exceptions.DirectionPatternException;
import exceptions.DuplicatedTransitionException;
import exceptions.MissingCommandException;
import exceptions.StateNotFoundException;
import exceptions.StatePatternException;
import machine.State;

public class DataValidator {

	public static void commandValidator(String[] commands) throws StatePatternException, DirectionPatternException {

		String statePattern = "q[\\w\\d]+";
		String directionPattern = "[l,r,*]";

		if (!commands[0].matches(statePattern) || !commands[4].matches(statePattern)) {
			throw new StatePatternException();

		}
		if (!commands[3].matches(directionPattern)) {
			throw new DirectionPatternException();

		}
	}

	public static void commandsValidator(List<State> states) throws StateNotFoundException {

		boolean hasQ0 = false;
		boolean hasQA = false;
		boolean hasQR = false;

		for (State state : states) {
			if (state.getName().equalsIgnoreCase("q0")) {
				hasQ0 = true;
			}

			if (state.getName().equalsIgnoreCase("qa")) {
				hasQA = true;
			}
			if (state.getName().equalsIgnoreCase("qr")) {
				hasQR = true;
			}
		}

		if (hasQ0 == false) {
			throw new StateNotFoundException("initial");
		}

		if (hasQA == false) {
			throw new StateNotFoundException("acceptance");
		}

		if (hasQR == false) {
			throw new StateNotFoundException("rejection");
		}

	}

	public static void inputValidator(State state, String actualInput) throws MissingCommandException {
		if (!state.getFunctions().containsKey(actualInput) && !state.getFunctions().containsKey("*")) {
			throw new MissingCommandException(state.getName(), actualInput);
		}

	}

	public static void transitionValidator(State state, String inputSymbol, String directionSymbol, String newState)
			throws DuplicatedTransitionException {
		if (state.getFunctions().containsKey(inputSymbol)) {
			if (state.getFunctions().get(inputSymbol).contains(directionSymbol)) {
				if (state.getFunctions().get(inputSymbol).contains(newState)) {
					throw new DuplicatedTransitionException(state.getName());
				}
			}
		}

	}

}
