package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.DuplicatedTransitionException;
import exceptions.MachineSyntaxException;
import exceptions.MissingCommandException;
import exceptions.StateNotFoundException;
import machine.FactoryMachine;
import machine.Machine;
import util.FReader;

public class TmsController {
	private List<String> commandLines;
	private Machine machine;

	public TmsController() {
		this.commandLines = new ArrayList<String>();
	}

	public void mountMachine(Scanner userInput)
			throws MachineSyntaxException, StateNotFoundException, DuplicatedTransitionException {

		readCommands(userInput);
		machine = FactoryMachine.getMachine(commandLines);

	}

	public void readCommands(Scanner userInput) {
		int countLine = 1;
		System.out.print(countLine + ". ");
		String input = userInput.nextLine();
		countLine++;

		while (true) {
			if (input.equalsIgnoreCase("end")) {
				break;
			} else if (!input.startsWith("!!") || !input.startsWith("!! ")) {
				commandLines.add(input);
			}

			System.out.print(countLine + ". ");
			input = userInput.nextLine();
			countLine++;
		}

	}


	public void mountMachine(String path) throws IOException, MachineSyntaxException, StateNotFoundException, DuplicatedTransitionException{
		
		ArrayList<String> commands = FReader.readFile(path);
		for (String line : commands) {
			commandLines.add(line);
		}
		machine = FactoryMachine.getMachine(commandLines);
		
	}

	public void runMachine(Scanner userInput) throws MissingCommandException {
		
		String input = userInput.nextLine();
		
		machine.insertOnTape(input);
		
		String result = machine.run();
		
		machine.showSteps(userInput);
		
		System.out.println(result);
		
	}
}
