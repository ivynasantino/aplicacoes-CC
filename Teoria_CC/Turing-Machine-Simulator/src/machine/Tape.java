package machine;

import java.util.ArrayList;

public class Tape {
	
	private final String BLANK = "_";
	
	private ArrayList<String> input;
	private int position;
	
	public Tape() {
		this.position = 1;
		this.input = new ArrayList<String>();
	}
	
	public void insertOnTape(String input) {
		
		this.input.add(BLANK);
		if (input.equals("")) {
			this.input.add(BLANK);
			return;
		}
		for (String symbol : input.split("")) { //checar se o symbol é "_"
			this.input.add(symbol);
		}
		this.input.add(BLANK);
	}

	public String getPos() {
		return this.input.get(position);
	}
	
	public String getActualPosition() {
		return this.position + "";
	}
	
	public void move(String direction){
		if (direction.equalsIgnoreCase("l")) {
			this.position--;
		} else if(direction.equalsIgnoreCase("r")){
			this.position++;
		} else if(direction.equalsIgnoreCase("*")){
			// so pra ter certeza...
		} 
	}

	public void write(String writeSymbol) {
		if (!writeSymbol.equalsIgnoreCase("*")) {
			input.set(position, writeSymbol); 
		}
		
	}

	public String getTape() {
		String output = "";
		for (int i = 0; i <= input.size(); i++) {
			if (i==0) {
				output+="[" + input.get(i);
			} else if (i == input.size()) {
				output+="]";
			} else {
				output+="," + input.get(i);
			}
		}
		return output;
	}

}
