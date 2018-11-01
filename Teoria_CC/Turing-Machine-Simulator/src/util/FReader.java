package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FReader {
	
	public static ArrayList<String> readFile(String path) throws IOException {
		
		BufferedReader bReader = new BufferedReader(new FileReader(path));
		ArrayList<String> output = new ArrayList<>();
		
		while (bReader.ready()) {
			String line = bReader.readLine();
			output.add(line);
			System.out.println(line);
			
		}
		
		bReader.close();
		return output;
		
	}

}
