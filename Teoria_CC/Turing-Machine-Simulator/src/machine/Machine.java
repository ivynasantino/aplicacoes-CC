package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.DirectionPatternException;
import exceptions.DuplicatedTransitionException;
import exceptions.MissingCommandException;
import exceptions.StateNotFoundException;
import exceptions.StatePatternException;
import util.DataValidator;

public class Machine {

	private List<State> states;
	private State initialState;
	private State acceptState;
	private State rejectState;
	private List<Configuration> configurations;
	private int steps;

	private Tape tape;

	public Machine() {
		this.states = new ArrayList<State>();
		this.configurations = new ArrayList<Configuration>();
		this.tape = new Tape();
		this.steps = 0;

	}

	public void addState(String commandLine)
			throws StatePatternException, DirectionPatternException, DuplicatedTransitionException {
		String[] commands = commandLine.split(" ");

		DataValidator.commandValidator(commands);

		State newState = new State(commands[0]);

		if (!containsState(commands[0])) {
			newState.addTransition(commands[1], commands[2], commands[3], commands[4]);
			states.add(newState);
		} else {
			states.get(states.indexOf(newState)).addTransition(commands[1], commands[2], commands[3], commands[4]);
		}
	}

	private boolean containsState(String newState) {
		for (State state : states) {
			if (state.getName().equalsIgnoreCase(newState)) {
				return true;
			}
		}
		return false;
	}

	public void organizeStates() throws StateNotFoundException {

		DataValidator.commandsValidator(states);

		for (State state : states) {
			if (state.getName().equalsIgnoreCase("q0")) {
				this.initialState = state;
			} else if (state.getName().equalsIgnoreCase("qa")) {
				this.acceptState = state;
			} else if (state.getName().equalsIgnoreCase("qr")) {
				this.rejectState = state;
			}
		}

	}

	public String run() throws MissingCommandException {

		String result = "";
		String currentInput = tape.getPos();
		State currentState = initialState;
		saveState(currentState.getName(), this.tape.getTape(), steps, this.tape.getActualPosition());

		while (true) {

			String[] nextSteps = currentState.processes(currentInput);

			String writeSymbol = nextSteps[0];
			this.tape.write(writeSymbol);

			String newDirection = nextSteps[1];
			this.tape.move(newDirection);
			this.steps++;

			currentInput = tape.getPos();
			currentState = getStateByName(nextSteps[2]);

			if (currentState.equals(acceptState)) {
				saveState(currentState.getName(), this.tape.getTape(), steps, this.tape.getActualPosition());
				result = "=== ACCEPTED ===";
				break;
			} else if (currentState.equals(rejectState)) {
				saveState(currentState.getName(), this.tape.getTape(), steps, this.tape.getActualPosition());
				result = "=== REJECTED ===";
				break;
			}

			saveState(currentState.getName(), this.tape.getTape(), steps, this.tape.getActualPosition());
		}

		return result;

	}

	private void saveState(String currentStateName, String currentTape, int currentSteps, String actualPos ) {
		Configuration config = new Configuration(currentStateName, currentTape, "" + currentSteps, actualPos);
		configurations.add(config);
	}

	private State getStateByName(String stateName) {
		for (State state : this.states) {
			if (state.getName().equalsIgnoreCase(stateName)) {
				return state;
			}
		}
		return null;
	}

	public void insertOnTape(String input) {
		this.tape.insertOnTape(input);

	}

	public void showSteps(Scanner userInput) {
		System.out.print("press 'N' to the next step, or 'E' to run until the end: ");
		String command = userInput.nextLine();
		for (Configuration config : configurations) {
			if (command.equalsIgnoreCase("n")) {
				printConfiguration(config);
				System.out.print("> ");
				command = userInput.nextLine();
			} else if (command.equalsIgnoreCase("e")) {
				printConfiguration(config);
			} else {
				System.out.println("You don't pressed 'N' or 'E' for a valid command, running until the end...");
				printConfiguration(config);
			}
		}
	}

	private void printConfiguration(Configuration config) {
		System.out.println("|| Tape: " + config.getCurrentTape() + " || Head Position: " + config.getCurrentPosition() + " || Current State: " + config.getCurrentState()
				+ " || Steps: " + config.getCurrentSteps() + " ||");
	}

}
