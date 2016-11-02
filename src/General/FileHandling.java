package General;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {
	public static void main(String[] args) {
		try{			
			readFromFile("./src/General/input.txt");
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static void readFromFile(String fileName) throws IOException{
		FileReader file = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(file);
		String line;
		while((line = bufferedReader.readLine()) != null){
			System.out.println(line);
		}		
		bufferedReader.close();
	}
}
