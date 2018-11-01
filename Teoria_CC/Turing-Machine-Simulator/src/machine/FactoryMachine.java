package machine;

import java.util.List;

import exceptions.DirectionPatternException;
import exceptions.DuplicatedTransitionException;
import exceptions.MachineSyntaxException;
import exceptions.StateNotFoundException;
import exceptions.StatePatternException;

public class FactoryMachine {

	public static Machine getMachine(List<String> commandLines) throws MachineSyntaxException, StateNotFoundException {

		Machine machine = new Machine();

		for (int line = 0; line < commandLines.size(); line++) {
			try {
				if (!commandLines.get(line).startsWith("!!")) {
					machine.addState(commandLines.get(line));
				}

			} catch (DuplicatedTransitionException | StatePatternException | DirectionPatternException e) {
				throw new MachineSyntaxException(e.getMessage(), line);
			}

		}
		try {
			machine.organizeStates();
		} catch (StateNotFoundException e) {
			throw e;
		}
		return machine;

	}

}
