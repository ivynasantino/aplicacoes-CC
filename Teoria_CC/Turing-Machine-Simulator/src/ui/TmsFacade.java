package ui;

import java.io.IOException;
import java.util.Scanner;

import exceptions.DuplicatedTransitionException;
import exceptions.MachineSyntaxException;
import exceptions.StateNotFoundException;

public class TmsFacade {

	private Scanner sc;
	private TmsController controller;

	public void start() {

		controller = new TmsController();
		sc = new Scanner(System.in);

		printHeader();

		String opt = sc.nextLine();

		if (opt.equalsIgnoreCase("s")) {
			
			mountMachine(sc);
			
			runMachine(sc);

		} else if (opt.equalsIgnoreCase("i")) {
			
			String path = getPathFromUser(sc);
			mountMachine(path);
			
			runMachine(sc);

		} else {
			System.out.println("Ending the application...");
			System.exit(0);
		}

	}

	private String getPathFromUser(Scanner sc) {
		System.out.print("==== Write the path of the file who contains the commands and press enter button ====\n>");
		String output = sc.nextLine();

		return output;
	}

	
	private void mountMachine(Scanner userInput) {
		System.out.println("=========== When you end it, write 'end' and press enter button ==========\n");

		try {
			controller.mountMachine(userInput);
		} catch (DuplicatedTransitionException | MachineSyntaxException | StateNotFoundException e) {
			printException(e);
		}

	}

	private void mountMachine(String path) {

		try {
			controller.mountMachine(path);
		} catch (IOException | DuplicatedTransitionException | MachineSyntaxException | StateNotFoundException e) {
			printException(e);
		}

	}

	private void runMachine(Scanner userInput) {
		System.out.print("Now type the input word: \n>");
		try {
			controller.runMachine(userInput);
		} catch (Exception e) {
			printException(e);
		}

	}

	private void printHeader() {
		System.out.println(">>>>> Welcome to Turing Machine Simulator <<<<<\n");
		System.out.println(">>> Please follow the pattern(separated by spaces):");
		System.out.println("<current state> <current symbol> <new symbol> <direction> <new state>\n");
		System.out.println(">>> Using the syntax:");
		System.out.println(
				"> '!!' for the comments\n>q0, q1,..., qn, qA, qR for the states where\n  q0,qA and qR are initial state, acceptance state and rejected state");
		System.out.println(
				"> any character for <current symbol> and <new symbol>. The '_'(underline) to represent blank symbol");
		System.out.println(
				"> the <direction> should be 'l' to 'move left or 'r' to move right, '*' represents 'do not move'\n");
		System.out.print(
				">>> Press 'S' to start write your commands, 'I' to import the commands and 'E' to close the application: ");

	}

	private void printException(Exception e) {
		System.out.println(
				"Wasn't able to start the machine. Fix the problems and rerun the application. " + e.getMessage());
		System.exit(0);
	}

}
