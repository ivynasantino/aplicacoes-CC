package machine;

public class Configuration {
	
	private String currentState;
	private String currentTape;
	private String currentSteps;
	private String currentPosition;
	
	public Configuration(String currentState, String currentTape, String currentSteps, String currentPosition) {
		this.currentState = currentState;
		this.currentTape = currentTape;
		this.currentSteps = currentSteps;
		this.currentPosition = currentPosition;
	}
	
	public String getCurrentState() {
		return this.currentState;
	}

	public String getCurrentTape() {
		return this.currentTape;
	}

	public String getCurrentSteps() {
		return this.currentSteps;
	}

	public String getCurrentPosition() {
		return this.currentPosition;
	}	
	
	

}
